package com.example.futureplan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GridviewPomoce#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GridviewPomoce extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GridviewPomoce() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GridviewPomoce.
     */
    // TODO: Rename and change types and number of parameters
    public static GridviewPomoce newInstance(String param1, String param2) {
        GridviewPomoce fragment = new GridviewPomoce();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gridview_pomoce, container, false);
        GridView gridView = view.findViewById(R.id.gridView);

        String jsonFileString = MyJSON.getAssetJsonData(getContext(), "pomoce_naukowe.json");

        Gson gson = new Gson();
        Type listSubjectsType = new TypeToken<List<Subjects>>() { }.getType();

        String items[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        int imageId[] = {R.drawable.polski, R.drawable.angielski, R.drawable.niemiecki, R.drawable.matematyka, R.drawable.fizyka, R.drawable.chemia, R.drawable.biologia, R.drawable.geografia};
        List<Subjects> subject = gson.fromJson(jsonFileString, listSubjectsType);

        for (int i = 0; i < subject.size(); i++) {
            items[i] = subject.get(i).getName();
        }

        CustomGrid adapter = new CustomGrid(getContext(), items, imageId);
        GridView grid=(GridView)view.findViewById(R.id.gridView);
        grid.setAdapter(adapter);


    gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            PreferenceUtils.saveSubjectID(i,getContext());
            Navigation.findNavController(view).navigate(R.id.action_gridviewPomoce_to_pomoceNaukoweRozdzialy);
        }
    });

        return view;
    }
}