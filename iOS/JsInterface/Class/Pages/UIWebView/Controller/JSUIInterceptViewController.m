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
    
    
}

#pragma mark - UIWebViewDelegate
- (BOOL)webView:(UIWebView *)webView shouldStartLoadWithRequest:(NSURLRequest *)request navigationType:(UIWebViewNavigationType)navigationType {
    NSString *url = request.URL.absoluteString;
    if ([url containsString:@"app://login"]) {
        NSDictionary *paramsDict = [request.URL getURLParams];
        NSString *account = paramsDict[@"account"];
        NSString *password = paramsDict[@"password"];
        
        // 下面就开始执行登录
        // ...
        return NO;
    }
    return YES;
}

@end
