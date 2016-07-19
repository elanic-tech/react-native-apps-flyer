
# react-native-apps-flyer

## Getting started

`$ npm install react-native-apps-flyer --save`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-apps-flyer` and add `RNAppsFlyer.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAppsFlyer.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Install the appsFlyerFramework pod file from their website. Uncomment `use_frameworks!` in the Podfile.
5. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNAppsFlyerPackage;` to the imports at the top of the file
  - Add `new RNAppsFlyerPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-apps-flyer'
  	project(':react-native-apps-flyer').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-apps-flyer/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-apps-flyer')
  	```
4. Add the appsflyer sdk from their website.

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNAppsFlyer.sln` in `node_modules/react-native-apps-flyer/windows/RNAppsFlyer.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Cl.Json.RNAppsFlyer;` to the usings at the top of the file
  - Add `new RNAppsFlyerPackage()` to the `List<IReactPackage>` returned by the `Packages` method
      

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
})
```