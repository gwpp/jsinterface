
//
//  JSHomeTableViewCell.m
//  JsInterface
//
//  Created by 甘文鹏 on 12/01/2018.
//  Copyright © 2018 ganwenpeng.com. All rights reserved.
//

#import "JSHomeTableViewCell.h"

@implementation JSHomeTableViewCell

- (void)awakeFromNib {
    [super awakeFromNib];
    
    self.typeLabel.text = nil;
    self.jsCallNativeLabel.text = nil;
    self.nativeCallJsLabel.text = nil;
}

- (void)setSelected:(BOOL)selected animated:(BOOL)animated {
    [super setSelected:selected animated:animated];

    // Configure the view for the selected state
}

@end
