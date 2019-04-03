package com.stolbunov.roman.testandroid.binding_adapters;

import com.stolbunov.roman.domain.entity.organization.WorkTime;
import com.stolbunov.roman.testandroid.R;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingAdapter;

public class TextViewBindingAdapter {
    @BindingAdapter(value = {"setValue", "setStringFormat"})
    public static void setText(AppCompatTextView textView, String value, String stringFormat) {
        if (value != null && stringFormat != null) {
            textView.setText(String.format(stringFormat, value));
        }
    }

    @BindingAdapter(value = {"setTodayWorkTime"})
    public static void setWorkTime(AppCompatTextView textView, WorkTime workTimes) {
        if (workTimes != null) {
            textView.setText(
                    textView.getContext()
                            .getString(R.string.today_work_time_format,
                                    workTimes.getFrom(),
                                    workTimes.getTo()));
        }
    }
}
