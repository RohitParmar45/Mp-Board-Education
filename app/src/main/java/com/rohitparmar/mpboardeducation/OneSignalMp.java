package com.rohitparmar.mpboardeducation;

import android.app.Application;

import com.onesignal.OneSignal;

public class OneSignalMp extends Application {

    //private static final String ONESIGNAL_APP_ID = "55658c72-f270-454b-984a-3b67358272d3";

    @Override
    public void onCreate() {
        super.onCreate();

        // OneSignal Initialization
//        OneSignal.initWithContext(this);
//        OneSignal.setAppId(ONESIGNAL_APP_ID);
    }
}
