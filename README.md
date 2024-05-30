# cordova-plugin-device-settings - For Cordova

The plugin allows you to open OS settings on iOS and Android, via cordova-based app. For example, it will allow you to open the keyboard settings.

## Adding/Removing the Plugin 
It will be saved to the config.xml file

```bash
cordova plugin (add|rm) cordova-plugin-device-settings --save
```

### Example for iOS and Android - open  settings

```js
if (window.cordova && window.cordova.plugins.settings) {
    console.log('openDeviceSettingsTest is active');
    window.cordova.plugins.settings.open("settings", function() {
            console.log('opened settings');
        },
        function () {
            console.log('failed to open settings');
        }
    );
} else {
    console.log('openDeviceSettingsTest is not active!');
}
```
## Settings Options
You can use any constant from the following list:
* I tried to map Android and iOS together, however, they are not always the same.

```    
    "settings", // ios, android
    
```
## Contributing / Issues
* Open Settings page in iOS and Android mobile device."# cordova-plugin-device-settings" 
"# cordova-plugin-device-settings" 
