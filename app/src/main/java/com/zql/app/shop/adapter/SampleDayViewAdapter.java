package com.zql.app.shop.adapter;

import android.view.ContextThemeWrapper;
import android.view.ViewGroup;
import android.widget.TextView;
import com.squareup.timessquare.CalendarCellView;
import com.squareup.timessquare.DayViewAdapter;
import com.zql.app.lib.util.ui.DisplayUtil;

public class SampleDayViewAdapter implements DayViewAdapter {
  @Override public void makeCellView(CalendarCellView parent) {
//    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//    View layout = inflater.inflate(R.layout.day_view_custom, parent, true);
////    parent.addView(layout);
//    layout.setDuplicateParentStateEnabled(true);
//    TextView textView = (TextView) layout.findViewById(R.id.day_view);
//    textView.setDuplicateParentStateEnabled(true);
//    parent.setDayOfMonthTextView(textView);
    TextView textView = new TextView(new ContextThemeWrapper(parent.getContext(), com.squareup.timessquare.R.style.CalendarCell_CalendarDate));
    textView.setDuplicateParentStateEnabled(true);
    textView.setTextSize(15);


    textView.setHeight(DisplayUtil.dipToPx(parent.getContext(),160));
    parent.addView(textView);
    parent.setDayOfMonthTextView(textView);
    ViewGroup.LayoutParams layoutParams = parent.getLayoutParams();
    layoutParams.height=DisplayUtil.dipToPx(parent.getContext(),160);
    parent.setLayoutParams(layoutParams);
  }
}
