package com.example.futureplan;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.makeramen.roundedimageview.RoundedImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditPlan#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditPlan extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EditPlan() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditPlan.
     */
    // TODO: Rename and change types and number of parameters
    public static EditPlan newInstance(String param1, String param2) {
        EditPlan fragment = new EditPlan();
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

        View view = inflater.inflate(R.layout.fragment_edit_plan, container, false);

        //Ustawienie koloru ikonek
        TextInputLayout txt = view.findViewById(R.id.txtinput);
        TextInputLayout txt2 = view.findViewById(R.id.calendarInput);
        txt.setStartIconTintList(null);
        txt2.setStartIconTintList(null);

        //Pole wybierz przedmiot
        //String[] items = {"Historia", "Informatyka", "Język Polski", "Matematyka"}; // 2 Sposoby
        String[] items = getResources().getStringArray(R.array.subjectsarray);
        AutoCompleteTextView autoCompleteTxt;
        ArrayAdapter<String> adapterItems;

        autoCompleteTxt = view.findViewById(R.id.autoCompleteTextView);
        adapterItems = new ArrayAdapter<String>(requireContext(), R.layout.subjects, items);
        autoCompleteTxt.setAdapter(adapterItems);

        //Wybór dnia danej lekcji
        String[] daysOfWeek = {"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"};
        AutoCompleteTextView autoCompleteTxt2;
        ArrayAdapter<String> adapterItems2;
        autoCompleteTxt2 = view.findViewById(R.id.autoCompleteTextView2);
        adapterItems2 = new ArrayAdapter<String>(requireContext(), R.layout.subjects, daysOfWeek);
        autoCompleteTxt2.setAdapter(adapterItems2);

        return view;
    }
}