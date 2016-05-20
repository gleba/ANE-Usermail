package com.starfall.air;


import com.adobe.fre.FREContext;
import com.adobe.fre.FREExtension;
import org.json.JSONException;
import org.json.JSONObject;

public class UserMailExtension implements FREExtension {

    public static FREContext context;

    @Override
    public FREContext createContext(String contextType) {
        return context = new UserMailContext();
    }

    @Override
    public void dispose() {
    }

    @Override
    public void initialize() {
        try {
            UserMailExtension.accoundIds.put("com.google", true);
            UserMailExtension.accoundIds.put("com.samsung.android.email", true);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static void log(String message) {
        if (message != null) {
            context.dispatchStatusEventAsync("LOGGING", message);
        }
    }

    public static JSONObject accoundIds = new JSONObject();
}
