# ANE-Usermail
check user email configuration


## Dependencies

- Apache [Flex SDK](http://flex.apache.org/installer.html) (or latest Adobe [AIR SDK](http://www.adobe.com/devnet/air/air-sdk-download.html)) 
- Android SDK Manager, part of [Android Studio](https://developer.android.com/studio/index.html)
- XCode 
- Ant

## Build steps
a. Download packages in Android SDK Manager
    1. Download Android SDK build tools (rev 20)
    2. Download Android 4.0.3 (API 15)

b. edit ```build/build.config```
        1. set valid ```air.sdk.home``` path 
        2. set valid ```android.sdk.home``` path
    
c. build bash commands
        1. ```cd build``` 
        2. ```ant```
        
## Usage
 - Add UserMail.ane to project 
 - Call ```UserMail.isAvalable()``` in AS3 Class