//
//  JSWKWebKitViewController.m
//  JsInterface
//
//  Created by 甘文鹏 on 2018/2/7.
//  Copyright © 2018年 ganwenpeng.com. All rights reserved.
//

#import "JSWKWebKitViewController.h"

#define FUNC_LOGIN @"login"
#define FUNC_LOGOUT @"logout"

@interface JSWKWebKitViewController ()<WKScriptMessageHandler>

@end

@implementation JSWKWebKitViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.title = @"WKWebView - WebKti";
    WKUserContentController *confVc = self.webView.configuration.userContentController;
    [confVc addScriptMessageHandler:self name:FUNC_LOGIN];
    [confVc addScriptMessageHandler:self name:FUNC_LOGOUT];
    
    // 加载测试用的HTML页面
    NSURL *url = [NSURL fileURLWithPath:[[NSBundle mainBundle] pathForResource:@"webkit" ofType:@"html"]];
    [self.webView loadRequest:[NSURLRequest requestWithURL:url]];
}

- (void)btn1Click {
    [self.webView evaluateJavaScript:@"showResponse('点击了原生的按钮11111111111')" completionHandler:nil];
}

- (void)btn2Click {
    [self.webView evaluateJavaScript:@"showResponse('点击了原生的按钮22222222222')" completionHandler:^(id _Nullable response, NSError * _Nullable error) {
        if (error) {
            NSLog(@"%@", error);
        } else {
            NSLog(@"%@", response);
        }
    }];
}

#pragma mark - WKScriptMessageHandler
- (void)userContentController:(WKUserContentController *)userContentController didReceiveScriptMessage:(WKScriptMessage *)message {
    if ([message.name isEqualToString:FUNC_LOGIN]) {
        if (![message.body isKindOfClass:[NSDictionary class]]) {
            return;
        }
        NSDictionary *data = message.body;
        NSString *account = data[@"account"];
        NSString *password = data[@"password"];
        
        NSString *msg = [NSString stringWithFormat:@"执行登录操作，账号为：%@，密码为：%@", account, password];
        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"原生弹窗" message:msg delegate:nil cancelButtonTitle:@"好" otherButtonTitles:nil, nil];
        [alert show];
        return;
    }
    
    if ([message.name isEqualToString:FUNC_LOGOUT]) {
        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"原生弹窗" message:@"执行登出操作" delegate:nil cancelButtonTitle:@"好" otherButtonTitles:nil, nil];
        [alert show];
        return;
    }
}
@end
