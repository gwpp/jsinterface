//
//  JSUIInterceptViewController.m
//  JsInterface
//
//  Created by 甘文鹏 on 2018/1/3.
//  Copyright © 2018年 ganwenpeng.com. All rights reserved.
//

#import "JSUIInterceptViewController.h"
#import "NSURL+Params.h"

@interface JSUIInterceptViewController ()

@end

@implementation JSUIInterceptViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    self.title = @"UIWebView - 拦截跳转";

    // 加载测试用的HTML页面
    NSURL *url = [NSURL fileURLWithPath:[[NSBundle mainBundle] pathForResource:@"intercept" ofType:@"html"]];
    [self.webView loadRequest:[NSURLRequest requestWithURL:url]];
}

#pragma mark - UIWebViewDelegate
- (BOOL)webView:(UIWebView *)webView shouldStartLoadWithRequest:(NSURLRequest *)request navigationType:(UIWebViewNavigationType)navigationType {
    
    NSString *scheme = request.URL.scheme;
    NSString *host = request.URL.host;
    
    // 一般用作交互的链接都会有一个固定的协议头，这里我们一“app”作为协议头为了，实际项目中可以修改
    if ([scheme isEqualToString:@"app"]) { // scheme为“app”说明是做交互的链接
        if ([host isEqualToString:@"login"]) { // host为“login”对应的就是登录操作
            NSDictionary *paramsDict = [request.URL getURLParams];
            NSString *account = paramsDict[@"account"];
            NSString *password = paramsDict[@"password"];
            
            NSString *msg = [NSString stringWithFormat:@"执行登录操作，账号为：%@，密码为：%@", account, password];
            UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"原生弹窗" message:msg delegate:nil cancelButtonTitle:@"好" otherButtonTitles:nil, nil];
            [alert show];
        } else if ([host isEqualToString:@"share"]) { // host为“share”对应的就是分享操作
            NSDictionary *paramsDict = [request.URL getURLParams];
            NSString *title = [paramsDict[@"title"] stringByRemovingPercentEncoding];
            NSString *desc = [paramsDict[@"desc"] stringByRemovingPercentEncoding];
            
            NSString *msg = [NSString stringWithFormat:@"执行分享操作，title为：【%@】，desc为：【%@】", title, desc];
            UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"原生弹窗" message:msg delegate:nil cancelButtonTitle:@"好" otherButtonTitles:nil, nil];
            [alert show];
        }
        // ... 这里可以继续加
        
        return NO;
    }
//    [webView stringByEvaluatingJavaScriptFromString:<#(nonnull NSString *)#>];
    return YES;
}

@end
