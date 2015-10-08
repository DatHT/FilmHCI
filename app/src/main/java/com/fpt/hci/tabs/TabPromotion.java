package com.fpt.hci.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fpt.hci.activity.R;

/**
 * Created by Daniel on 9/24/2015.
 */
public class TabPromotion extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_promotion, container, false);
        return v;
    }
}
