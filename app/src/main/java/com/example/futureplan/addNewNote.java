package com.example.futureplan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addNewNote#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addNewNote extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public addNewNote() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addNewNote.
     */
    // TODO: Rename and change types and number of parameters
    public static addNewNote newInstance(String param1, String param2) {
        addNewNote fragment = new addNewNote();
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
        View view = inflater.inflate(R.layout.fragment_add_new_note, container, false);

        TextInputLayout titleInputTxt = view.findViewById(R.id.title_text_input);
        EditText editTextNote = view.findViewById(R.id.editTextNote);
        Button btnAdd = view.findViewById(R.id.btnAdd);

        Button btnBack = view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_addNewNote_to_notesList);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = titleInputTxt.getEditText().getText().toString();
                String note = editTextNote.getText().toString();

                try {
                    File file2 = new File(getContext().getFilesDir(),"notes.json");
                    String strFileJson = MyJSON.getStringFromFile(file2.toString());
                    JSONArray array = new JSONArray(strFileJson);

                    JSONObject newJsonObject = new JSONObject();
                    newJsonObject.put("Title", title);
                    newJsonObject.put("Note", note);

                    array.put(newJsonObject);

                    File file = new File(getContext().getFilesDir(),"notes.json");
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    bufferedWriter.write(array.toString());
                    bufferedWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Navigation.findNavController(view).navigate(R.id.action_addNewNote_to_notesList);
            }

        });



        return view;
    }
}