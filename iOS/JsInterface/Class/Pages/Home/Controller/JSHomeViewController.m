//
//  JSHomeViewController.m
//  JsBridge
//
//  Created by 甘文鹏 on 2017/12/20.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import "JSHomeViewController.h"
#import "JSUIWebViewController.h"
#import "JSWKWebViewController.h"
#import "JSHomeModel.h"

#import "JSUIInterceptViewController.h"
#import "JSUIJsContextViewController.h"
#import "JSUIBridgeCallAppViewController.h"
#import "JSUIBridgeCallJSViewController.h"

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
}

- (NSArray<NSArray<JSHomeModel *> *> *)modelArray {
    if (!_modelArray) {
        JSHomeModel *uiwebviewIntercept = [[JSHomeModel alloc] initWithTitle:@"JS调用APP方法 - 拦截跳转 - UIWebView" targetClass:[JSUIInterceptViewController class]];
        JSHomeModel *wkwebviewIntercept = [[JSHomeModel alloc] initWithTitle:@"JS调用APP方法 - 拦截跳转 - WKWebView" targetClass:[JSWKWebViewController class]];

        JSHomeModel *uiwebviewJsContext = [[JSHomeModel alloc] initWithTitle:@"JS调用APP方法 - JSContext - UIWebView" targetClass:[JSUIJsContextViewController class]];

        JSHomeModel *wkJsbridgeCallApp = [[JSHomeModel alloc] initWithTitle:@"JS调用APP方法 - JsBridge - WKWebView" targetClass:[JSWKWebViewController class]];
        JSHomeModel *uiJsbridgeCallApp = [[JSHomeModel alloc] initWithTitle:@"JS调用APP方法 - JsBridge - UIWebView" targetClass:[JSUIBridgeCallAppViewController class]];

        JSHomeModel *wkJsbridgeCallJS = [[JSHomeModel alloc] initWithTitle:@"APP调用JS方法 - JsBridge - WKWebView" targetClass:[JSWKWebViewController class]];
        JSHomeModel *uiJsbridgeCallJS = [[JSHomeModel alloc] initWithTitle:@"APP调用JS方法 - JsBridge - UIWebView" targetClass:[JSUIBridgeCallJSViewController class]];

        _modelArray = @[
                @[uiwebviewIntercept, wkwebviewIntercept],
                @[uiwebviewJsContext],
                @[uiJsbridgeCallApp, wkJsbridgeCallApp],
                @[uiJsbridgeCallJS, wkJsbridgeCallJS]
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
    static NSString *identify = @"ID";
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:identify];
    if (!cell) {
        cell = [[UITableViewCell alloc] initWithStyle:UITableViewCellStyleValue1 reuseIdentifier:identify];
    }
    cell.textLabel.text = self.modelArray[indexPath.section][indexPath.row].title;
    return cell;
}

- (void)tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    JSHomeModel *model = self.modelArray[indexPath.section][indexPath.row];
    
    UIViewController *vc = [[model.targetClass alloc] init];
    vc.title = model.title;
    
    [self.navigationController pushViewController:vc animated:YES];
}
@end
