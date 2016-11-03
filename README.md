
# react-native-apps-flyer
This React Native Library uses the AppsFlyer 4.6.0 library for both iOS and Android

## Installation

`$ npm install react-native-apps-flyer --save`

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-apps-flyer` and add `RNAppsFlyer.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAppsFlyer.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Install the appsFlyerFramework pod file from their website. Uncomment `use_frameworks!` in the Podfile.
5. Run your project (`Cmd+R`)

#### Android

##### MainApplication.java
1. import `import com.ppsreejith.RNAppsFlyerPackage;`
2. In the `getPackages()` method register the module `new RNAppsFlyerPackage(MainApplication.this)`

##### android/app/build.gradle
1. Add the project to your dependencies
```gradle
dependencies {
    ...
    compile project(':react-native-apps-flyer')
}
```

##### android/settings.gradle
1. Add the project
```gradle
include ':react-native-apps-flyer'
project(':react-native-apps-flyer').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-apps-flyer/android')
```

## Usage

```javascript
import af from 'react-native-apps-flyer';

af.init(appId, devKey, function(err) {
    
});

// To get appsFlyerUID,
af.getAppsFlyerUID(function(err, uid) {

});

//To trigger an event
af.trackEvent(eventName, {key1: value1, key2: value2}, function(err, events) {
    // events is {key1: value1, key2, value2}
});
```

### iOS only
```javascript
import af from 'react-native-apps-flyer';


// To track location with lat and long * note lat and long should be floats only,
af.trackLocation(last, long, function(err, data) {

});
})
```

# DEPRECATED
```javascript

// iOS
af.sendTrackingWithEvent(eventName, {key1: value1, key2: value2}, function(err, events) {
    // events is {key1: value1, key2, value2}
});

// Android
af.sendTrackingWithEvent(eventName);
```
