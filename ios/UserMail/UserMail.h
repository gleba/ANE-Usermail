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



/////// Шаг первый. Глобальная инициализация кмопонента **************

// Создание компонента
void UserMailInitializer(void** extDataToSet, FREContextInitializer* ctxInitializerToSet, FREContextFinalizer* ctxFinalizerToSet);

// Уничтожение компонента
void UserMailFinalizer(void* extData);





/////// Шаг второй. Локальная инициализация **************

// Создание компонента
void ContextInitializer(void* extData, const uint8_t* ctxType, FREContext ctx, uint32_t* numFunctionsToTest, const FRENamedFunction** functionsToSet);

// Уничтожение компонента
void ContextFinalizer(FREContext ctx);





/////// Шаг третий. API компонента для вашего приложения **************

// Метод который будет доступен из flash-приложения
FREObject canSend(FREContext ctx, void *data, uint32_t argc, FREObject argv[]);

