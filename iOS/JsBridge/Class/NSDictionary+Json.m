//
//  NSDictionary+Json.m
//  JsBridge
//
//  Created by 甘文鹏 on 2017/12/21.
//  Copyright © 2017年 ganwenpeng.com. All rights reserved.
//

#import "NSDictionary+Json.h"

@implementation NSDictionary (Json)
- (NSString *)jsonString {
    NSError *error;
    NSData *responseData = [NSJSONSerialization dataWithJSONObject:self options:NSJSONWritingPrettyPrinted error:&error];
    if (error) return nil;
    
    return [[NSString alloc] initWithData:responseData encoding:NSUTF8StringEncoding];
}
@end
