#import "DeviceSettings.h"

@implementation DeviceSettings

- (BOOL)do_open:(NSString *)pref {
    if ([[UIApplication sharedApplication] openURL:[NSURL URLWithString:pref]]) {
        return YES;
    } else {
        return NO;
    }
}

- (void)open:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* key = [command.arguments objectAtIndex:0];
    NSString* prefix = @"App-Prefs:";
    BOOL result = NO;

    if(SYSTEM_VERSION_LESS_THAN(@"11.3")){
        prefix = @"app-settings:";
    }
    if ([key isEqualToString:@"settings"]) {
        result = [self do_open:prefix];
    } 
    else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Invalid Action"];
    }
        
    if (result) {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:@"Opened"];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR messageAsString:@"Cannot open"];
    }
    
    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
