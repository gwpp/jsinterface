//
//  JSHomeModel.m
//  JsInterface
//
//  Created by 甘文鹏 on 2017/12/28.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import "JSHomeModel.h"

@implementation JSHomeModel
- (instancetype)initWithTitle:(NSString *)title targetClass:(Class)targetClass {
    JSHomeModel *homeModel = [[JSHomeModel alloc] init];
    homeModel.title = title;
    homeModel.targetClass = targetClass;
    return homeModel;
}
@end
