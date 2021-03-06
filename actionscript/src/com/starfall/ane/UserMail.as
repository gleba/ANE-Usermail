package com.starfall.ane {
import flash.events.StatusEvent;
import flash.external.ExtensionContext;
import flash.system.Capabilities;


public class UserMail {
    private static var extContext:ExtensionContext = null;
    private static var _instance:UserMail = null;
    private static var _shouldCreateInstance:Boolean = false;


    public static function get instance():UserMail {

        if (_instance == null) {
            _shouldCreateInstance = true;
            _instance = new UserMail();
            _shouldCreateInstance = false;
        }
        return _instance;
    }

    public static function isAvalable():Object {
        return instance.isAvalable();
    }


    public function UserMail() {
        if (useNativeExtension()) {
            trace("Extension Context Created Constructor");
            extContext = ExtensionContext.createExtensionContext("com.starfall.ane.UserMail", null);
            extContext.addEventListener(StatusEvent.STATUS, extContext_statusHandler);
        }
        else {
            trace("ERROR CONTEXT NOT INITIALIZED!!");
        }
    }

    public function isAvalable():Boolean {
        if (useNativeExtension()) {
            var result:Boolean = false;
            if (extContext)
                try {
                    result = extContext.call("canSend")
                } catch (e:Error) {
                    return false
                }
            return result
        } else {
            return false
        }
    }

    public var logger:Function;

    public function addAndroidAccountType(type:String):void {
        if (Capabilities.manufacturer.indexOf("Android") > -1) {
            if (extContext)
                extContext.call("addType", type)
        }
    }

    private function extContext_statusHandler(event:StatusEvent):void {
        trace("ane:" + event.level);
        if (logger != null) logger(event.level)
    }


    private function useNativeExtension():Boolean {
        return Capabilities.manufacturer.indexOf("iOS") > -1 || Capabilities.manufacturer.indexOf("Android") > -1;
    }

}
}