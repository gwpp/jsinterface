//
//  NSURL+Params.m
//  JsInterface
//
//  Created by 甘文鹏 on 2018/1/3.
//  Copyright © 2018年 ganwenpeng.com. All rights reserved.
//

#import "NSURL+Params.h"

@implementation NSURL (Params)
- (NSDictionary *)getURLParams {
    NSString *queryString = self.query;
    NSArray *paramsArr = [queryString componentsSeparatedByString:@"&"];
    NSMutableDictionary *paramsDict = [NSMutableDictionary dictionary];
    for (NSString *item in paramsArr) {
        NSArray *kv = [item componentsSeparatedByString:@"="];
        if (kv.count == 2) {
            paramsDict[kv[0]] = kv[1];
        }
    }
    return [NSDictionary dictionaryWithDictionary:paramsDict];
}
@end
