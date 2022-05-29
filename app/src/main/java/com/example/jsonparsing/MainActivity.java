package com.example.jsonparsing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    private String TAG = MainActivity.class.getSimpleName();

    private ProgressDialog pDialog;
    private ListView lv;

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    // URL to get contacts JSON
    private static String url = "https://fcm.live/webservice/api/schedule_page";

    ArrayList<HashMap<String, String>> showMonList, showTuesList, showWedList,
    showThursList, showFriList, showSatList, showSunList;
    HashMap<String, ArrayList> allShowHashMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         showMonList = new ArrayList<HashMap<String, String>>();
        showTuesList = new ArrayList<HashMap<String, String>>();
        showWedList = new ArrayList<HashMap<String, String>>();
        showThursList = new ArrayList<HashMap<String, String>>();
        showFriList = new ArrayList<HashMap<String, String>>();
        showSatList = new ArrayList<HashMap<String, String>>();
         showSunList = new ArrayList<HashMap<String, String>>();
         allShowHashMap = new HashMap<>();

        //lv = (ListView) findViewById(R.id.lvShow);

       /* viewPager = findViewById(R.id.viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);*/

        new GetContacts().execute();
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);

            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    JSONObject jsonallShows = jsonObj.getJSONObject("all_shows");

                    // Getting JSON Array node
                    JSONArray Monday = jsonallShows.getJSONArray("Monday");

                    // looping through All Contacts
                    for (int i = 0; i < Monday.length(); i++) {
                        JSONObject c = Monday.getJSONObject(i);

                        String id = c.getString("schedule_id");
                        String show_title = c.getString("show_title");
                        String image = c.getString("image");
                        String start_time = c.getString("start_time");
                        String end_time = c.getString("end_time");
                        String description = c.getString("description");

                        // tmp hash map for single contact
                        HashMap<String, String> mondayMAp = new HashMap<>();

                        // adding each child node to HashMap key => value
                        mondayMAp.put("id", id);
                        mondayMAp.put("show_title", show_title);
                        mondayMAp.put("image", image);
                        mondayMAp.put("start_time", start_time);
                        mondayMAp.put("end_time", end_time);
                        mondayMAp.put("description", description);

                        // adding contact to contact list
                        showMonList.add(mondayMAp);

                        allShowHashMap.put("Monday",showMonList);
                    }

                    // Getting JSON Array node
                    JSONArray Tuesdsy = jsonallShows.getJSONArray("Tuesday");

                    // looping through All Contacts
                    for (int i = 0; i < Tuesdsy.length(); i++) {
                        JSONObject c = Tuesdsy.getJSONObject(i);

                        String id = c.getString("schedule_id");
                        String show_title = c.getString("show_title");
                        String image = c.getString("image");
                        String start_time = c.getString("start_time");
                        String end_time = c.getString("end_time");
                        String description = c.getString("description");

                        // tmp hash map for single contact
                        HashMap<String, String> TuesdsyMAp = new HashMap<>();

                        // adding each child node to HashMap key => value
                        TuesdsyMAp.put("id", id);
                        TuesdsyMAp.put("show_title", show_title);
                        TuesdsyMAp.put("image", image);
                        TuesdsyMAp.put("start_time", start_time);
                        TuesdsyMAp.put("end_time", end_time);
                        TuesdsyMAp.put("description", description);

                        // adding contact to contact list
                        showTuesList.add(TuesdsyMAp);

                      //  allShowHashMap.put("Monday",showMonList);
                        allShowHashMap.put("Tuesday",showTuesList);
                    }

                    // Getting JSON Array node
                    JSONArray Wednesday = jsonallShows.getJSONArray("Wednesday");
                    // looping through All Contacts
                    for (int i = 0; i < Wednesday.length(); i++) {
                        JSONObject c = Wednesday.getJSONObject(i);

                        String id = c.getString("schedule_id");
                        String show_title = c.getString("show_title");
                        String image = c.getString("image");
                        String start_time = c.getString("start_time");
                        String end_time = c.getString("end_time");
                        String description = c.getString("description");

                        // tmp hash map for single contact
                        HashMap<String, String> WednesdayMAp = new HashMap<>();

                        // adding each child node to HashMap key => value
                        WednesdayMAp.put("id", id);
                        WednesdayMAp.put("show_title", show_title);
                        WednesdayMAp.put("image", image);
                        WednesdayMAp.put("start_time", start_time);
                        WednesdayMAp.put("end_time", end_time);
                        WednesdayMAp.put("description", description);

                        // adding contact to contact list
                        showWedList.add(WednesdayMAp);

                        allShowHashMap.put("Wednesday",showWedList);
                    }
                    // Getting JSON Array node
                    JSONArray Thursday = jsonallShows.getJSONArray("Thursday");
                    // looping through All Contacts
                    for (int i = 0; i < Thursday.length(); i++) {
                        JSONObject c = Thursday.getJSONObject(i);

                        String id = c.getString("schedule_id");
                        String show_title = c.getString("show_title");
                        String image = c.getString("image");
                        String start_time = c.getString("start_time");
                        String end_time = c.getString("end_time");
                        String description = c.getString("description");

                        // tmp hash map for single contact
                        HashMap<String, String> ThursdayMAp = new HashMap<>();

                        // adding each child node to HashMap key => value
                        ThursdayMAp.put("id", id);
                        ThursdayMAp.put("show_title", show_title);
                        ThursdayMAp.put("image", image);
                        ThursdayMAp.put("start_time", start_time);
                        ThursdayMAp.put("end_time", end_time);
                        ThursdayMAp.put("description", description);

                        // adding contact to contact list
                        showThursList.add(ThursdayMAp);

                        allShowHashMap.put("Thursday",showThursList);
                    }

                    // Getting JSON Array node
                    JSONArray Friday = jsonallShows.getJSONArray("Friday");
                    // looping through All Contacts
                    for (int i = 0; i < Friday.length(); i++) {
                        JSONObject c = Friday.getJSONObject(i);

                        String id = c.getString("schedule_id");
                        String show_title = c.getString("show_title");
                        String image = c.getString("image");
                        String start_time = c.getString("start_time");
                        String end_time = c.getString("end_time");
                        String description = c.getString("description");

                        // tmp hash map for single contact
                        HashMap<String, String> FridayMAp = new HashMap<>();

                        // adding each child node to HashMap key => value
                        FridayMAp.put("id", id);
                        FridayMAp.put("show_title", show_title);
                        FridayMAp.put("image", image);
                        FridayMAp.put("start_time", start_time);
                        FridayMAp.put("end_time", end_time);
                        FridayMAp.put("description", description);

                        // adding contact to contact list
                        showFriList.add(FridayMAp);

                        allShowHashMap.put("Friday",showFriList);
                    }

                    // Getting JSON Array node
                    JSONArray Saturday = jsonallShows.getJSONArray("Saturday");
                    // looping through All Contacts
                    for (int i = 0; i < Saturday.length(); i++) {
                        JSONObject c = Saturday.getJSONObject(i);

                        String id = c.getString("schedule_id");
                        String show_title = c.getString("show_title");
                        String image = c.getString("image");
                        String start_time = c.getString("start_time");
                        String end_time = c.getString("end_time");
                        String description = c.getString("description");

                        // tmp hash map for single contact
                        HashMap<String, String> SaturdayMAp = new HashMap<>();

                        // adding each child node to HashMap key => value
                        SaturdayMAp.put("id", id);
                        SaturdayMAp.put("show_title", show_title);
                        SaturdayMAp.put("image", image);
                        SaturdayMAp.put("start_time", start_time);
                        SaturdayMAp.put("end_time", end_time);
                        SaturdayMAp.put("description", description);

                        // adding contact to contact list
                        showSatList.add(SaturdayMAp);

                        allShowHashMap.put("Saturday",showSatList);
                    }

                    // Getting JSON Array node
                    JSONArray Sunday = jsonallShows.getJSONArray("Sunday");
                    // looping through All Contacts
                    for (int i = 0; i < Sunday.length(); i++) {
                        JSONObject c = Sunday.getJSONObject(i);

                        String id = c.getString("schedule_id");
                        String show_title = c.getString("show_title");
                        String image = c.getString("image");
                        String start_time = c.getString("start_time");
                        String end_time = c.getString("end_time");
                        String description = c.getString("description");

                        // tmp hash map for single contact
                        HashMap<String, String> SundayMAp = new HashMap<>();

                        // adding each child node to HashMap key => value
                        SundayMAp.put("id", id);
                        SundayMAp.put("show_title", show_title);
                        SundayMAp.put("image", image);
                        SundayMAp.put("start_time", start_time);
                        SundayMAp.put("end_time", end_time);
                        SundayMAp.put("description", description);

                        // adding contact to contact list
                        showSunList.add(SundayMAp);

                        allShowHashMap.put("Sunday",showSunList);
                    }

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();
            /**
             * Updating parsed JSON data into ListView
             * */

            Log.e("DS","@*@"+allShowHashMap.size());

            viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), allShowHashMap);
            viewPager = findViewById(R.id.viewPager);
            tabLayout = (TabLayout) findViewById(R.id.tabs);
            viewPager.setAdapter(viewPagerAdapter);
            tabLayout.setupWithViewPager(viewPager);
            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
            Date d = new Date();
            String dayOfTheWeek = sdf.format(d);
            if ("Monday".equals(dayOfTheWeek)) {
                tabLayout.setScrollPosition(0,0f,true);
                viewPager.setCurrentItem(0);
            }
            if ("Tuesday".equals(dayOfTheWeek)) {
                tabLayout.setScrollPosition(1,0f,true);
                viewPager.setCurrentItem(1);
            }
            if ("Wednesday".equals(dayOfTheWeek)) {
                tabLayout.setScrollPosition(2,0f,true);
                viewPager.setCurrentItem(2);
            }
            if ("Thursday".equals(dayOfTheWeek)) {
                tabLayout.setScrollPosition(3,0f,true);
                viewPager.setCurrentItem(3);
            }
            if ("Friday".equals(dayOfTheWeek)) {
                tabLayout.setScrollPosition(4,0f,true);
                viewPager.setCurrentItem(4);
            }
            if ("Saturday".equals(dayOfTheWeek)) {
                tabLayout.setScrollPosition(5,0f,true);
                viewPager.setCurrentItem(5);
            }
            if ("Sunday".equals(dayOfTheWeek)) {
                tabLayout.setScrollPosition(6,0f,true);
                viewPager.setCurrentItem(6);
            }
            //tabLayout.

        }

    }


}