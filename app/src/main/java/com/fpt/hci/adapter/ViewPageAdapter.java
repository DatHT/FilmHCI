package com.fpt.hci.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.fpt.hci.tabs.TabFilm;
import com.fpt.hci.tabs.TabPromotion;
import com.fpt.hci.tabs.TabSearch;

/**
 * Created by Daniel on 9/24/2015.
 * ViewPager adapter to provide the views for every page i.e every Tab
 */
public class ViewPageAdapter extends FragmentStatePagerAdapter {
    CharSequence titles[]; // store title of tab which are going to be pass when ViewPageAdapter is created
    int numOfTabs;

    public ViewPageAdapter(FragmentManager fm, CharSequence[] titles, int numOfTabs) {
        super(fm);
        this.titles = titles;
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            TabFilm film = new TabFilm();
            return film;
        }else if (position == 1) {
            TabSearch tabSearch = new TabSearch();
            return tabSearch;
        }else {
            TabPromotion tabPromotion = new TabPromotion();
            return tabPromotion;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
