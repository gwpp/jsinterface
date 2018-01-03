//
//  JSUIWebViewController.m
//  JsBridge
//
//  Created by 甘文鹏 on 2017/12/20.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import "JSUIWebViewController.h"

@interface JSUIWebViewController ()
@end

@implementation JSUIWebViewController
- (void)loadView {
    self.webView = [[UIWebView alloc] init];
    self.webView.delegate = self;
    self.view = self.webView;
}

- (void)viewDidLoad {
    [super viewDidLoad];
}

@end
