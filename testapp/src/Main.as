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

        textField.text = check();
        trace(check());
        addChild(textField);
        addEventListener(MouseEvent.CLICK, clickHandler);
    }

    private function clickHandler(event:MouseEvent):void {
        textField.appendText("\n"+check())
    }

    private function check():String{
        return "UserMail.isAvalable():  " + UserMail.isAvalable().toString();
    }
}
}