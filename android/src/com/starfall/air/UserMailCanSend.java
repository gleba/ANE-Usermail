package com.starfall.air;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import android.util.Patterns;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserMailCanSend implements FREFunction {

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        try {

            final PackageManager packageManager = freContext.getActivity().getBaseContext().getPackageManager();
            final Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:to@gmail.com"));
            List<ResolveInfo> list =
                    packageManager.queryIntentActivities(intent,
                            PackageManager.MATCH_DEFAULT_ONLY);
            if (list.size() > 0) {
                return FREObject.newObject(true);
            } else {
                return FREObject.newObject(false);
            }
        } catch (Exception exception) {
            UserMailExtension.log("UserMailCanSend exception " + exception.toString());
        }
        return null;
    }
}
