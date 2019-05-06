package com.example.mac.garagepool1;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.offline.OfflineManager;
import com.mapbox.mapboxsdk.offline.OfflineRegion;
import com.mapbox.mapboxsdk.offline.OfflineRegionError;
import com.mapbox.mapboxsdk.offline.OfflineRegionStatus;
import com.mapbox.mapboxsdk.offline.OfflineTilePyramidRegionDefinition;

import org.json.JSONObject;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.util.SortedList;

import com.example.mac.garagepool1.Model.User;
import com.google.android.gms.vision.text.Line;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.IconFactory;
import com.mapbox.mapboxsdk.annotations.InfoWindow;
import com.mapbox.mapboxsdk.annotations.MarkerViewOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigation;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;
import com.mapbox.services.commons.models.Position;

import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import android.location.Location;
import com.mapbox.mapboxsdk.geometry.LatLng;
import android.support.annotation.NonNull;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.plugins.locationlayer.LocationLayerMode;
import com.mapbox.mapboxsdk.plugins.locationlayer.LocationLayerPlugin;
import com.mapbox.services.android.location.LostLocationEngine;
import com.mapbox.services.android.navigation.ui.v5.NavigationViewOptions;
import com.mapbox.services.android.telemetry.location.LocationEngine;
import com.mapbox.services.android.telemetry.location.LocationEngineListener;
import com.mapbox.services.android.telemetry.location.LocationEnginePriority;
import com.mapbox.services.android.telemetry.permissions.PermissionsListener;
import com.mapbox.services.android.telemetry.permissions.PermissionsManager;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.services.android.navigation.ui.v5.route.NavigationMapRoute;
import com.mapbox.services.android.navigation.v5.navigation.NavigationRoute;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.geojson.Point;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.rengwuxian.materialedittext.MaterialEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.support.v7.widget.CardView;
import android.telephony.SmsManager;
import android.text.Html;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import android.graphics.drawable.Drawable;

import static com.example.mac.garagepool1.MainActivity.df;
import static com.example.mac.garagepool1.SmsBroadcastReceiver.Lat;
import static com.example.mac.garagepool1.SmsBroadcastReceiver.dest;
import static com.example.mac.garagepool1.SmsBroadcastReceiver.replyPhone;
import static com.example.mac.garagepool1.SmsBroadcastReceiver.showView;
import static com.example.mac.garagepool1.SmsBroadcastReceiver.showView1;

/**
 * Download, view, navigate to, and delete an offline region.
 */
public class offlinemanager extends AppCompatActivity implements LocationEngineListener,PermissionsListener,MapboxMap.OnMarkerClickListener{


    //private MapView mapView;
    //public static MapboxMap map;
    private PermissionsManager permissionsManager;
    private LocationLayerPlugin locationPlugin;
    private LocationEngine locationEngine;
    private Location originLocation;
    private Marker destinationMarker;
    private LatLng originCoord;
    private LatLng destinationCoord;
    public com.mapbox.geojson.Point originPosition;
    public com.mapbox.geojson.Point destinationPosition;
    private DirectionsRoute currentRoute;
   // private static final String TAG = "DirectionsActivity";
    private NavigationMapRoute navigationMapRoute;
    public boolean shown = false;

    FirebaseDatabase db;
    DatabaseReference users;
    final List<User> usa = new ArrayList<User>();
    CardView cv;
    public CardView accept_or_reject;
    SelectUser su = new SelectUser();
    public String phone;
    public String email;
    public String name;
    public float latitude;
    public float longitude;
    public Marker selectedmarker;
    public TextView moreinfo;
    public User userss;
    static boolean active = false;
    private static offlinemanager inst;
    public  Location desstination;
    public static Marker destination;

    SmsManager smsManager = SmsManager.getDefault();
    Button accept;
    Button reject;
    Button viewLocation;
    public static double destinationLat;
    public static double destinationLong;
    public static Location loc;
    Float cc;
    String dd;
    String ee;
    String ff;
    public Boolean ratedalready = false;
    public MapboxMap mapboxMap;


