package com.africa.cloud.basefirebase.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.africa.cloud.basefirebase.CommandeFragment;
import com.africa.cloud.basefirebase.InfoFragment;
import com.africa.cloud.basefirebase.TarifsFragment;

public class PageAdapter extends FragmentPagerAdapter {

    private int numOfTabs;

    public PageAdapter(FragmentManager fm,int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new InfoFragment();
            case 1:
                return new CommandeFragment();
            case 2:
                return new TarifsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
