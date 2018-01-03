//
//  JSWKWebViewController.m
//  JsBridge
//
//  Created by 甘文鹏 on 2017/12/20.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import "JSWKWebViewController.h"

@interface JSWKWebViewController ()

@end

@implementation JSWKWebViewController

- (void)loadView {
    self.webView = [[WKWebView alloc] init];
    self.webView.navigationDelegate = self;
    self.view = self.webView;
}

@end
