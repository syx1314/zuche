package com.zql.app.lib.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * @author gaobin
 */
public class NumUtil {

	/**
	 * 保留几位小数
	 * @return
	 */
	public static String format(Double x, Integer maximumFractionDigits) {
		String s= null;
		try{
			NumberFormat ddf1= NumberFormat.getNumberInstance() ;
	        if(maximumFractionDigits==null){
	        	ddf1.setMaximumFractionDigits(2);
	        }else{
	        	ddf1.setMaximumFractionDigits(maximumFractionDigits);
	        }
	        s = ddf1.format(x);
		}catch(Exception e){
			e.printStackTrace();
		}
		return s;
	}

	//将.0 去掉变成整数
	public static String formatStr(Double x){
		NumberFormat   nf=new DecimalFormat( "0.00 ");
		x = Double.parseDouble(x!=null?nf.format(x):"0");
		String doubleStr=x.toString();
		String[] doubles=doubleStr.split("\\.");
		if(doubles.length==1){
			return doubleStr.trim();
		}else{
			if(Integer.parseInt(doubles[1])>0){
				return doubleStr.trim();
			}else{
				return doubles[0].trim();
			}
		}
	}

	//将.0 去掉变成整数
	public static double formatDouble(Double x){
		NumberFormat   nf=new DecimalFormat( "0.00 ");
		x = Double.parseDouble(x!=null?nf.format(x):"0");
		String doubleStr=x.toString();
		String[] doubles=doubleStr.split("\\.");
		if(doubles.length==1){
			return Double.valueOf(doubleStr.trim());
		}else{
			if(Integer.parseInt(doubles[1])>0){
				return Double.valueOf(doubleStr.trim());
			}else{
				return Double.valueOf(doubleStr.trim());
			}
		}
	}

	public static void main(String[] args){
//		System.out.println(format(1.51234, 1));
//		System.out.println(format(1.52234, 1));
//		System.out.println(format(1.55234, 1));

		System.out.println(formatStr(1500.4));
		System.out.println(formatStr(1.0));
		System.out.println(formatStr(1.06));
		System.out.println(formatStr(1.51));
	}
}
