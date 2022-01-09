package com.example.futureplan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Terminarz#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Terminarz extends Fragment {
    private SimpleAdapter sa, sa2, sa3;
    private String nameOfDay;
    private String dateString;
    private String dayString;
    private String monthString;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Terminarz() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Terminarz.
     */
    // TODO: Rename and change types and number of parameters
    public static Terminarz newInstance(String param1, String param2) {
        Terminarz fragment = new Terminarz();
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
        View view = inflater.inflate(R.layout.fragment_terminarz, container, false);

        CalendarView simpleCalendarView = view.findViewById(R.id.simpleCalendarView);

        TextView date = view.findViewById(R.id.date);

        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
                switch (dayOfWeek) {
                    case Calendar.SUNDAY:
                        nameOfDay= "Niedziela";
                        break;
                    case Calendar.MONDAY:
                        nameOfDay= "Poniedziałek";
                        break;
                    case Calendar.TUESDAY:
                        nameOfDay= "Wtorek";
                        break;
                    case Calendar.THURSDAY:
                        nameOfDay= "Czwartek";
                        break;
                    case Calendar.SATURDAY:
                        nameOfDay= "Sobota";
                        break;
                    case Calendar.WEDNESDAY:
                        nameOfDay= "Środa";
                        break;
                    case Calendar.FRIDAY:
                        nameOfDay= "Piątek";
                        break;
                }
                month = month + 1;

                dayString = day + "";
                monthString = month + "";
                if(day<10){
                    dayString = "0" + day;
                }
                if(month<10){
                    monthString = "0" + month;
                }

                dateString = dayString + "." + monthString;

                date.setText(dateString);
                date.setVisibility(View.VISIBLE);

                DataBaseTimetable dataBaseTimetable = new DataBaseTimetable(getContext());

                ListView listViewCalendar = view.findViewById(R.id.listViewCalendar);

                ArrayList<HashMap<String,String>> list = dataBaseTimetable.getAdapterList(getContext(),nameOfDay);
                sa = new SimpleAdapter(getContext(), list,
                        R.layout.list_terminarz,
                        new String[] { "line1","line2" },
                        new int[] {R.id.line_b, R.id.line_a});
                ((ListView)view.findViewById(R.id.listViewCalendar)).setAdapter(sa);

                listViewCalendar.setVisibility(View.VISIBLE);

                //---------------------------------------\\

                DataBaseTests dataBaseTests = new DataBaseTests(getContext());

                ArrayList<HashMap<String,String>> list2 = dataBaseTests.getListTests(getContext(),dateString);

                sa2 = new SimpleAdapter(getContext(), list2,
                        R.layout.list_terminarz,
                        new String[] { "line1","line2" },
                        new int[] {R.id.line_b, R.id.line_a});
                ((ListView)view.findViewById(R.id.listViewTests)).setAdapter(sa2);

                //---------------------------------------\\

                DataBaseHomework dataBaseHomework = new DataBaseHomework(getContext());

                ArrayList<HashMap<String,String>> list3 = dataBaseHomework.getListHomework(getContext(),dateString);

                sa3 = new SimpleAdapter(getContext(), list3,
                        R.layout.list_terminarz,
                        new String[] { "line1","line2" },
                        new int[] {R.id.line_b, R.id.line_a});
                ((ListView)view.findViewById(R.id.listViewHomework)).setAdapter(sa3);
            }
        });

        return view;
    }
}