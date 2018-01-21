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
 * WebView的类型描述
 */
@property(nonatomic, copy) NSString *webViewType;
/**
 * JS调用Native的方式
 */
@property(nonatomic, copy) NSString *jsCallNative;
/**
 * Native调用JS的方式
 */
@property(nonatomic, copy) NSString *nativeCallJs;

/**
 * 点击后跳转的控制器的Class
 */
@property(nonatomic, copy) Class targetClass;

/**
 * 构造方法
 * @param type WebView的类型
 * @param jsCallNative JS调用Native的方式
 * @param nativeCallJS Native调用JS的方式
 * @param targetClass 点击后跳转的控制器
 * @return 构造后的对象
 */
- (instancetype)initWithType:(NSString *)type jsCallNative:(NSString *)jsCallNative nativeCallJS:(NSString *)nativeCallJS targetClass:(Class)targetClass;
@end
