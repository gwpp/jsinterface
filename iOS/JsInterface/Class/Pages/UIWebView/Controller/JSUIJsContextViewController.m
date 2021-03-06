//
//  JSUIJsContextViewController.m
//  JsInterface
//
//  Created by 甘文鹏 on 2018/1/3.
//  Copyright © 2018年 ganwenpeng.com. All rights reserved.
//

#import "JSUIJsContextViewController.h"
#import <JavaScriptCore/JavaScriptCore.h>
#import "JSContextModel.h"

@interface JSUIJsContextViewController ()
@property(nonatomic, strong) JSContext *jsContext;
@end

@implementation JSUIJsContextViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.title = @"UIWebView - JSContext";
    
    // 加载测试用的HTML页面
    NSURL *url = [NSURL fileURLWithPath:[[NSBundle mainBundle] pathForResource:@"jscontext" ofType:@"html"]];
    [self.webView loadRequest:[NSURLRequest requestWithURL:url]];
}

- (void)btn1Click {
    [self.jsContext evaluateScript:@"showResponse('点击了按钮1111111111111111')"];
}

- (void)btn2Click {
    JSValue *value = self.jsContext[@"showResponse"];
    [value callWithArguments:@[@"点击了按钮222222222"]];
}

#pragma mark - UIWebViewDelegate
- (void)webViewDidFinishLoad:(UIWebView *)webView {
    self.jsContext = [webView valueForKeyPath:@"documentView.webView.mainFrame.javaScriptContext"];
    self.jsContext.exceptionHandler = ^(JSContext *context, JSValue *exception) {
        context.exception = exception;
        NSLog(@"异常信息：%@", exception);
    };
    self.jsContext[@"app"] = [[JSContextModel alloc] init];
}
@end
