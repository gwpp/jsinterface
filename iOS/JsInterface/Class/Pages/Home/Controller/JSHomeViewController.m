//
//  JSHomeViewController.m
//  JsBridge
//
//  Created by 甘文鹏 on 2017/12/20.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import "JSHomeViewController.h"
#import "JSHomeModel.h"

#import "JSUIInterceptViewController.h"
#import "JSUIJsContextViewController.h"
#import "JSUIBridgeViewController.h"

#import "JSWKInterceptViewController.h"
#import "JSWKBridgeViewController.h"

#import "JSHomeTableViewCell.h"

@interface JSHomeViewController ()
/**
 * 列表数据
 */
@property(nonatomic, strong) NSArray<NSArray<JSHomeModel *> *> *modelArray;
@end

@implementation JSHomeViewController

- (instancetype)initWithStyle:(UITableViewStyle)style {
    return self = [super initWithStyle:UITableViewStyleGrouped];
}

- (void)viewDidLoad {
    [super viewDidLoad];

    self.title = @"iOS & H5 交互";
    self.navigationItem.backBarButtonItem = [[UIBarButtonItem alloc] initWithTitle:@"返回" style:UIBarButtonItemStyleDone target:nil action:nil];
    [self.tableView registerNib:[UINib nibWithNibName:NSStringFromClass([JSHomeTableViewCell class]) bundle:nil] forCellReuseIdentifier:NSStringFromClass([JSHomeTableViewCell class])];
}

- (NSArray<NSArray<JSHomeModel *> *> *)modelArray {
    if (!_modelArray) {
        JSHomeModel *uiwebviewIntercept = [[JSHomeModel alloc] initWithType:@"UIWebView" jsCallNative:@"拦截跳转" nativeCallJS:@"stringByEvaluatingJavaScriptFromString:" targetClass:[JSUIInterceptViewController class]];
        JSHomeModel *wkwebviewIntercept = [[JSHomeModel alloc] initWithType:@"WKWebView" jsCallNative:@"拦截跳转" nativeCallJS:@"evaluateJavaScript:completionHandler" targetClass:[JSWKInterceptViewController class]];

        JSHomeModel *uiwebviewJsContext = [[JSHomeModel alloc] initWithType:@"UIWebView" jsCallNative:@"JsContextExport" nativeCallJS:@"evaluateScript: 或 callWithArguments:" targetClass:[JSUIJsContextViewController class]];

        JSHomeModel *uiJsbridge = [[JSHomeModel alloc] initWithType:@"UIWebView" jsCallNative:@"WebViewJavascriptBridge" nativeCallJS:@"callHandler" targetClass:[JSUIBridgeViewController class]];
        JSHomeModel *wkJsbridge = [[JSHomeModel alloc] initWithType:@"WKWebView" jsCallNative:@"WebViewJavascriptBridge" nativeCallJS:@"callHandler" targetClass:[JSWKBridgeViewController class]];

        _modelArray = @[
                @[uiwebviewIntercept, wkwebviewIntercept],
                @[uiwebviewJsContext],
                @[uiJsbridge, wkJsbridge],
        ];
    }
    return _modelArray;
}

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return self.modelArray.count;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.modelArray[section].count;
}

- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    JSHomeTableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:NSStringFromClass([JSHomeTableViewCell class])];
    JSHomeModel *model = self.modelArray[indexPath.section][indexPath.row];
    cell.typeLabel.text = model.webViewType;
    cell.jsCallNativeLabel.text = model.jsCallNative;
    cell.nativeCallJsLabel.text = model.nativeCallJs;

    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    JSHomeModel *model = self.modelArray[indexPath.section][indexPath.row];
    
    UIViewController *vc = (UIViewController *)[[model.targetClass alloc] init];

    [self.navigationController pushViewController:vc animated:YES];
}
@end
