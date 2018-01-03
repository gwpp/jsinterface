//
//  JSContextModel.h
//  JsInterface
//
//  Created by 甘文鹏 on 2018/1/3.
//  Copyright © 2018年 ganwenpeng.com. All rights reserved.
//

#import <Foundation/Foundation.h>
#import <JavaScriptCore/JavaScriptCore.h>

@protocol JsContextExport<JSExport>
/**
 * 登出方法，js调用的方法名也是logout
 */
- (void)logout;

/**
 * 登录方法，JSExportAs的作用就是给OC方法导出一个js方法名，例如下面的方法js调用就是 login("your account", "your password")。在多参数的方法声明时必须使用这种方式
 */
JSExportAs(login, - (void)loginWithAccount:(NSString *)account password:(NSString *)password);

/**
 * 获取登录信息
 * @return 当前登录用户的身份信息。JSContext方式调用OC时，方法的返回值只能是NSString、NSArray、NSDictionary、NSNumber、BooL，其他类型不能解析
 */
- (NSDictionary *)getLoginUser;
@end

@interface JSContextModel : NSObject<JsContextExport>

@end
