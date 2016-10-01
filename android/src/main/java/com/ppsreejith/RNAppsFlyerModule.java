
package com.ppsreejith;

import android.app.Application;

import com.appsflyer.*;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;
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
    public void sendTrackingWithEvent(final String eventName, ReadableMap eventData, Callback callback) {
        AppsFlyerLib.getInstance().trackEvent(getReactApplicationContext(), eventName, null);
    }
}
