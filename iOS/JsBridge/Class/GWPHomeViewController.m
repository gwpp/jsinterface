//
//  GWPHomeViewController.m
//  JsBridge
//
//  Created by 甘文鹏 on 2017/12/20.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import "GWPHomeViewController.h"
#import "GWPUIWebViewController.h"
#import "GWPWKWebViewController.h"

@interface GWPHomeViewController ()

@end

@implementation GWPHomeViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (IBAction)gotoUIWebView {
    [self.navigationController pushViewController:[[GWPUIWebViewController alloc] init] animated:YES];
}

- (IBAction)gotoWKWebView {
    [self.navigationController pushViewController:[[GWPWKWebViewController alloc] init] animated:YES];
}
@end
