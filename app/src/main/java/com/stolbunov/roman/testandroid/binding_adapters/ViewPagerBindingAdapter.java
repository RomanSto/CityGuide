package com.stolbunov.roman.testandroid.binding_adapters;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.viewpager.widget.ViewPager;

public class ViewPagerBindingAdapter {
    @BindingAdapter("setDataVP")
    public static <T> void setDataVP(ViewPager viewPager, List<T> data) {
        if (data != null) {
            IDataAdapter adapter = (IDataAdapter) viewPager.getAdapter();
            if (adapter != null) {
                adapter.setData(data);
            }
        }
    }

    @BindingAdapter(value = "selectedPosition")
    public static void setSelectedPosition(ViewPager pager, Integer position) {
        if (position != null) {
            pager.setCurrentItem(position);
        } else {
            if (pager.getCurrentItem() != 0) {
                pager.setCurrentItem(0);
            }
        }
    }

    @BindingAdapter("selectedPositionAttrChanged")
    public static void setSelectedPositionAttrChanged(ViewPager pager,
                                                      final InverseBindingListener listener) {
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                listener.onChange();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @InverseBindingAdapter(attribute = "selectedPosition")
    public static Integer getSelectedPosition(ViewPager pager) {
        return pager.getCurrentItem();
    }
}
