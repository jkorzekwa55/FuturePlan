package com.example.futureplan;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Profil#newInstance} factory method to
 * create an instance of this fragment.
 */



public class Profil extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Profil() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Profil.
     */
    // TODO: Rename and change types and number of parameters
    public static Profil newInstance(String param1, String param2) {
        Profil fragment = new Profil();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profil, container, false);

        EditText PeditTextEmail = view.findViewById(R.id.PeditTextEmail);
        String email = PreferenceUtils.getEmail(getContext());
        PeditTextEmail.setText(email);

        EditText PeditTextN = view.findViewById(R.id.PeditTextN);
        String name = PreferenceUtils.getName(getContext());
        PeditTextN.setText(name);

        EditText PeditTextName = view.findViewById(R.id.PeditTextName);
        EditText PeditTextSName = view.findViewById(R.id.PeditTextSName);
        EditText PeditTextNumber = view.findViewById(R.id.PeditTextNumber);
        EditText PeditTextDate = view.findViewById(R.id.PeditTextDate);

        DataBaseHelper dataBaseHelper = new DataBaseHelper(getContext());

        Button btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PreferenceUtils.saveEmail("", getContext());
                PreferenceUtils.saveName("", getContext());
                startActivity(new Intent(getContext(), LogActivity.class));
            }
        });

        Button btnSave = view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserModel userModel;
                userModel = new UserModel(-1, PeditTextName.getText().toString(), PeditTextSName.getText().toString(), PeditTextN.getText().toString(),  PeditTextEmail.getText().toString(), "", PeditTextNumber.getText().toString(), PeditTextDate.getText().toString() );
                String em = PreferenceUtils.getEmail(getContext());
                dataBaseHelper.updateData(userModel, em);
            }
        });


        FloatingActionButton btnImage = view.findViewById(R.id.btnImage);
        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }

            void showAlertDialog() {
                GridView gridView = new GridView(getActivity());

                gridView.setAdapter(new ImageAdapter(view.getContext()));
                gridView.setNumColumns(3);
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // do something here
                    }
                });

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setView(gridView);
                builder.setTitle("Wybierz zdjecie profilowe:");
                builder.show();
            }
        });


        return view;
    }

}