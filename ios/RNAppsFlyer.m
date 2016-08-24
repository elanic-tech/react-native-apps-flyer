#import "AppsFlyerTracker.h"
#import "RNAppsFlyer.h"

@implementation RNAppsFlyer
/*
- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
*/
RCT_EXPORT_MODULE()

RCT_EXPORT_METHOD(init: (NSString *)appId devKey:(NSString *)devKey callback:(RCTResponseSenderBlock)callback)
{
  // Your implementation here
  [AppsFlyerTracker sharedTracker].appleAppID = appId;
  [AppsFlyerTracker sharedTracker].appsFlyerDevKey = devKey;
  [AppsFlyerTracker sharedTracker].isDebug = YES;
  [[AppsFlyerTracker sharedTracker] trackAppLaunch];
  NSArray *events = @[appId, devKey];
  callback(@[[NSNull null], events]);
}

RCT_EXPORT_METHOD(sendTrackingWithEvent: (NSString *)eventName eventValues:(NSDictionary *)eventValues callback:(RCTResponseSenderBlock)callback)
{
  [[AppsFlyerTracker sharedTracker] trackEvent:eventName withValues:eventValues];
  callback(@[[NSNull null], eventValues]);
}

RCT_EXPORT_METHOD(getAppsFlyerUID: (RCTResponseSenderBlock)callback)
{
    NSString *uid = [[AppsFlyerTracker sharedTracker] getAppsFlyerUID];
    callback(@[[NSNull null], uid]);
}

RCT_EXPORT_METHOD(trackLocation: (double)longitude latitude:(double)latitude callback:(RCTResponseSenderBlock)callback)
{
    [[AppsFlyerTracker sharedTracker] trackLocation:longitude latitude:latitude];

    NSArray *events = @[[NSNumber numberWithDouble:longitude], [NSNumber numberWithDouble:latitude]];
    callback(@[[NSNull null], events]);
}

@end
