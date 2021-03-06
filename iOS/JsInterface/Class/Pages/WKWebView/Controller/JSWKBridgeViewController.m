//
//  JSWKBridgeViewController.m
//  JsInterface
//
//  Created by 甘文鹏 on 2018/1/3.
//  Copyright © 2018年 ganwenpeng.com. All rights reserved.
//

#import "JSWKBridgeViewController.h"
#import <WebViewJavascriptBridge/WebViewJavascriptBridge.h>
#import "NSDictionary+Json.h"

@interface JSWKBridgeViewController ()
@property(nonatomic, strong) WebViewJavascriptBridge* bridge;
@end

@implementation JSWKBridgeViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.title = @"WKWebView - JSBridge";
    
    // 初始化jsbridge对象
    [self setupJsBridge];
    
    // 加载测试用的HTML页面
    NSURL *url = [NSURL fileURLWithPath:[[NSBundle mainBundle] pathForResource:@"jsbridge" ofType:@"html"]];
    [self.webView loadRequest:[NSURLRequest requestWithURL:url]];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

- (void)btn1Click {
    [self.bridge callHandler:@"jsbridge_showMessage" data:@"点击了原生的按钮111111111111" responseCallback:nil];
}

- (void)btn2Click {
    [self.bridge callHandler:@"jsbridge_getJsMessage" data:@"点击了原生的按钮222222222" responseCallback:^(id responseData) {
        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"显示jsbridge返回值" message:responseData delegate:nil cancelButtonTitle:@"好" otherButtonTitles:nil, nil];
        [alert show];
    }];
}

- (void)setupJsBridge {
    if (self.bridge) return;
    
    self.bridge = [WebViewJavascriptBridge bridgeForWebView:self.webView];
    
    [self.bridge registerHandler:@"getOS" handler:^(id data, WVJBResponseCallback responseCallback) {
        // 这里Response的回调可以传id类型数据，但是为了保持Android、iOS的统一，全部使用json字符串作为返回数据
        NSDictionary *response = @{@"error": @(0), @"message": @"", @"data": @{@"os": @"ios"}};
        responseCallback([response jsonString]);
    }];
    
    [self.bridge registerHandler:@"login" handler:^(id data, WVJBResponseCallback responseCallback) {
        if (data == nil || ![data isKindOfClass:[NSDictionary class]]) {
            NSDictionary *response = @{@"error": @(-1), @"message": @"调用参数有误"};
            responseCallback([response jsonString]);
            return;
        }
        
        NSString *account = data[@"account"];
        NSString *passwd = data[@"password"];
        NSDictionary *response = @{@"error": @(0), @"message": @"登录成功", @"data" : [NSString stringWithFormat:@"执行登录操作，账号为：%@、密码为：@%@", account, passwd]};
        responseCallback([response jsonString]);
    }];
}
@end
