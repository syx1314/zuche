package com.zql.app.lib.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import tjgl.com.android.lib.R;

/**
 * 自定义CheckBox,增加属性key/value
 * @author 曾繁添
 * @version 1.0
 *
 */
public class MyCheckBox extends android.widget.CheckBox {

	private String mKey;
	private String mValue;

	public MyCheckBox(Context context) {
		this(context,null);
	}
	
	public MyCheckBox(Context context, AttributeSet attrs) {
		this(context, attrs,android.R.attr.checkboxStyle);
	}
	
	public MyCheckBox(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
		// 获取自定义属性和默认值
		TypedArray mTypedArray = context.obtainStyledAttributes(attrs,R.styleable.TextView);
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
