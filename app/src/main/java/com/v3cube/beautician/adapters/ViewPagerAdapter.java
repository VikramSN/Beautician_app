package com.v3cube.beautician.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.v3cube.beautician.fragment.jobtab.PastJob;
import com.v3cube.beautician.fragment.jobtab.UpcomingJob;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private String title[] = {"PAST", "UPCOMING"};

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PastJob();

            case 1:
                return new UpcomingJob();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return title.length;
    }

}