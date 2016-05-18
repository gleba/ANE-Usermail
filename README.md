# ANE-Usermail
check user email configuration


## Dependencies

- Apache [Flex SDK](http://flex.apache.org/installer.html) (or latest Adobe [AIR SDK](http://www.adobe.com/devnet/air/air-sdk-download.html)) 
- Android SDK Manager, part of [Android Studio](https://developer.android.com/studio/index.html)
- XCode 
- Ant

## Build steps

1. Download packages in Android SDK Manager
    - Download Android SDK build tools (rev 20)
    - Download Android 4.0.3 (API 15)

2. edit ```build/build.config```
    - set valid ```air.sdk.home``` path 
    - set valid ```android.sdk.home``` path
    
3. build bash commands
    1. ```cd build``` 
    2. ```ant```
        
## Usage
 1. Add UserMail.ane to project
 2. ```UserMail.isAvalable()``` returned false or true if user mail avalable 


example app