package com.example.futureplan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link addNewFlashcards#newInstance} factory method to
 * create an instance of this fragment.
 */
public class addNewFlashcards extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public addNewFlashcards() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment addNewFlashcards.
     */
    // TODO: Rename and change types and number of parameters
    public static addNewFlashcards newInstance(String param1, String param2) {
        addNewFlashcards fragment = new addNewFlashcards();
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
        View view = inflater.inflate(R.layout.fragment_add_new_flashcards, container, false);

        FloatingActionButton addNewFlash = view.findViewById(R.id.addNewFlashcardsButton);
        ExtendedFloatingActionButton saveFlashcard = view.findViewById(R.id.saveFlashcards);
        RecyclerView fiszkiRecycler = view.findViewById(R.id.fiszkiRecycler);



        fiszkiRecycler.setLayoutManager(
                new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        );

        ArrayList<Flashcard> flashcardList = new ArrayList<>();

        addNewFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flashcardList.add(new Flashcard());
                fiszkiRecycler.setAdapter(new FlashcardAdapter(flashcardList));
            }
        });


        saveFlashcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText o1 = fiszkiRecycler.findViewById(R.id.opis);
                EditText n1 = fiszkiRecycler.findViewById(R.id.notatka);
                EditText o2 = fiszkiRecycler.findViewById(R.id.opis2);
                EditText n2 = fiszkiRecycler.findViewById(R.id.notatka2);



                for(int i = 0 ; i < flashcardList.size(); i++ )
                {
                    //lashcardList.get(i).setData(fiszkiRecycler.findViewById(R.id.opis).toString());


                  flashcardList.get(i).setData(
                                   o1.getText().toString(),
                                   n1.getText().toString(),
                                   o2.getText().toString(),
                                   n2.getText().toString()
                   );
                    System.out.println(flashcardList.get(i).getOp1() + flashcardList.get(i).getN1() + flashcardList.get(i).getOp2() + flashcardList.get(i).getN2());
                }



                // System.out.println(flashcardList.get(0).getOp1());
                //System.out.println(flashcardList.get(1).getOp1());


            }
        });

        return view;
    }
}