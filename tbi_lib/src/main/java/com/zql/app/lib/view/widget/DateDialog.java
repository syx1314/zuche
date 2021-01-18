package com.zql.app.lib.view.widget;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.util.DateUtil;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.sys.LogMe;
import com.zql.app.lib.view.component.wheel.OnWheelChangedListener;
import com.zql.app.lib.view.component.wheel.WheelView;
import com.zql.app.lib.view.component.wheel.adapters.ArrayWheelAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tjgl.com.android.lib.R;

/**
 * 时间控件
 * Created by huangzhe on 2017/2/8.
 */
public class DateDialog implements OnWheelChangedListener {
    private static final  int DEFAULT_HOUR=8;//默认显示小时位置
    private static final int DEFAULT_MM=0;//默认显示分钟位置
    private int interval=10;//时间间隔

    private Activity ctx;
    private Date startTime;//开始时间
    private Calendar startCalendar;//开始时间
    private Date endTime;//结束时间


    private WheelView alert_date_dialog_wv_date;//日期控件
    private WheelView alert_date_dialog_wv_hour;//小时控件
    private WheelView alert_date_dialog_wv_mm;//分钟控件

    private int selected_date=0;//选中的日期
    private int selected_hour=0;//选中的小时
    private int selected_mm=DEFAULT_MM;//选中的分钟

    private List<String> dates=new ArrayList<>();//日期列表
    private Map<Integer,String> hourMap=new HashMap<>();//保存当前小时
    private Map<Integer,String> mmMap=new HashMap<>();//保存当前分钟

    private SimpleDateFormat sdf=new SimpleDateFormat("yyyy年MM月dd日");

    private boolean isAddHour;//过小时
    /**
     * 构造函数
     * @param startTime 开始时间
     * @param endTime 结束时间
     */
    public DateDialog(Activity ctx, Date startTime, Date endTime){
        this.ctx=ctx;
        this.startTime=startTime;
        startCalendar=Calendar.getInstance();
        startCalendar.setTime(startTime);
        //判断分钟是否大于间隔
        int mm=startCalendar.get(Calendar.MINUTE);
        if(mm>=((60/interval)-1)*interval){
            int hours=startCalendar.get(Calendar.HOUR_OF_DAY);
            if(hours>=23){
                //跨天
                startCalendar.add(Calendar.MINUTE,interval);

            }else {
                startCalendar.set(Calendar.HOUR_OF_DAY, startCalendar.get(Calendar.HOUR_OF_DAY)+1);
                startCalendar.set(Calendar.MINUTE, 0);
                isAddHour=true;
            }
            startTime = startCalendar.getTime();
        }
        this.endTime=endTime;
    }

    /**
     * 构造函数
     * @param ctx
     * @param startTime
     * @param endTime
     * @param interval
     */
    public DateDialog(Activity ctx, Date startTime, Date endTime, int interval){
        super();
        this.interval=interval;
    }

    /**
     * 得到日期列表
     * @return
     */
    private String[] getDate(){
        dates.clear();
        List<String> tmp=new ArrayList<>();
        Calendar endCalendar=Calendar.getInstance();
        endCalendar.setTime(endTime);
        while(!(startCalendar.get(Calendar.YEAR)==endCalendar.get(Calendar.YEAR)&&startCalendar.get(Calendar.MONTH)==endCalendar.get(Calendar.MONTH)&&startCalendar.get(Calendar.DATE)==endCalendar.get(Calendar.DATE))){
            dates.add(sdf.format(startCalendar.getTime()));
            tmp.add(DateUtil.date2Str(startCalendar,"MM月dd日"));
            startCalendar.add(Calendar.DATE,1);
        }
        return tmp.toArray(new String[]{});
    }

    /**
     * 得到小时
     * @return
     */
    private String[] getHours(){
        hourMap.clear();
        List<String> hours=new ArrayList<>();
        int startIndex=0;
        if(selected_date==0){
            startIndex=startCalendar.get(Calendar.HOUR_OF_DAY);
            if(startIndex>0) {
                alert_date_dialog_wv_hour.setCurrentItem(0);
            }
        }
        int curIndex=0;//当前次数
        for(int index=startIndex;index<24;index++){
            String str="";
            if(index<10){
                str="0"+index+"点";
            }else {
                str=index + "点";
            }
            hours.add(str);
            hourMap.put(curIndex++,str);
        }
        return hours.toArray(new String[]{});
    }

    /**
     * 得到分钟
     * @return
     */
    private String[] getMMs(){
        mmMap.clear();
        List<String> mms=new ArrayList<>();
        int startIndex=0;
        if(selected_date==0&&selected_hour==0&&!isAddHour){
            startIndex=startCalendar.get(Calendar.MINUTE);
            startIndex=startIndex/10;
            if(startIndex<=0){
                startIndex=10;
            }else {
                startIndex = (startIndex+1) * 10;
            }
        }
        int curIndex=0;
        for(int index=startIndex;index<60;index=index+interval){
            String str="";
            if(index<10){
                str="0"+index+"分";
            }else {
                str=index + "分";
            }
            mms.add(str);
            mmMap.put(curIndex++,str);
        }
        return mms.toArray(new String[]{});
    }

