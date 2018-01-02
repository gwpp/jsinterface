//
//  JSHomeModel.h
//  JsInterface
//
//  Created by 甘文鹏 on 2017/12/28.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//  首页控制器上的数据模型

#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>

@interface JSHomeModel : NSObject
/**
 * 标题
 */
@property(nonatomic, copy) NSString *title;

/**
 * 点击后跳转的控制器的Class
 */
@property(nonatomic, copy) Class targetClass;

/**
 * 构造方法，快速构建HomeModel
 * @param title 标题
 * @param targetClass 点击某一行后跳转的控制器的Class
 * @return 构造好的HomeModel
 */
- (instancetype)initWithTitle:(NSString *)title targetClass:(Class)targetClass;
@end
