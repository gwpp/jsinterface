//
//  JSUIWebViewController.h
//  JsBridge
//
//  Created by 甘文鹏 on 2017/12/20.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import <UIKit/UIKit.h>
#import <WebViewJavascriptBridge/WebViewJavascriptBridge.h>

@interface JSUIWebViewController : UIViewController<UIWebViewDelegate>
@property(nonatomic, strong) UIWebView *webView;
@end
