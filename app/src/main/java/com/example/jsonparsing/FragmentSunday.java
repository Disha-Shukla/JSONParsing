package com.example.jsonparsing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.HashMap;

public class FragmentSunday extends Fragment {

    ListView list;
    HashMap<String, ArrayList> allShowHashMap;
    ArrayList<HashMap<String, String>> SundayArray;

    public FragmentSunday(HashMap<String, ArrayList> allShowHashMap) {
        // Required empty public constructor
        this.allShowHashMap = allShowHashMap;
        SundayArray = new ArrayList<>();
        SundayArray = allShowHashMap.get("Sunday");
      //  Log.e("DS","###"+WednesdayArray.size());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monday, container, false);
        list = view.findViewById(R.id.lvMonday);
        CustomAdapter adapter = new CustomAdapter(SundayArray,getActivity());
        list.setAdapter(adapter);
        return view;
    }

}
