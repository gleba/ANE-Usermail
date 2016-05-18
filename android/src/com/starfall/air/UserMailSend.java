package com.starfall.air;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

public class UserMailSend implements FREFunction {

    @Override
    public FREObject call(FREContext freContext, FREObject[] freObjects) {
        try
        {
            try {
                freContext.getActivity().startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:to@gmail.com")));
                return FREObject.newObject( true );
            } catch (android.content.ActivityNotFoundException ex) {
                return FREObject.newObject( false);
            }
        }
        catch ( Exception exception )
        {
            Log.w( "CanOpenUrlExtension", exception );
        }
        return null;
    }
}
