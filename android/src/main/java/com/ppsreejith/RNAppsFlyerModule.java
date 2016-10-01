
package com.ppsreejith;

import android.app.Application;

import com.appsflyer.*;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import java.util.HashMap;

import java.util.Map;
import android.util.Log;

public class RNAppsFlyerModule extends ReactContextBaseJavaModule {

    private ReactApplicationContext reactContext;
    private Application application;

    public RNAppsFlyerModule(ReactApplicationContext reactContext, Application application) {
        super(reactContext);
        this.reactContext = reactContext;
        this.application = application;
    }

    @Override
    public String getName() {
        return "RNAppsFlyer";
    }

    @ReactMethod
    public void init(final String appId, final String key) {
        AppsFlyerLib.getInstance().startTracking(application, key);
    }

    @ReactMethod
    public void sendTrackingWithEvent(final String eventName) {
        AppsFlyerLib.getInstance().trackEvent(getReactApplicationContext(), eventName, new HashMap<String, Object>());
        // Map<String, Object> eventValue = new HashMap<String, Object>();
        // eventValue.put(AFInAppEventParameterName.LEVEL,9);
        // eventValue.put(AFInAppEventParameterName.SCORE,100);
        // AppsFlyerLib.getInstance().trackEvent(getReactApplicationContext(), AFInAppEventType.LEVEL_ACHIEVED, eventValue);
    }
}
