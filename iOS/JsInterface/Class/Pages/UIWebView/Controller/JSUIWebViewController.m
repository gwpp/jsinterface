//
//  JSUIWebViewController.m
//  JsBridge
//
//  Created by 甘文鹏 on 2017/12/20.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import "JSUIWebViewController.h"
#import <Masonry/Masonry.h>

@interface JSUIWebViewController ()
@property(nonatomic, weak) UIButton *btn1;
@property(nonatomic, weak) UIButton *btn2;
@end

@implementation JSUIWebViewController
- (void)viewDidLoad {
    [super viewDidLoad];
    
    [self setupUI];
}

- (void)setupUI {
    self.edgesForExtendedLayout = UIRectEdgeNone;
    
    UIView *origin = [[UIView alloc] init];
    origin.backgroundColor = [UIColor whiteColor];
    [self.view addSubview:origin];
    [origin mas_makeConstraints:^(MASConstraintMaker *make) {
        make.left.top.right.equalTo(self.view);
        make.height.mas_equalTo(100);
    }];
    
    UILabel *titleLabel = [[UILabel alloc] init];
    titleLabel.textColor = [UIColor redColor];
    [origin addSubview:titleLabel];
    [titleLabel mas_makeConstraints:^(MASConstraintMaker *make) {
        make.left.top.equalTo(self.view).with.offset(8);
        make.right.equalTo(self.view).with.offset(-8);
    }];
    titleLabel.text = @"原生区域";
    
    UIButton *btn1 = [[UIButton alloc] init];
    btn1.backgroundColor = [UIColor grayColor];
    [btn1 setTitle:@"按钮1" forState:UIControlStateNormal];
    [origin addSubview:btn1];
    [btn1 mas_makeConstraints:^(MASConstraintMaker *make) {
        make.centerY.equalTo(origin).with.offset(8);
        make.left.equalTo(origin).with.offset(8);
        make.size.mas_equalTo(CGSizeMake(100, 40));
    }];
    [btn1 addTarget:self action:@selector(btn1Click) forControlEvents:UIControlEventTouchUpInside];
    self.btn1 = btn1;
    
    UIButton *btn2 = [[UIButton alloc] init];
    btn2.backgroundColor = [UIColor grayColor];
    [btn2 setTitle:@"按钮2" forState:UIControlStateNormal];
    [origin addSubview:btn2];
    [btn2 mas_makeConstraints:^(MASConstraintMaker *make) {
        make.centerY.equalTo(btn1);
        make.left.equalTo(btn1.mas_right).with.offset(8);
        make.size.mas_equalTo(CGSizeMake(100, 40));
    }];
    [btn2 addTarget:self action:@selector(btn2Click) forControlEvents:UIControlEventTouchUpInside];
    self.btn2 = btn2;
    
    self.view.backgroundColor = [UIColor blackColor];
    self.webView = [[UIWebView alloc] init];
    self.webView.delegate = self;
    [self.view addSubview:self.webView];
    [self.webView mas_makeConstraints:^(MASConstraintMaker *make) {
        make.left.bottom.right.equalTo(self.view);
        make.top.equalTo(origin.mas_bottom).with.offset(1);
    }];
}

- (void)btn1Click {
    
}

- (void)btn2Click {
    
}
@end
