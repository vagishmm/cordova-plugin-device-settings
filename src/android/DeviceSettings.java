/*
 * PhoneGap is available under *either* the terms of the modified BSD license *or* the
 * MIT License (2008). See http://opensource.org/licenses/alphabetical for full text.
 *
 * Copyright (c) 2005-2010, Nitobi Software Inc.
 * Copyright (c) 2011, IBM Corporation
 */

package com.phonegap.plugins.devicesettings;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.content.Context;
import android.net.Uri;

import android.provider.Settings;

import android.os.Build;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;

public class DeviceSettings extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		Context context=this.cordova.getActivity().getApplicationContext();
        PluginResult.Status status = PluginResult.Status.OK;
        Uri packageUri = Uri.parse("package:" + this.cordova.getActivity().getPackageName());
        String result = "";

        //Information on settings can be found here:
        //http://developer.android.com/reference/android/provider/Settings.html
		
		action = args.getString(0);
		Intent intent = null;

        if (action.equals("settings")) {

            intent = new Intent();
            // Uncomment the below code when Cordova supports Android 30 / R
			/*if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
                intent = new Intent(android.provider.Settings.ACTION_BIOMETRIC_ENROLL);
            } else */ if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                intent = new Intent(android.provider.Settings.ACTION_FINGERPRINT_ENROLL);
            } else {
                // Atleast open the settings landing page
                intent = new Intent(android.provider.Settings.ACTION_SETTINGS);
            }
        } else {
             status = PluginResult.Status.INVALID_ACTION;
             callbackContext.sendPluginResult(new PluginResult(status, result));
        	return false;
        }
        
        if(args.length() > 1 && args.getBoolean(1)) {
        	intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        this.cordova.getActivity().startActivity(intent);
        
        callbackContext.sendPluginResult(new PluginResult(status, result));
        return true;
    }
}

