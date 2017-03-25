package me.anky.scf;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Anky An on 25/03/2017.
 * anky25@gmail.com
 */

public class MainScreenFragmentAdapter extends FragmentPagerAdapter {

    // Total number of pages on the Main screen
    static final int NUM_ITEMS = 3;

    public MainScreenFragmentAdapter(FragmentManager fm){
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            final EventsFragment eventsFragment = new EventsFragment();
            return eventsFragment;
        } else if (position == 1) {
            final LocationsFragment locationsFragment = new LocationsFragment();
            return locationsFragment;
        } else {
            final ContactUsFragment contactUsFragment = new ContactUsFragment();
            return contactUsFragment;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
