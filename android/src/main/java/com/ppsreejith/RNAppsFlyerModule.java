
package com.ppsreejith;

import android.app.Application;

import com.appsflyer.AppsFlyerLib;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.bridge.Callback;
import com.hs2.RNUtil;

public class RNAppsFlyerModule extends ReactContextBaseJavaModule {

    private final ReactApplicationContext reactContext;
    private final Application application;

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
        AppsFlyerLib.getInstance().startTracking(this.application, key);
    }

    @ReactMethod
    public void sendTrackingWithEvent(final String eventName, final ReadableMap eventData, final Callback callback) {
        Map<String, Object> data = RNUtil.toMap(eventData);
        AppsFlyerLib.getInstance().trackEvent(this.application, eventName, data);
        callback.invoke(null, data);
    }
}
