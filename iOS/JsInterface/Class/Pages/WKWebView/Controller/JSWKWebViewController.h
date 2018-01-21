//
//  JSWKWebViewController.h
//  JsBridge
//
//  Created by 甘文鹏 on 2017/12/20.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <WebKit/WebKit.h>

@interface JSWKWebViewController : UIViewController<WKNavigationDelegate>
@property(nonatomic, strong) WKWebView *webView;

- (void)btn1Click;
- (void)btn2Click;
@end
