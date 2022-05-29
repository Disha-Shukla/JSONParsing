package com.example.jsonparsing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;


public class FragmentMonday extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   /* private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;*/

    ListView list;
    HashMap<String, ArrayList> allShowHashMap;
    ArrayList<HashMap<String, String>> mondayArray;

        public FragmentMonday(HashMap<String, ArrayList> allShowHashMap) {
            // Required empty public constructor
            this.allShowHashMap = allShowHashMap;
            mondayArray = new ArrayList<>();
            mondayArray = allShowHashMap.get("Monday");
            Log.e("DS","###"+mondayArray.size());
        }


    // TODO: Rename and change types and number of parameters
    /*public static FragmentMonday newInstance(String param1, String param2) {
        FragmentMonday fragment = new FragmentMonday(allShowHashMap);
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            *//*mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);*//*
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_monday, container, false);
        list = view.findViewById(R.id.lvMonday);
        CustomAdapter adapter = new CustomAdapter(mondayArray,getActivity());
        list.setAdapter(adapter);
        return view;
    }
}