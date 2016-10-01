
# react-native-apps-flyer
This React Natie Library uses the AppsFlyer 4.6.0 library for both iOS and Android

## Installation

`$ npm install react-native-apps-flyer --save`

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-apps-flyer` and add `RNAppsFlyer.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAppsFlyer.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Install the appsFlyerFramework pod file from their website. Uncomment `use_frameworks!` in the Podfile.
5. Run your project (`Cmd+R`)<

#### Android

##### MainApplication.java
1. import `import com.ppsreejith.RNAppsFlyerPackage;`
2. In your overridden `onCreate()`, add `AppsFlyerLib.getInstance().startTracking(this, "YOUR_DEV_KEY");`
3. In the `getPackages()` method register the module `new RNAppsFlyerPackage(MainApplication.this)`

##### AndroidManifest
1. Add right inside the `<application>` tag
```
<meta-data android:name="com.google.android.gms.version"
                   android:value="@integer/google_play_services_version"/>
<receiver android:name="com.appsflyer.MultipleInstallBroadcastReceiver" android:exported="true">
    <intent-filter>
        <action android:name="com.android.vending.INSTALL_REFERRER"/>
    </intent-filter>
</receiver>
```



##### build.gradle
1. Add the project to your dependencies `compile project(':react-native-apps-flyer')`

##### settings.gradle
1. Add the project
`include ':react-native-apps-flyer`
`project(':react-native-apps-flyer').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-apps-flyer/android')`

## Usage

### ios
```javascript
import af from 'react-native-apps-flyer';

//To Initialize sdk using appId and devKey
af.init(appId, devKey, function(err, events) {
    //events is [appId, devKey] for now

    //To trigger an event,
    af.sendTrackingWithEvent(eventName, {key1: value1, key2: value2}, function(err, events) {
        //events is {key1: value1, key2, value2}
    });

    // To get appsFlyerUID an event,
    af.getAppsFlyerUID(function(err, uid) {

    });

    // To track location with lat and long * note lat and long should be floats only,
    af.trackLocation(last, long, function(err, data) {

    });
})
```

### android

The android module currently does not support callbacks and event values

```javascript
import af from 'react-native-apps-flyer';

//To Initialize sdk using appId and devKey
af.init(appId, devKey);
af.sendTrackingWithEvent(eventName);
```
