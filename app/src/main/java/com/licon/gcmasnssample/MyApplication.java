//
// Copyright 2016 Amazon.com, Inc. or its affiliates (Amazon). All Rights Reserved.
//
// Code generated by AWS Mobile Hub. Amazon gives unlimited permission to 
// copy, distribute and modify it.
//
// Source code generated from template: aws-my-sample-app-android v0.7
//
package com.licon.gcmasnssample;

import android.support.multidex.MultiDexApplication;
import android.util.Log;

import com.licon.gcmasnssample.amazon.AWSMobileClient;
import com.licon.gcmasnssample.amazon.PushManager;

/**
 * MyApplication class responsible for initializing singletons and other common components.
 */
public class MyApplication extends MultiDexApplication {
    private final static String TAG = MyApplication.class.getSimpleName();

    @Override
    public void onCreate() {
        Log.d(TAG, "MyApplication.onCreate - Initializing application...");
        super.onCreate();
        initializeApplication();
        Log.d(TAG, "MyApplication.onCreate - MyApplication initialized OK");
    }

    private void initializeApplication() {
        AWSMobileClient.initializeMobileClientIfNecessary(getApplicationContext());

        // Set a listener for changes in push notification state
        PushManager.setPushStateListener(new PushManager.PushStateListener() {
            @Override
            public void onPushStateChange(final PushManager pushManager, boolean isEnabled) {
                Log.d(TAG, "Push Notifications Enabled = " + isEnabled);
                // ...Put any application-specific push state change logic here...
            }
        });
    }
}