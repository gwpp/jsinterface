//
//  JSHomeTableViewCell.h
//  JsInterface
//
//  Created by 甘文鹏 on 12/01/2018.
//  Copyright © 2018 ganwenpeng.com. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface JSHomeTableViewCell : UITableViewCell
@property (weak, nonatomic) IBOutlet UILabel *typeLabel;
@property (weak, nonatomic) IBOutlet UILabel *jsCallNativeLabel;
@property (weak, nonatomic) IBOutlet UILabel *nativeCallJsLabel;

@end
