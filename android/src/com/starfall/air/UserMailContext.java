package com.starfall.air;

import java.util.HashMap;
import java.util.Map;
import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

public class UserMailContext extends FREContext {

    @Override
    public void dispose() {
    }

    @Override
    public Map<String, FREFunction> getFunctions() {
        Map<String, FREFunction> functionMap = new HashMap<String, FREFunction>();
        functionMap.put("canSend", new UserMailAccountAvalable());
        return functionMap;
    }
}