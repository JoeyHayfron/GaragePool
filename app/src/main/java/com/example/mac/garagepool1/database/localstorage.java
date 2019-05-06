package com.example.mac.garagepool1.database;

import android.provider.BaseColumns;

/**
 * Created by mac on 05/02/2018.
 */

public final class localstorage {
    /*public static final class Mechanics{
        public static final String NAME = "mechs";

        public static final class Cols{
            public static final String UUID = "uuid";
            public static final String FULL_NAME = "Full_Name";
            public static final String PHONE = "Phone";
            public static final String EMAIL = "Email";
            public static final String PASSWORD = "Password";
            public static final String LOCATION_LATITUDE = "Latitude";
            public static final String LOCATION_LONGITUDE = "Longitude";
        }
    }*/
    private localstorage(){}

    public static class Mechanics implements BaseColumns{
        //public static final String UUID = "uuid";
        public static final String FULL_NAME = "Full_Name";
        public static final String PHONE = "Phone";
        public static final String EMAIL = "Email";
        public static final String PASSWORD = "Password";
        //public static final String LOCATION_LATITUDE = "Latitude";
        //public static final String LOCATION_LONGITUDE = "Longitude";

    }

}
