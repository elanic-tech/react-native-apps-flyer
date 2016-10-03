
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

    @Override
    public Map<String, Object> getConstants() {
        HashMap<String, Object> constants = new HashMap<String, Object>();
        contants.put("ACHIEVEMENT_UNLOCKED", AFInAppEventType.ACHIEVEMENT_UNLOCKED);
        contants.put("ADD_PAYMENT_INFO", AFInAppEventType.ADD_PAYMENT_INFO);
        contants.put("ADD_TO_CART", AFInAppEventType.ADD_TO_CART);
        contants.put("ADD_TO_WISH_LIST", AFInAppEventType.ADD_TO_WISH_LIST);
        contants.put("COMPLETE_REGISTRATION", AFInAppEventType.COMPLETE_REGISTRATION);
        contants.put("CONTENT_VIEW", AFInAppEventType.CONTENT_VIEW);
        contants.put("INITIATED_CHECKOUT", AFInAppEventType.INITIATED_CHECKOUT);
        contants.put("INVITE", AFInAppEventType.INVITE);
        contants.put("LEVEL_ACHIEVED", AFInAppEventType.LEVEL_ACHIEVED);
        contants.put("LOCATION_CHANGED", AFInAppEventType.LOCATION_CHANGED);
        contants.put("LOCATION_COORDINATES", AFInAppEventType.LOCATION_COORDINATES);
        contants.put("LOGIN", AFInAppEventType.LOGIN);
        contants.put("OPENED_FROM_PUSH_NOTIFICATION", AFInAppEventType.OPENED_FROM_PUSH_NOTIFICATION);
        contants.put("ORDER_ID", AFInAppEventType.ORDER_ID);
        contants.put("PURCHASE", AFInAppEventType.PURCHASE);
        contants.put("RATE", AFInAppEventType.RATE);
        contants.put("RE_ENGAGE", AFInAppEventType.RE_ENGAGE);
        contants.put("SEARCH", AFInAppEventType.SEARCH);
        contants.put("SHARE", AFInAppEventType.SHARE);
        contants.put("SPENT_CREDIT", AFInAppEventType.SPENT_CREDIT);
        contants.put("TRAVEL_BOOKING", AFInAppEventType.TRAVEL_BOOKING);
        contants.put("TUTORIAL_COMPLETION", AFInAppEventType.TUTORIAL_COMPLETION);
        contants.put("UPDATE", AFInAppEventType.UPDATE);
        return constants;
    }

    @ReactMethod
    public void init(final String appId, final String key, Callback callback) {
        AppsFlyerLib.getInstance().startTracking(application, key);
        callback.invoke(null);
    }

    @ReactMethod
    public void trackEvent(final String eventName, ReadableMap eventData, Callback callback) {
        Map<String, Object> data = RNUtil.toMap(eventData);
        AppsFlyerLib.getInstance().trackEvent(getReactApplicationContext(), eventName, data);
        callback.invoke(null, null);
    }

    public void getAppsFlyerUID(Callback callback) {
        String appId = AppsFlyerLib.getInstance().getAppsFlyerUID(getReactApplicationContext());
        callback.invoke(null, appId);
    }
}
