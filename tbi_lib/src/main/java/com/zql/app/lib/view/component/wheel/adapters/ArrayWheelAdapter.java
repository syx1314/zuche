/*
 *  Copyright 2011 Yuri Kanivets
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.zql.app.lib.view.component.wheel.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.TextView;

import com.zql.app.lib.util.ui.DisplayUtil;

/**
 * The simple Array wheel adapter
 * @param <T> the element type
 */
public class ArrayWheelAdapter<T> extends AbstractWheelTextAdapter {
    
    // items
    private T[] items;

    /**
     * Constructor
     * @param context the current context
     * @param items the items
     */
    public ArrayWheelAdapter(Context context, T[] items) {
        super(context);
        
        //setEmptyItemResource(TEXT_VIEW_ITEM_RESOURCE);
        this.items = items;
    }

    public ArrayWheelAdapter(Context context, T[] items, int currentIndex) {
        super(context);

        //setEmptyItemResource(TEXT_VIEW_ITEM_RESOURCE);
        this.items = items;
        this.currentIndex=currentIndex;
    }

    
    @Override
    public CharSequence getItemText(int index) {
        if (index >= 0 && index < items.length) {
            T item = items[index];
            if (item instanceof CharSequence) {
                return (CharSequence) item;
            }
            if(item!=null) {
                return item.toString();
            }else{
                return null;
            }
        }
        return null;
    }

    @Override
    public int getItemsCount() {
        return items.length;
    }

    @Override
    public void setCurItem(int pos) {
        for(View tv:getTestViews()){
            TextView textView=(TextView)tv;
            textView.setTextSize(14);
            textView.setTextColor(0xff333333);
            if(textView.getText().toString().equals(items[pos])){
                textView.setTextSize(maxsize);
            }else{
                textView.setTextSize(minsize);
            }
        }
    }
}
