# ANE-Usermail
check user email configuration adobe air native extension for ios and android


## Dependencies

- Apache [Flex SDK](http://flex.apache.org/installer.html) (or latest Adobe [AIR SDK](http://www.adobe.com/devnet/air/air-sdk-download.html)) 
- Android SDK Manager, part of [Android Studio](https://developer.android.com/studio/index.html)
- XCode 
- Ant

## Build steps

1. Download packages in Android SDK Manager
    - Download Android SDK build tools (rev 20)
    - Download Android 4.0.3 (API 15)

2. Edit ```build/build.config```
    - set valid ```air.sdk.home``` path 
    - set valid ```android.sdk.home``` path
    
3. Build bash commands
    1. ```cd build``` 
    2. ```ant```
        
## Usage
 1. Add to you project **UserMail.ane** from ```bin``` directory
 2. Add ```<uses-permission android:name="android.permission.GET_ACCOUNTS" />``` to AIR Application Descriptor File
```
    <android>
        <manifestAdditions>
            <![CDATA[
            <manifest android:installLocation="auto">
                <uses-permission android:name="android.permission.GET_ACCOUNTS" />
            </manifest>
            ]]>
            </manifestAdditions>
    </android>
    ```
    
 3. ```UserMail.isAvalable()``` returned ```false``` or ```true``` if user mail avalable 

[Example test application class](https://github.com/gleba/ANE-Usermail/blob/master/testapp/src/Main.as)
