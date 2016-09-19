package com.mantra.checkin.Session;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;

import com.mantra.checkin.LocationHelpers.LocationUtility;


/**
 * Created by nravishankar on 9/19/2016.
 */
public class SessionHelper {

    public static String BaseUrl = "http://10.85.194.227:2323";
    public static Resources mR;
    public static LocationUtility mLocationUtility;
    public static Location mLocation;

    public SessionHelper(Context context){
        mR = context.getResources();
        mLocationUtility = new LocationUtility(context);
    }
}