    /**
     * 处理选中显示
     */
    private void selectDate(Date selectIndex){
        if(selectIndex!=null){
            String date=sdf.format(selectIndex);
            Calendar selectCalendar=Calendar.getInstance();
            selectCalendar.setTime(selectIndex);
            for(int index=0;index<dates.size();index++){
                String str=dates.get(index);
                if(str.equals(date)){
                    alert_date_dialog_wv_date.setCurrentItem(index);
                    int hour=selectCalendar.get(Calendar.HOUR_OF_DAY);
                    String hourStr="";
                    if(hour<10){
                        hourStr="0"+hour+"点";
                    }else{
                        hourStr=hour+"点";
                    }
                    for(int key:hourMap.keySet()){
                        if(hourStr.equals(hourMap.get(key))){
                            alert_date_dialog_wv_hour.setCurrentItem(key);
                            int mm=selectCalendar.get(Calendar.MINUTE);
                            String mmStr="";
                            if(mm<10){
                                mmStr="0"+mm+"分";
                            }else{
                                mmStr=mm+"分";
                            }
                            for(int keyMM:mmMap.keySet()){
                                if(mmStr.equals(mmMap.get(keyMM))){
                                    alert_date_dialog_wv_mm.setCurrentItem(keyMM);
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }

    /**
     * 显示时间控件
     * @param title
     * @param selectIndex
     * @param callback
     */
    public void showDateDialog(String title, final Date selectIndex, final CommonCallback<Date> callback) {
        try{
            final AlertDialog mAlertDialog = new AlertDialog.Builder(ctx).create();
            LayoutInflater inflater = LayoutInflater.from(ctx);
            View view = inflater.inflate(R.layout.alert_date_dialog, null);
            view.setTranslationX(mAlertDialog.getWindow().getAttributes().width);
            //标题
            TextView titleView = view.findViewById(R.id.tv_title);
            if(Validator.isNotEmpty(title)){
                titleView.setText(title);
                titleView.setVisibility(View.VISIBLE);
            }else{
                titleView.setVisibility(View.GONE);
            }
            //取消
            TextView btn= view.findViewById(R.id.alert_cancel);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mAlertDialog.cancel();
                }
            });
            //选中
            TextView okBtn= view.findViewById(R.id.alert_ok);
            okBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                       String dateStr= dates.get(selected_date);
                        dateStr=dateStr+" "+hourMap.get(selected_hour)+mmMap.get(selected_mm);
                        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
                        callback.onCallBack(simpleDateFormat.parse(dateStr));
                    } catch (ParseException e) {
                        LogMe.e(e.getMessage(),e);
                    }
                    mAlertDialog.dismiss();
                }
            });

            alert_date_dialog_wv_date= view.findViewById(R.id.alert_date_dialog_wv_date);
            alert_date_dialog_wv_date.setViewAdapter(new ArrayWheelAdapter<String>(ctx,getDate()));
            alert_date_dialog_wv_date.addChangingListener(this);

            alert_date_dialog_wv_hour= view.findViewById(R.id.alert_date_dialog_wv_hour);
            alert_date_dialog_wv_hour.setViewAdapter(new ArrayWheelAdapter<String>(ctx,getHours()));
            alert_date_dialog_wv_hour.addChangingListener(this);

            alert_date_dialog_wv_mm= view.findViewById(R.id.alert_date_dialog_wv_mm);
            alert_date_dialog_wv_mm.setViewAdapter(new ArrayWheelAdapter<String>(ctx,getMMs()));
            alert_date_dialog_wv_mm.addChangingListener(this);

            mAlertDialog.getWindow().getAttributes().gravity= Gravity.BOTTOM;
            mAlertDialog.getWindow().setWindowAnimations(tjgl.com.android.lib.R.style.alertTranStyle);
            mAlertDialog.show();
            mAlertDialog.getWindow().setContentView(view);

            mAlertDialog.getWindow().setLayout(ctx.getResources().getDisplayMetrics().widthPixels,mAlertDialog.getWindow().getAttributes().height);
            selectDate(selectIndex);
        }catch(Exception e){
            LogMe.e(e.getMessage(),e);
        }
    }
    //改变日期
    private void changeDate(int index){
        selected_date=index;
        alert_date_dialog_wv_hour.setViewAdapter(new ArrayWheelAdapter<String>(ctx,getHours()));//加载小时
        if(selected_date==0){
            alert_date_dialog_wv_hour.setCurrentItem(0);
        }else{
            alert_date_dialog_wv_hour.setCurrentItem(DEFAULT_HOUR);
        }
        alert_date_dialog_wv_mm.setViewAdapter(new ArrayWheelAdapter<String>(ctx,getMMs()));
        if(selected_date==0){
            alert_date_dialog_wv_mm.setCurrentItem(0);
        }else{
            alert_date_dialog_wv_mm.setCurrentItem(DEFAULT_MM);
        }
    }
    //改变小时
    private void changeHours(int index){
        selected_hour=index;
        alert_date_dialog_wv_mm.setViewAdapter(new ArrayWheelAdapter<String>(ctx,getMMs()));
        if(selected_date==0&&selected_hour==0){
            alert_date_dialog_wv_mm.setCurrentItem(0);
        }else{
            alert_date_dialog_wv_mm.setCurrentItem(DEFAULT_MM);
        }
    }
    //改变分钟
    private void changeMM(int index){
        selected_mm=index;
    }

    @Override
    public void onChanged(WheelView wheelView, int oldIndex, int newIndex) {
        if(wheelView==alert_date_dialog_wv_date){
            changeDate(newIndex);
        }else if(wheelView==alert_date_dialog_wv_hour){
            changeHours(newIndex);
        }else if(wheelView==alert_date_dialog_wv_mm){
            changeMM(newIndex);
        }
//        TextView tv=(TextView)wheelView.getItemView(newIndex);
//        tv.setTextSize(24);
    }
}
