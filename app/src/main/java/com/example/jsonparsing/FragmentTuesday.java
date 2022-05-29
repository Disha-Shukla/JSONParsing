package com.example.jsonparsing;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentTuesday extends Fragment {

    ListView list;
    HashMap<String, ArrayList> allShowHashMap;
    ArrayList<HashMap<String, String>> TuesdayArray;

    public FragmentTuesday(HashMap<String, ArrayList> allShowHashMap) {
        // Required empty public constructor
        this.allShowHashMap = allShowHashMap;
        TuesdayArray = new ArrayList<>();
        TuesdayArray = allShowHashMap.get("Tuesday");
        Log.e("DS","###"+TuesdayArray.size());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monday, container, false);
        list = view.findViewById(R.id.lvMonday);
        CustomAdapter adapter = new CustomAdapter(TuesdayArray,getActivity());
        list.setAdapter(adapter);
        return view;
    }

}
