//
//  JSUIBridgeViewController.m
//  JsInterface
//
//  Created by 甘文鹏 on 2018/1/3.
//  Copyright © 2018年 ganwenpeng.com. All rights reserved.
//

#import "JSUIBridgeViewController.h"
#import "NSDictionary+Json.h"


@interface JSUIBridgeViewController ()
@property(nonatomic, strong) WebViewJavascriptBridge* bridge;
@end

@implementation JSUIBridgeViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.title = @"UIWebView - JSBridge";
    
    // 初始化jsbridge对象
    [self setupJsBridge];
    
    // 加载测试用的HTML页面
    NSURL *url = [NSURL fileURLWithPath:[[NSBundle mainBundle] pathForResource:@"jsbridge" ofType:@"html"]];
    [self.webView loadRequest:[NSURLRequest requestWithURL:url]];
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
