package com.fpt.hci.fragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.fpt.hci.activity.R;

import java.util.Calendar;

/**
 * Created by HongLinh on 10/16/2015.
 */
public class TimePickerFragment extends DialogFragment
        implements TimePickerDialog.OnTimeSetListener {
    TextView txtTime;
    private int mId;
    public static TimePickerFragment newInstance(int id)
    {
        Bundle args = new Bundle();
        args.putInt("picker_id", id);
        TimePickerFragment fragment = new TimePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current time as the default values for the picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        mId = getArguments().getInt("picker_id");
        // Create a new instance of TimePickerDialog and return it
        return new TimePickerDialog(getActivity(), this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        txtTime = (TextView) getActivity().findViewById(mId);
        String hour = ((hourOfDay+"").length()>1)?(hourOfDay+""):("0"+hourOfDay);
        String min = ((minute+"").length()>1)?(minute+""):("0"+minute);
        txtTime.setText(hour + ":" + min);
    }
}
