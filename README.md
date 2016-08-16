
# react-native-apps-flyer

## Installation

This only works for iOS at the moment.
`$ npm install react-native-apps-flyer --save`

### Manual installation

#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-apps-flyer` and add `RNAppsFlyer.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAppsFlyer.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Install the appsFlyerFramework pod file from their website. Uncomment `use_frameworks!` in the Podfile.
5. Run your project (`Cmd+R`)<

## Usage
```javascript
import af from 'react-native-apps-flyer';

//To Initialize sdk using appId and devKey
af.init(appId, devKey, function(err, events) {
    //events is [appId, devKey] for now

    //To trigger an event,
    af.sendTrackingWithEvent(eventName, {key1: value1, key2: value2}, function(err, events) {
        //events is {key1: value1, key2, value2}
    });

    //To get appsFlyerUID an event,
    af.getAppsFlyerUID(function(err, uid) {

    });
})
```
