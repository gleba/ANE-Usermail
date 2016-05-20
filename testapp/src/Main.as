package {

import com.starfall.ane.UserMail;

import flash.display.Sprite;
import flash.events.MouseEvent;
import flash.system.Capabilities;
import flash.text.TextField;

public class Main extends Sprite {
    var textField:TextField = new TextField();

    public function Main() {

        UserMail.instance.addAndroidAccountType("com.yandex.passport");
        UserMail.instance.addAndroidAccountType("ru.mail.mailapp");
        UserMail.instance.addAndroidAccountType("com.sfr.android.sfrmail");
        UserMail.instance.addAndroidAccountType("com.cloudmagic.mail");
//        ...etc

        textField.height = Capabilities.screenResolutionY;
        textField.width = Capabilities.screenResolutionX;
        textField.y = textField.x = 10;
        textField.text = check();
        trace(check());
        addChild(textField);
        addEventListener(MouseEvent.CLICK, clickHandler);
        UserMail.instance.logger = function (log:String):void {
            textField.appendText("\n" + log)
        }
    }

    private var i:int = 0

    private function clickHandler(event:MouseEvent):void {
        if (i > 2) {
            i = 0;
            textField.text = ""
        }
        i++;
        textField.appendText("\n" + check())
    }

    private function check():String {
        return "UserMail.isAvalable():  " + UserMail.isAvalable();
    }
}
}