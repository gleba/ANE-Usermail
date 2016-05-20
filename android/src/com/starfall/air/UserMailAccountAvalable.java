package com.starfall.air;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
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
            Activity a = freContext.getActivity();
            Account[] accounts = AccountManager.get(a.getBaseContext()).getAccounts();
            final PackageManager packageManager = a.getBaseContext().getPackageManager();
            final Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:to@gmail.com"));
            List<ResolveInfo> list = packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
            for (Account account : accounts) {
                for (ResolveInfo r : list) {

                    UserMailExtension.log("packageName: " + r.activityInfo.applicationInfo.packageName+ "?contains? "+"account.type: " + account.type+" :::: " + r.activityInfo.applicationInfo.packageName.contains(account.type));

                    if (r.activityInfo.applicationInfo.packageName.contains(account.type)) {
                        return FREObject.newObject(true);
                    }
                }
            }
            return FREObject.newObject(true);
        } catch (Exception exception) {
            UserMailExtension.log("UserMailCanSend exception " + exception.toString());
        }
        return null;
    }
}
