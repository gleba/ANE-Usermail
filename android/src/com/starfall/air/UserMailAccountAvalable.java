    package com.starfall.air;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Patterns;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import org.json.JSONObject;

import java.util.List;
import java.util.regex.Pattern;

    public class UserMailAccountAvalable implements FREFunction {

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        try {
            Account[] accounts = AccountManager.get(freContext.getActivity().getBaseContext()).getAccounts();
            Boolean hasAccount = false;
            for (Account account : accounts) {
                UserMailExtension.log("name:"+account.name+" id:"+account.type);
                if (UserMailExtension.accoundIds.has(account.type)) {
                    hasAccount = true;
                }
            }
            return FREObject.newObject(hasAccount);
        } catch (Exception exception) {
            UserMailExtension.log("UserMailCanSend exception " + exception.toString());
        }
        return null;
    }
}
