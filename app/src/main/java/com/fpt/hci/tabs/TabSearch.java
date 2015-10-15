package com.fpt.hci.tabs;

import android.app.ActionBar;
import android.app.DatePickerDialog;
import android.app.FragmentTransaction;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.TextView;

import com.fpt.hci.activity.R;
import com.fpt.hci.activity.SearchActivity;
import com.fpt.hci.fragment.TimePickerFragment;

import java.sql.Time;
import java.util.Calendar;

/**
 * Created by Daniel on 9/24/2015.
 */
public class TabSearch extends Fragment {

    Button btnSubmit;
    TextView txtTimeFrom;
    TextView txtTimeTo;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_search, container, false);
        txtTimeFrom = (TextView) v.findViewById(R.id.txtTimeFrom);
        txtTimeTo = (TextView) v.findViewById(R.id.txtTimeTo);
        btnSubmit = (Button) v.findViewById(R.id.btnSubmit);
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        txtTimeFrom.setText(hour + ":" + minute);
        txtTimeTo.setText(hour + ":" + minute);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
            }
        });


        txtTimeFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(R.id.txtTimeFrom);
            }
        });


        txtTimeTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(R.id.txtTimeTo);
            }
        });

        return v;
    }

    private void showDatePicker(int id) {
        DialogFragment newFragment = TimePickerFragment.newInstance(id);
        newFragment.show(getFragmentManager(),"TimePicker");
    }
}
