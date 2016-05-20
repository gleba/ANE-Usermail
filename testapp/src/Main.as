package {

import com.starfall.ane.UserMail;

import flash.display.Sprite;
import flash.events.MouseEvent;
import flash.system.Capabilities;
import flash.text.TextField;

public class Main extends Sprite {
    var textField:TextField = new TextField();

    public function Main() {
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

    private function clickHandler(event:MouseEvent):void {
        textField.scrollH = textField.maxScrollH;
        textField.appendText("\n" + check())
    }

    private function check():String {
        return "UserMail.isAvalable():  " + UserMail.isAvalable();
    }
}
}