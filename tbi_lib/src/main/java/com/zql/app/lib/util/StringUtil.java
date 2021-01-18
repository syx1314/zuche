package com.zql.app.lib.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 * Created by huangzhe on 2016/11/25.
 */

public class StringUtil {

    public static String getTimeStr(Integer time){
        Integer hh = time / 60 /60;
        Integer mm = (time - (hh * 60 * 60))/60;
        String timeStr = "";
        if (hh == 0) {
            timeStr = "00:";
        } else if (hh <= 9) {
            timeStr = "0" + hh + ":";
        } else {
            timeStr = hh + ":";
        }
        if (mm == 0) {
            timeStr += "00";
        } else if (mm <= 9) {
            timeStr += "0" + mm;
        } else {
            timeStr += mm;
        }
        return timeStr;
    }

    public static String getSecStr(Integer time){
        Integer mm = time / 60;
        Integer ss = time - (mm * 60);
        String timeStr = "";
        if (mm == 0) {
            timeStr = "00:";
        } else if (mm <= 9) {
            timeStr = "0" + mm + ":";
        } else {
            timeStr = mm + ":";
        }
        if (ss == 0) {
            timeStr += "00";
        } else if (ss <= 9) {
            timeStr += "0" + ss;
        } else {
            timeStr += ss;
        }
        return timeStr;
    }

    /**
     * 判断是否为中文
     * @param c
     * @return
     */
    public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        return ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    /**
     * 判断字符串是否包括英文
     * @param str
     * @return
     */
    public static boolean isChinese(String str){
        for(int i=0;i<str.length();i++){
            if(!isChinese(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    /**
     * 得到字符串中的中文字符
     * @param str
     * @return
     */
    public static int getChineseCharacterCount(String str) {
        int ccCount = 0;
        for(int i=0;i<str.length();i++){
            if(isChinese(str.charAt(i))){
                ccCount ++;
            }
        }

        return ccCount;
    }

    /**
     * 得到处理后的字符串
     * @param str
     * @return
     */
    public static String getString(String str){
        if(Validator.isNotEmpty(str)) {
            String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(str);
            return m.replaceAll("").trim();
        }
        return str;
    }

    /**
     * 多个字符串使用 逗号 累加
     * @param oldStr
     * @param addStr
     * @return
     */
    public static String addDivision(String oldStr,String addStr) {
        if (Validator.isNotEmpty(oldStr) && Validator.isNotEmpty(addStr)) {
            return oldStr + "," + addStr;
        }else if(Validator.isNotEmpty(addStr)){
            return addStr;
        }else if(Validator.isNotEmpty(oldStr)){
            return oldStr;
        }else{
            return "";
        }
    }

    /**
     * list转换成String
     * @param list
     * @return
     */
    public static String listToString(List<String> list) {
        StringBuilder result = new StringBuilder();
        if (list != null && !list.isEmpty()) {
            for (String str: list) {
                result.append(str);
            }
            return result.toString();
        } else {
            return "";
        }
    }

    /**
     * 转换小数点
     * @param price
     * @return
     */
    public static String floatToStr(Float price){
        if(price!=null){
            return price.intValue()+"";
        }
        return "0";
    }
}
