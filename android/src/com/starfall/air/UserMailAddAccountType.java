package com.starfall.air;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import org.json.JSONObject;

public class UserMailAddAccountType implements FREFunction {

    @Override
    public FREObject call(FREContext freContext, FREObject[] passedArgs) {
        try {
            FREObject param = passedArgs[0];
            String type = param.getAsString();
            UserMailExtension.accoundIds.put(type, true);
        } catch (Exception exception) {
            UserMailExtension.log("UserMailCanSend exception " + exception.toString());
        }
        return null;
    }
}
