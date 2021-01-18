package com.zql.app.lib.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import tjgl.com.android.lib.R;


/**
 * 自定义RadioButton,增加属性key/value
 * @author 曾繁添
 * @version 1.0
 *
 */
public class MyRadioButton extends android.widget.RadioButton {

	private String mKey;
	private String mValue;

	public MyRadioButton(Context context) {
		this(context,null);
	}

	public MyRadioButton(Context context, AttributeSet attrs) {
		this(context, attrs,android.R.attr.radioButtonStyle);
	}

	public MyRadioButton(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		//获取自定义属性和默认值
		TypedArray mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.TextView);
		mKey = mTypedArray.getString(R.styleable.TextView_key);
		mValue = mTypedArray.getString(R.styleable.TextView_value);
		mTypedArray.recycle();
	}

	public String getKey(){
		return mKey;
	}
	
	public void setKey(String key){
		this.mKey = key;
	}
	
	public String getValue() {
		return mValue;
	}

	public void setValue(String value) {
		this.mValue = value;
	}
}
