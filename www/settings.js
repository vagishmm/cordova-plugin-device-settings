var DeviceSettings = function() {
};

DeviceSettings.open = function(setting, onsucess, onfail) {
	var settings = (typeof setting === 'string' || setting instanceof String) ? [setting] : setting;
	cordova.exec(onsucess, onfail, "DeviceSettings", "open", settings);
};

module.exports = DeviceSettings;