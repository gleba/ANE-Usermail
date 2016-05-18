#import "UserMail.h"

@import MessageUI;

void UserMailInitializer(void** extDataToSet, FREContextInitializer* ctxInitializerToSet, FREContextFinalizer* ctxFinalizerToSet)
{
    NSLog(@"UserMailExtInitializer");
    *extDataToSet = NULL;

    *ctxInitializerToSet = &ContextInitializer;
    *ctxFinalizerToSet = &ContextFinalizer;
}

void UserMailFinalizer(void* extData)
{
    //    NSLog(@"ExtFinalizer");
}




void ContextInitializer(void* extData, const uint8_t* ctxType, FREContext ctx, uint32_t* numFunctionsToTest, const FRENamedFunction** functionsToSet)
{
    static FRENamedFunction func[] =
    {
        { (const uint8_t*)"canSend", NULL, canSend }
    };
    *numFunctionsToTest = sizeof(func) / sizeof(FRENamedFunction);
    *functionsToSet = func;
}

void ContextFinalizer(FREContext ctx)
{
    return;
}



FREObject canSend(FREContext ctx, void *data, uint32_t argc, FREObject argv[])
{
    BOOL result;
    
    if ([MFMailComposeViewController canSendMail]) {
        result = YES;
    } else {
        result = NO;
    }
    
    FREObject freResult;
    FRENewObjectFromBool(result, &freResult);
    return freResult;
}