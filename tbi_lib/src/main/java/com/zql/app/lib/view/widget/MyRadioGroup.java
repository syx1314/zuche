package com.zql.app.lib.view.widget;

import android.content.Context;
import android.util.AttributeSet;

public class MyRadioGroup extends android.widget.RadioGroup {

	public MyRadioGroup(Context context) {
		super(context);
	}

	public MyRadioGroup(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	// 设置子控件的值
	public void setChildValue() {
		int n = this.getChildCount();
		for (int i = 0; i < n; i++) {
			final MyRadioButton radio = (MyRadioButton) this.getChildAt(i);
			if (radio.getValue().equals(this.mValue)) {
				radio.setChecked(true);
			} else {
				radio.setChecked(false);
			}
		}
	}

	// 获取子类的值
	public void getChildValue() {
		int n = this.getChildCount();
		for (int i = 0; i < n; i++) {
			MyRadioButton radio = (MyRadioButton) this.getChildAt(i);
			if (radio.isChecked()) {
				this.mValue = radio.getValue();
			}
		}
	}

	private String mValue;
	
	public void setValue(String value) {
		this.mValue = value;
		setChildValue();
	}

	public String getValue() {
		getChildValue();
		return this.mValue;
	}

}
