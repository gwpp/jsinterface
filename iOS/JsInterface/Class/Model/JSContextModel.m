//
//  JSContextModel.m
//  JsInterface
//
//  Created by 甘文鹏 on 2018/1/3.
//  Copyright © 2018年 ganwenpeng.com. All rights reserved.
//

#import "JSContextModel.h"
#import <UIKit/UIKit.h>

@implementation JSContextModel
- (void)logout {
    [[NSOperationQueue mainQueue] addOperationWithBlock:^{
        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"原生弹窗" message:@"执行【登出】操作" delegate:nil cancelButtonTitle:@"好" otherButtonTitles:nil, nil];
        [alert show];
    }];
}

- (void)loginWithAccount:(NSString *)account password:(NSString *)password {
    NSString *msg = [NSString stringWithFormat:@"执行登录操作，账号为：%@，密码为：%@", account, password];
    [[NSOperationQueue mainQueue] addOperationWithBlock:^{
        UIAlertView *alert = [[UIAlertView alloc] initWithTitle:@"原生弹窗" message:msg delegate:nil cancelButtonTitle:@"好" otherButtonTitles:nil, nil];
        [alert show];
    }];
}

- (NSDictionary *)getLoginUser {
    return @{
             @"user_id": @(666),
             @"username": @"你就说6不6",
             @"sex": @"未知",
             @"isStudent": @(NO)
             };
}

@end
