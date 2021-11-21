package com.example.futureplan;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch(position) {
            case 1 :
                return new PlanLekcjiPage2();
            case 2:
                return new PlanLekcjiPage3();
        }

        return new PlanLekcjiPage1();
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
