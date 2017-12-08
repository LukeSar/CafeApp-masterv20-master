package com.example.lukesartori.myapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.lukesartori.myapp.Tab1;
import com.example.lukesartori.myapp.Tab2;
import com.example.lukesartori.myapp.Tab3;

/**
 * Created by Luke on 07/12/2017.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs) {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;

            case 1:
                Tab2 tab2 = new Tab2();
                return tab2;

            case 2:
                Tab3 tab3 = new Tab3();
                return tab3;

            case 3:
                tab4 tab4 = new tab4();
                return tab4;
                    default:
                    return null;
        }

    }
    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
