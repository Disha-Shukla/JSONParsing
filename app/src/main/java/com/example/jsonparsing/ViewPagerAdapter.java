package com.example.jsonparsing;

//import android.app.Fragment;
//import android.app.FragmentManager;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    HashMap<String, ArrayList> allShowHashMap;
    public ViewPagerAdapter(FragmentManager fm, HashMap<String, ArrayList> allShowHashMap) {
        super(fm);
        this.allShowHashMap = allShowHashMap;
        Log.e("DS","@@@"+allShowHashMap.size());
    }
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new FragmentMonday(allShowHashMap);
        }
        else if (position == 1)
        {
            fragment = new FragmentTuesday(allShowHashMap);
        }
        else if (position == 2)
        {
            fragment = new FragmentWednesday(allShowHashMap);
        }
        else if (position == 3)
        {
            fragment = new FragmentThursday(allShowHashMap);
        }
        else if (position == 4)
        {
            fragment = new FragmentFriday(allShowHashMap);
        }
        else if (position == 5)
        {
            fragment = new FragmentSaturday(allShowHashMap);
        }
        else if (position == 6)
        {
            fragment = new FragmentSunday(allShowHashMap);
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 7;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Monday";
        }
        else if (position == 1)
        {
            title = "Tuesday";
        }
        else if (position == 2)
        {
            title = "Wednesday";
        }
        else if (position == 6)
        {
            title = "Sunday";
        }
        else if (position == 3)
        {
            title = "Thursday";
        }
        else if (position == 4)
        {
            title = "Friday";
        }
        else if (position == 5)
        {
            title = "Saturday";
        }
        return title;
    }

}
