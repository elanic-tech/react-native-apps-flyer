
package com.ppsreejith;

import android.app.Application;

import com.appsflyer.AppsFlyerLib;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReadableMap;

import java.util.Map;

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
    public void sendTrackingWithEvent(final String eventName, final ReadableMap events, final Callback callback) {
        AppsFlyerLib.getInstance().trackEvent(this.application, eventName, events.toHashMap());
        callback.invoke(null, events);
    }
}
