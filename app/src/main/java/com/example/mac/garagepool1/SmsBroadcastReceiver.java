package com.example.mac.garagepool1;


import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.telephony.SmsMessage;
import android.widget.Toast;

import static com.example.mac.garagepool1.offlinemanager.dialog1;


public class SmsBroadcastReceiver extends BroadcastReceiver implements LocationListener {

    public static final String SMS_BUNDLE = "pdus";
    Welcome wlkm;
    public static boolean showView = false;
    public static boolean showView1 = false;
    public static boolean showView2 = false;
    public static String replyPhone;
    public static Location dest = new Location("NETWORK_PROVIDER");
    public static double  Lat;
    public static double Long;
    String request;
    String request1;






    //public CardView accept_or_reject;



    @RequiresApi(api = Build.VERSION_CODES.M)
    public void onReceive(Context context, Intent intent) {


        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
            // Retrieves a map of extended data from the intent.
            final Bundle bundle = intent.getExtras();
            SmsMessage[] msgs = null;
            String str = "";

            if (bundle != null) {
                //---retrieve the SMS message received---
                Object[] pdus = (Object[]) bundle.get("pdus");
                StringBuilder sb = new StringBuilder();
                msgs = new SmsMessage[pdus.length];
                for (int i = 0; i < pdus.length; i++) {
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                replyPhone = msgs[0].getOriginatingAddress();
                request = msgs[0].getMessageBody().toString();

                String[] msg = request.split(":");

                if (msg[0].equals("My Car Broke down and I need help.I'm at"))
                {
                    msg[1].trim();
                    String[] hmm = msg[1].split(",");
                    if (hmm != null) {
                        Toast.makeText(context, "A help request has been sent to you"
                                , Toast.LENGTH_SHORT).show();
                        try {
                            Lat = Double.parseDouble(hmm[0]);
                            Long = Double.parseDouble(hmm[1]);
                            showView = true;
                            showView1 = true;
                            if ((Lat != 0) && (Long != 0)) {
                                dest.setLatitude(Lat);
                                dest.setLongitude(Long);
                            }
                            offlinemanager inst = offlinemanager.instance();

                            if (offlinemanager.active) {
                              dialog1.show();

                            } else {
                                Intent i = new Intent(context, offlinemanager.class);
                                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                context.startActivity(i);
                            }

                        } catch (NumberFormatException e) {
                            // Executed iff the string couldn't be parsed.
                        }

                    } else {

                    }
                }
            }
        }
    }
    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}