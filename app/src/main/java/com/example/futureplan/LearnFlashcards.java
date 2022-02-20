package com.example.futureplan;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.wajahatkarim3.easyflipview.EasyFlipView;

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearnFlashcards#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearnFlashcards extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LearnFlashcards() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearnFlashcards.
     */
    // TODO: Rename and change types and number of parameters
    public static LearnFlashcards newInstance(String param1, String param2) {
        LearnFlashcards fragment = new LearnFlashcards();
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
        View view = inflater.inflate(R.layout.fragment_learn_flashcards, container, false);

        TextView frontOpis = view.findViewById(R.id.frontOpis);
        TextView frontNotatka = view.findViewById(R.id.frontNotatka);
        TextView backOpis = view.findViewById(R.id.backOpis);
        TextView backNotatka = view.findViewById(R.id.backNotatka);
        Button nextFlash = view.findViewById(R.id.nextFlash);
        FCDBHelper DB = new FCDBHelper(getContext());
        EasyFlipView easyFlipView = view.findViewById(R.id.easyFlipView);
        Button deleteFlash = view.findViewById(R.id.deleteFlash);
        Button prevFlash = view.findViewById(R.id.prevFlash);

        String nazwa = getArguments().getString("nazwa");
        Cursor cursor = DB.getFlashKit(nazwa);

        cursor.move(1);
        frontOpis.setText(cursor.getString(2));
        frontNotatka.setText(cursor.getString(3));
        backOpis.setText(cursor.getString(4));
        backNotatka.setText(cursor.getString(5));


        nextFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(cursor.getPosition() != cursor.getCount()-1) {
                    cursor.moveToNext();
                    if(easyFlipView.isBackSide()){
                        easyFlipView.flipTheView();
                    }
                }
                frontOpis.setText(cursor.getString(2));
                frontNotatka.setText(cursor.getString(3));
                backOpis.setText(cursor.getString(4));
                backNotatka.setText(cursor.getString(5));
            }
        });

        prevFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cursor.getPosition() != 0){
                    cursor.moveToPrevious();
                    if(easyFlipView.isBackSide()){
                        easyFlipView.flipTheView();
                    }
                }

                frontOpis.setText(cursor.getString(2));
                frontNotatka.setText(cursor.getString(3));
                backOpis.setText(cursor.getString(4));
                backNotatka.setText(cursor.getString(5));
            }
        });

        deleteFlash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("checkDelete", "yes");
                bundle2.putString("nazwa", nazwa);


                Navigation.findNavController(view).navigate(R.id.menuFiszki, bundle2);
            }
        });




        return view;
    }
}