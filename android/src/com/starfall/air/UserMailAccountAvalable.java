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
            JSONObject ids = new JSONObject();
            ids.put("com.google", true);
            Account[] accounts = AccountManager.get(freContext.getActivity().getBaseContext()).getAccounts();
            for (Account account : accounts) {
                UserMailExtension.log(account.type);
                if (ids.has(account.type)) {
                    return FREObject.newObject(true);
                }
            }
            return FREObject.newObject(false);
        } catch (Exception exception) {
            UserMailExtension.log("UserMailCanSend exception " + exception.toString());
        }
        return null;
    }
}