    public LocationManager lmf;
    boolean isFABOpen = false;



    private static final int READ_SMS_PERMISSIONS_REQUEST = 1;


    FloatingActionButton fab;
    FloatingActionButton signout;
    FloatingActionButton fab1;
    public com.mapbox.geojson.Point destinations;

    FirebaseAuth auth;
    static boolean calledAlready = false;
    public com.mapbox.geojson.Point origin;
    public static AlertDialog.Builder dialog1;

    public FloatingActionButton callback;
    public FloatingActionButton getroute;
    String fault;
    public Context sContext = offlinemanager.this;


    public static offlinemanager instance() {
        return inst;
    }


    private static final String TAG = "OffManActivity";

    // JSON encoding/decoding
    public static final String JSON_CHARSET = "UTF-8";
    public static final String JSON_FIELD_REGION_NAME = "FIELD_REGION_NAME";

    // UI elements
    private MapView mapView;
    private MapboxMap map;
    private ProgressBar progressBar;
    private Button downloadButton;
    private Button listButton;

    private boolean isEndNotified;
    private int regionSelected;

    // Offline objects
    private OfflineManager offlineManager;
    private OfflineRegion offlineRegion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        lmf = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        db = FirebaseDatabase.getInstance();
        users = db.getReference("Users");



        accept_or_reject = findViewById(R.id.accept_or_reject);
        dialog1 = new AlertDialog.Builder(offlinemanager.this);
        dialog1.setTitle("Request for Help!!");
        LayoutInflater inflater = LayoutInflater.from(offlinemanager.this);
        View sign_out = inflater.inflate(R.layout.request_dialog,null);
        dialog1.setView(sign_out);
        dialog1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                showView = false;
                accept_or_reject.setVisibility(View.VISIBLE);
                callback.setVisibility(View.VISIBLE);
                callback.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+replyPhone));
                        startActivity(callIntent);
                    }
                });
            }
        });

        // Mapbox access token is configured here. This needs to be called either in your application
        // object or in the same activity which contains the mapview.
        MapboxNavigation navigation = new MapboxNavigation(this, "pk.eyJ1IjoiamF5aCIsImEiOiJjamM0d2p0YTExMXQ1MzNwaWRncWRrcjJ5In0.0Iio5txPuaVR4dlgC3eDLw");
        Mapbox.getInstance(this, "pk.eyJ1IjoiamF5aCIsImEiOiJjamM0d2p0YTExMXQ1MzNwaWRncWRrcjJ5In0.0Iio5txPuaVR4dlgC3eDLw");

        // This contains the MapView in XML and needs to be called after the access token is configured.
        setContentView(R.layout.activity_offlinemanager);



        accept =  findViewById(R.id.accept);
        reject =  findViewById(R.id.reject);
        viewLocation = findViewById(R.id.viewlocation);


        fab = findViewById(R.id.editAccount);
        fab1 = findViewById(R.id.fab1);
        signout = (FloatingActionButton) findViewById(R.id.signoutButton);


        userLocationFAB();
        showFABMenu();
        final LocationManager lmm = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (!lmm.isProviderEnabled(LocationManager.GPS_PROVIDER) ||
                !lmm.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            // Build the alert dialog
            android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(this);
            builder.setTitle("Location Services Not Active");
            builder.setMessage("Please enable Location Services and GPS");
            builder.setPositiveButton("Location Settings", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    // Show location settings when the user acknowledges the alert dialog
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    startActivity(intent);
                }
            });
            Dialog alertDialog = builder.create();
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.show();
        }
        final Toast ht = Toast.makeText(this, "Request sent!", Toast.LENGTH_SHORT);
        final Toast th = Toast.makeText(this, "Request Accepted", Toast.LENGTH_SHORT);
        final Toast htt = Toast.makeText(this, "Request Rejected", Toast.LENGTH_SHORT);



        // Set up the MapView
        mapView = (MapView) findViewById(R.id.mapView);


        IconFactory mIconFactory = IconFactory.getInstance(this);
        final com.mapbox.mapboxsdk.annotations.Icon icon = mIconFactory.fromResource(R.drawable.mech);

        final LocationManager lm;
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);


        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap mapboxMap) {
                map = mapboxMap;
            }
        });




        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(final MapboxMap mapboxMap) {
                enableLocationPlugin();
                // One way to add a marker view

                map = mapboxMap;



                users.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Iterable<DataSnapshot> children = dataSnapshot.getChildren();

                        for (DataSnapshot child : children) {
                            userss = child.getValue(User.class);


                            mapboxMap.addMarker(new MarkerOptions()
                                    .position(new LatLng(userss.latitude, userss.longitude))
                                    .title("Master " + userss.name)
                                    //+"\n"+"Expertise: "+userss.expertise
                                    .snippet(userss.phone)
                                    .icon(icon)


                            );
                            final Button rate = (Button) findViewById(R.id.submit);
                            final RatingBar ratings = (RatingBar)findViewById(R.id.ratingbar);
                            final String ratingdec;
                            final TextView ratingno = (TextView)findViewById(R.id.rating);




                            mapboxMap.setOnMarkerClickListener(new MapboxMap.OnMarkerClickListener() {
                                @Override
                                public boolean onMarkerClick(@NonNull final Marker marker) {
                                    //...marker click handling code...
                                    phone = marker.getSnippet();
                                    mapboxMap.selectMarker(marker);

                                    cv.setVisibility(View.VISIBLE);
                                    getroute.setVisibility(View.VISIBLE);

                                    getroute.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            originCoord = new LatLng(originLocation.getLatitude(),originLocation.getLongitude());
                                            origin = Point.fromLngLat(originCoord.getLongitude(),originCoord.getLatitude());
                                            destinationCoord = new LatLng(marker.getPosition().getLatitude(),marker.getPosition().getLongitude());
                                            destinations = Point.fromLngLat(destinationCoord.getLongitude(),destinationCoord.getLatitude());
                                            getRoute(origin,destinations);
                                        }
                                    });

                                      if (loadnumber()==marker.getSnippet())
                                      {
                                          ratingno.setText(String.valueOf(loadrating()));
                                          ratings.setRating(loadrating());
                                      }
                                      else
                                      {
                                          ratingno.setText("");
                                          ratings.setRating(0F);
                                      }




                                    ratings.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                                        @Override
                                        public void onRatingChanged(RatingBar ratingBar, float rating,
                                                                    boolean fromTouch) {
                                            ratings.setRating(rating);
                                            cc = rating;
                                        }
                                    });


                                    rate.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            saverating(cc,marker.getSnippet());
                                            ratingno.setText(String.valueOf(cc));
                                            ratings.setRating(0F);
                                        }
                                    });
                                    //selectedmarker = marker;
                                    // origin = Point.fromLngLat(marker.getPosition().getLatitude(), marker.getPosition().getLongitude());
                                    return true;
                                }
                            });



                            mapboxMap.setOnInfoWindowClickListener(new MapboxMap.OnInfoWindowClickListener() {
                                @Override
                                public boolean onInfoWindowClick(@NonNull Marker marker) {
                                    Intent intent = new Intent(offlinemanager.this, MechInfoPage.class);
                                    intent.putExtra("phone", marker.getSnippet().toString());
                                    intent.putExtra("name", marker.getTitle().toString());
                                    startActivity(intent);
                                    return false;
                                }
                            });


                            Button help = (Button) findViewById(R.id.help);
                            Button call = (Button) findViewById(R.id.call);



                            //final String smsNumber = users.phone;



                            help.setOnClickListener(new View.OnClickListener() {
                                @SuppressLint("MissingPermission")
                                @Override
                                public void onClick(View v) {

                                    AlertDialog.Builder dialog2 = new AlertDialog.Builder(offlinemanager.this);
                                    dialog2.setTitle("Specify Vehicle Fault");
                                    LayoutInflater inflater = LayoutInflater.from(offlinemanager.this);
                                    View request = inflater.inflate(R.layout.help_request,null);
                                    final MaterialEditText specifyFault = request.findViewById(R.id.specifyFault);
                                    dialog2.setView(request);
                                    dialog2.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                                        @SuppressLint("MissingPermission")
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                                            dialogInterface.dismiss();
                                            fault = specifyFault.getText().toString();
                                            smsManager.sendTextMessage(phone, null, "My Car Broke down and I need help.I'm at: "+String.valueOf(location.getLatitude()) +","+String.valueOf(location.getLongitude()), null, null);
                                            smsManager.sendTextMessage(phone, null, fault, null, null);
                                            ht.show();
                                        }
                                    });
                                    dialog2.show();


                                }
                            });
                            call.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phone));
                                    startActivity(callIntent);
                                }
                            });




                            mapView.setOnTouchListener(new View.OnTouchListener() {
                                @Override
                                public boolean onTouch(View v, MotionEvent event) {
                                    cv.setVisibility(View.GONE);
                                    getroute.setVisibility(View.GONE);
                                    return false;
                                }
                            });



                        }


                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

                viewLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mapboxMap.addMarker(new MarkerOptions().position(new LatLng(Lat,SmsBroadcastReceiver.Long)));
                        setCameraPosition(dest);
                    }
                });
                accept.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onClick(View v) {
                        smsManager.sendTextMessage(replyPhone, null, "I'm on my way.", null, null);
                        // Location location = lmf.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                        originCoord = new LatLng(originLocation.getLatitude(),originLocation.getLongitude());
                        origin = Point.fromLngLat(originCoord.getLongitude(),originCoord.getLatitude());
                        destinationCoord = new LatLng(Lat,SmsBroadcastReceiver.Long);
                        destinations = Point.fromLngLat(destinationCoord.getLongitude(),destinationCoord.getLatitude());
                        getRoute(origin,destinations);
                        accept_or_reject.setVisibility(View.GONE);
                        showView1 = false;
                        th.show();
                    }
                });
                reject.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        smsManager.sendTextMessage(replyPhone, null, "Sorry I'm unavailable at the moment.", null, null);
                        accept_or_reject.setVisibility(View.GONE);
                        htt.show();
                    }
                });
            }
        });




        // Assign progressBar for later use
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);

        // Set up the offlineManager
        offlineManager = OfflineManager.getInstance(this);

        // Bottom navigation bar button clicks are handled here.
        // Download offline button
        downloadButton = (Button) findViewById(R.id.download_button);
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadRegionDialog();
            }
        });

        // List offline regions
        listButton = (Button) findViewById(R.id.list_button);
        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                downloadedRegionList();
            }
        });
    }

    public void saverating(float f,String s){
        SharedPreferences sharedPreferences = getSharedPreferences("folder",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("rating",f);
        editor.putString("snippet",s);
        editor.commit();
    }

    public float loadrating() {


        SharedPreferences sharedPreferences = getSharedPreferences("folder", MODE_PRIVATE);
        float f = sharedPreferences.getFloat("rating", 0F);
        return f;
    }
    public String loadnumber() {


        SharedPreferences sharedPreferences = getSharedPreferences("folder", MODE_PRIVATE);
        String s = sharedPreferences.getString("snippet", "0");
        return s;
    }


    private void userLocationFAB() {
        FloatingActionButton FAB = (FloatingActionButton) findViewById(R.id.myLocationButton);
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enableLocationPlugin();
                //initializeLocationEngine();

            }
        });
    }

    private void signout() {

        signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final android.support.v7.app.AlertDialog.Builder dialog = new android.support.v7.app.AlertDialog.Builder(offlinemanager.this);
                dialog.setTitle("Sign Out");
                LayoutInflater inflater = LayoutInflater.from(offlinemanager.this);
                View sign_out = inflater.inflate(R.layout.signout,null);
                dialog.setView(sign_out);
                dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        FirebaseAuth.getInstance().signOut();
                        Intent ii = new Intent(offlinemanager.this,MainActivity.class);
                        startActivity(ii);
                        finish();
                    }
                });
                dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();

            }
        });
    }


    private void editAccount() {
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(offlinemanager.this,edit_account.class));
            }
        });
    }


    public boolean checkLocationPermission() {
        String permission = "android.permission.ACCESS_FINE_LOCATION";
        int res = this.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }

    @SuppressWarnings({"MissingPermission"})
    private void enableLocationPlugin() {
        // Check if permissions are enabled and if not request
        if (PermissionsManager.areLocationPermissionsGranted(this)) {
            // Create an instance of LOST location engine
            initializeLocationEngine();

            locationPlugin = new LocationLayerPlugin(mapView, map, locationEngine);
            locationPlugin.setLocationLayerEnabled(LocationLayerMode.TRACKING);
        } else {
            permissionsManager = new PermissionsManager(this);
            permissionsManager.requestLocationPermissions(this);
        }
    }

    @SuppressWarnings({"MissingPermission"})
    private void initializeLocationEngine() {
        locationEngine = new LostLocationEngine(offlinemanager.this);
        locationEngine.setPriority(LocationEnginePriority.HIGH_ACCURACY);
        locationEngine.activate();

        Location lastLocation = locationEngine.getLastLocation();
        if (lastLocation != null) {
            originLocation = lastLocation;
            setCameraPosition(lastLocation);
        } else {
            locationEngine.addLocationEngineListener(this);
        }
    }

    public void setCameraPosition(Location location) {
        if(location!= null)
        {
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(
                    new LatLng(location.getLatitude(), location.getLongitude()), 16));
        }

    }


    //public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    //   permissionsManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    //}
    @Override
    public void onExplanationNeeded(List<String> permissionsToExplain) {

    }

    @Override
    public void onPermissionResult(boolean granted) {
        if (granted) {
            enableLocationPlugin();
        } else {
            finish();
        }
    }

    @Override
    @SuppressWarnings({"MissingPermission"})
    public void onConnected() {
        locationEngine.requestLocationUpdates();
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            originLocation = location;
            setCameraPosition(location);
            locationEngine.removeLocationEngineListener(this);
        }
    }

    private void showFABMenu(){
        if(df == true){
            fab.setVisibility(View.VISIBLE);
            fab1.setVisibility(View.VISIBLE);
            signout.setVisibility(View.VISIBLE);

        }
        else{
            fab.setVisibility(View.GONE);
            fab1.setVisibility(View.GONE);
            signout.setVisibility(View.GONE);
        }
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABOpen){
                    isFABOpen=true;
                    fab.animate().translationY(getResources().getDimension(R.dimen.standard_55));
                    signout.animate().translationY(getResources().getDimension(R.dimen.standard_105));
                    signout();
                    editAccount();
                }else{
                    closeFABMenu();
                }
            }
        });


    }
    private void closeFABMenu(){
        isFABOpen=false;
        fab.animate().translationY(0);
        signout.animate().translationY(0);

    }


    // Override Activity lifecycle methods
    @SuppressLint("MissingPermission")
    @Override
    public void onResume() {
        if (showView1)
        {
            accept_or_reject.setVisibility(View.VISIBLE);
            callback.setVisibility(View.VISIBLE);
            callback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+replyPhone));
                    startActivity(callIntent);
                }
            });
        }

        if (locationEngine != null) {
            locationEngine.requestLocationUpdates();
        }
        super.onResume();

        mapView.onResume();
    }
    @Override
    @SuppressWarnings({"MissingPermission"})
    public void onStart() {
        super.onStart();
        cv = findViewById(R.id.request_and_ratings);

        accept_or_reject = findViewById(R.id.accept_or_reject);
        callback = (FloatingActionButton)findViewById(R.id.call_back);
        getroute = (FloatingActionButton)findViewById(R.id.directions);



        cv.setVisibility(View.GONE);
        accept_or_reject.setVisibility(View.GONE);
        callback.setVisibility(View.GONE);
        getroute.setVisibility(View.GONE);

        if(showView)
        {
            dialog1.show();
        }

        if (locationEngine != null) {
            locationEngine.requestLocationUpdates();
        }
        if (locationPlugin != null) {
            locationPlugin.onStart();
        }
        active = true;
        inst = this;

        mapView.onStart();
    }
    @SuppressLint("MissingPermission")
    @Override
    public void onPause() {
        super.onPause();
        if (locationEngine != null) {
            locationEngine.requestLocationUpdates();
        }
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        if (locationEngine != null) {
            locationEngine.removeLocationUpdates();
        }
        if (locationPlugin != null) {
            locationPlugin.onStop();
        }
        active = false;
        mapView.onStop();
    }

    public void getRoute(Point origin, Point destination) {
        NavigationRoute.builder()
                .accessToken(Mapbox.getAccessToken())
                .origin(origin)
                .destination(destination)
                .build()
                .getRoute(new Callback<DirectionsResponse>() {
                    @Override
                    public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                        // You can get the generic HTTP info about the response
                        Log.d(TAG, "Response code: " + response.code());
                        if (response.body() == null) {
                            Log.e(TAG, "No routes found, make sure you set the right user and access token.");
                            return;
                        } else if (response.body().routes().size() < 1) {
                            Log.e(TAG, "No routes found");
                            return;
                        }

                        currentRoute = response.body().routes().get(0);

                        // Draw the route on the map
                        if (navigationMapRoute != null) {
                            navigationMapRoute.removeRoute();
                        } else {
                            navigationMapRoute = new NavigationMapRoute(null, mapView, map, R.style.NavigationMapRoute);
                        }
                        navigationMapRoute.addRoute(currentRoute);
                    }

                    @Override
                    public void onFailure(Call<DirectionsResponse> call, Throwable throwable) {
                        Log.e(TAG, "Error: " + throwable.getMessage());
                    }
                });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    private void downloadRegionDialog() {
        // Set up download interaction. Display a dialog
        // when the user clicks download button and require
        // a user-provided region name
        AlertDialog.Builder builder = new AlertDialog.Builder(offlinemanager.this);

        final EditText regionNameEdit = new EditText(offlinemanager.this);
        regionNameEdit.setHint(getString(R.string.set_region_name_hint));

        // Build the dialog box
        builder.setTitle(getString(R.string.dialog_title))
                .setView(regionNameEdit)
                .setMessage(getString(R.string.dialog_message))
                .setPositiveButton(getString(R.string.dialog_positive_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String regionName = regionNameEdit.getText().toString();
                        // Require a region name to begin the download.
                        // If the user-provided string is empty, display
                        // a toast message and do not begin download.
                        if (regionName.length() == 0) {
                            Toast.makeText(offlinemanager.this, getString(R.string.dialog_toast), Toast.LENGTH_SHORT).show();
                        } else {
                            // Begin download process
                            downloadRegion(regionName);
                        }
                    }
                })
                .setNegativeButton(getString(R.string.dialog_negative_button), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        // Display the dialog
        builder.show();
    }

    private void downloadRegion(final String regionName) {
        // Define offline region parameters, including bounds,
        // min/max zoom, and metadata

        // Start the progressBar
        startProgress();

        // Create offline definition using the current
        // style and boundaries of visible map area
        String styleUrl = map.getStyleUrl();
        LatLngBounds bounds = map.getProjection().getVisibleRegion().latLngBounds;
        double minZoom = map.getCameraPosition().zoom;
        double maxZoom = map.getMaxZoomLevel();
        float pixelRatio = this.getResources().getDisplayMetrics().density;
        OfflineTilePyramidRegionDefinition definition = new OfflineTilePyramidRegionDefinition(
                styleUrl, bounds, minZoom, maxZoom, pixelRatio);

        // Build a JSONObject using the user-defined offline region title,
        // convert it into string, and use it to create a metadata variable.
        // The metadata variable will later be passed to createOfflineRegion()
        byte[] metadata;
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put(JSON_FIELD_REGION_NAME, regionName);
            String json = jsonObject.toString();
            metadata = json.getBytes(JSON_CHARSET);
        } catch (Exception exception) {
            Log.e(TAG, "Failed to encode metadata: " + exception.getMessage());
            metadata = null;
        }

        // Create the offline region and launch the download
        offlineManager.createOfflineRegion(definition, metadata, new OfflineManager.CreateOfflineRegionCallback() {
            @Override
            public void onCreate(OfflineRegion offlineRegion) {
                Log.d(TAG, "Offline region created: " + regionName);
                offlinemanager.this.offlineRegion = offlineRegion;
                launchDownload();
            }

            @Override
            public void onError(String error) {
                Log.e(TAG, "Error: " + error);
            }
        });
    }

    private void launchDownload() {
        // Set up an observer to handle download progress and
        // notify the user when the region is finished downloading
        offlineRegion.setObserver(new OfflineRegion.OfflineRegionObserver() {
            @Override
            public void onStatusChanged(OfflineRegionStatus status) {
                // Compute a percentage
                double percentage = status.getRequiredResourceCount() >= 0
                        ? (100.0 * status.getCompletedResourceCount() / status.getRequiredResourceCount()) :
                        0.0;

                if (status.isComplete()) {
                    // Download complete
                    endProgress(getString(R.string.end_progress_success));
                    return;
                } else if (status.isRequiredResourceCountPrecise()) {
                    // Switch to determinate state
                    setPercentage((int) Math.round(percentage));
                }

                // Log what is being currently downloaded
                Log.d(TAG, String.format("%s/%s resources; %s bytes downloaded.",
                        String.valueOf(status.getCompletedResourceCount()),
                        String.valueOf(status.getRequiredResourceCount()),
                        String.valueOf(status.getCompletedResourceSize())));
            }

            @Override
            public void onError(OfflineRegionError error) {
                Log.e(TAG, "onError reason: " + error.getReason());
                Log.e(TAG, "onError message: " + error.getMessage());
            }

            @Override
            public void mapboxTileCountLimitExceeded(long limit) {
                Log.e(TAG, "Mapbox tile count limit exceeded: " + limit);
            }
        });

        // Change the region state
        offlineRegion.setDownloadState(OfflineRegion.STATE_ACTIVE);
    }

    private void downloadedRegionList() {
        // Build a region list when the user clicks the list button

        // Reset the region selected int to 0
        regionSelected = 0;

        // Query the DB asynchronously
        offlineManager.listOfflineRegions(new OfflineManager.ListOfflineRegionsCallback() {
            @Override
            public void onList(final OfflineRegion[] offlineRegions) {
                // Check result. If no regions have been
                // downloaded yet, notify user and return
                if (offlineRegions == null || offlineRegions.length == 0) {
                    Toast.makeText(getApplicationContext(), getString(R.string.toast_no_regions_yet), Toast.LENGTH_SHORT).show();
                    return;
                }

                // Add all of the region names to a list
                ArrayList<String> offlineRegionsNames = new ArrayList<>();
                for (OfflineRegion offlineRegion : offlineRegions) {
                    offlineRegionsNames.add(getRegionName(offlineRegion));
                }
                final CharSequence[] items = offlineRegionsNames.toArray(new CharSequence[offlineRegionsNames.size()]);

                // Build a dialog containing the list of regions
                AlertDialog dialog = new AlertDialog.Builder(offlinemanager.this)
                        .setTitle(getString(R.string.navigate_title))
                        .setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Track which region the user selects
                                regionSelected = which;
                            }
                        })
                        .setPositiveButton(getString(R.string.navigate_positive_button), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                Toast.makeText(offlinemanager.this, items[regionSelected], Toast.LENGTH_LONG).show();

                                // Get the region bounds and zoom
                                LatLngBounds bounds = ((OfflineTilePyramidRegionDefinition)
                                        offlineRegions[regionSelected].getDefinition()).getBounds();
                                double regionZoom = ((OfflineTilePyramidRegionDefinition)
                                        offlineRegions[regionSelected].getDefinition()).getMinZoom();

                                // Create new camera position
                                CameraPosition cameraPosition = new CameraPosition.Builder()
                                        .target(bounds.getCenter())
                                        .zoom(regionZoom)
                                        .build();

                                // Move camera to new position
                                map.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

                            }
                        })
                        .setNeutralButton(getString(R.string.navigate_neutral_button_title), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // Make progressBar indeterminate and
                                // set it to visible to signal that
                                // the deletion process has begun
                                progressBar.setIndeterminate(true);
                                progressBar.setVisibility(View.VISIBLE);

                                // Begin the deletion process
                                offlineRegions[regionSelected].delete(new OfflineRegion.OfflineRegionDeleteCallback() {
                                    @Override
                                    public void onDelete() {
                                        // Once the region is deleted, remove the
                                        // progressBar and display a toast
                                        progressBar.setVisibility(View.INVISIBLE);
                                        progressBar.setIndeterminate(false);
                                        Toast.makeText(getApplicationContext(), getString(R.string.toast_region_deleted),
                                                Toast.LENGTH_LONG).show();
                                    }

                                    @Override
                                    public void onError(String error) {
                                        progressBar.setVisibility(View.INVISIBLE);
                                        progressBar.setIndeterminate(false);
                                        Log.e(TAG, "Error: " + error);
                                    }
                                });
                            }
                        })
                        .setNegativeButton(getString(R.string.navigate_negative_button_title), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // When the user cancels, don't do anything.
                                // The dialog will automatically close
                            }
                        }).create();
                dialog.show();

            }

            @Override
            public void onError(String error) {
                Log.e(TAG, "Error: " + error);
            }
        });
    }

    private String getRegionName(OfflineRegion offlineRegion) {
        // Get the region name from the offline region metadata
        String regionName;

        try {
            byte[] metadata = offlineRegion.getMetadata();
            String json = new String(metadata, JSON_CHARSET);
            JSONObject jsonObject = new JSONObject(json);
            regionName = jsonObject.getString(JSON_FIELD_REGION_NAME);
        } catch (Exception exception) {
            Log.e(TAG, "Failed to decode metadata: " + exception.getMessage());
            regionName = String.format(getString(R.string.region_name), offlineRegion.getID());
        }
        return regionName;
    }
    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        return false;
    }

    // Progress bar methods
    private void startProgress() {
        // Disable buttons
        downloadButton.setEnabled(false);
        listButton.setEnabled(false);

        // Start and show the progress bar
        isEndNotified = false;
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void setPercentage(final int percentage) {
        progressBar.setIndeterminate(false);
        progressBar.setProgress(percentage);
    }

    private void endProgress(final String message) {
        // Don't notify more than once
        if (isEndNotified) {
            return;
        }

        // Enable buttons
        downloadButton.setEnabled(true);
        listButton.setEnabled(true);

        // Stop and hide the progress bar
        isEndNotified = true;
        progressBar.setIndeterminate(false);
        progressBar.setVisibility(View.GONE);

        // Show a toast
        Toast.makeText(offlinemanager.this, message, Toast.LENGTH_LONG).show();
    }
}