//
//  JSWKWebViewController.h
//  JsBridge
//
//  Created by 甘文鹏 on 2017/12/20.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import <UIKit/UIKit.h>

typedef NS_ENUM(NSInteger, WKWebViewShowType) {
    WKWebViewShowTypeIntercept,         // 拦截跳转链接
    WKWebViewShowTypeJsBridgeCallApp,   // 通过JsBridge，JS调用APP
    WKWebViewShowTypeJsBridgeCallJs,    // 通过JsBridge，APP调用JS
};

@interface JSWKWebViewController : UIViewController
/**
 * 包含展示类型的构造函数
 * @param showType 页面展示类型
 * @return 构造好的控制器
 */

- (instancetype)initWithShowType:(WKWebViewShowType)showType;
@end
