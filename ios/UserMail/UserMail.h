//
//  UserMail.h
//  UserMail
//
//  Created by Flower on 18.05.16.
//  Copyright © 2016 Flexis. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "FlashRuntimeExtensions.h"
@import MessageUI;

void UserMailInitializer(void** extDataToSet, FREContextInitializer* ctxInitializerToSet, FREContextFinalizer* ctxFinalizerToSet);
void UserMailFinalizer(void* extData);
void ContextInitializer(void* extData, const uint8_t* ctxType, FREContext ctx, uint32_t* numFunctionsToTest, const FRENamedFunction** functionsToSet);
void ContextFinalizer(FREContext ctx);

FREObject canSend(FREContext ctx, void *data, uint32_t argc, FREObject argv[]);

