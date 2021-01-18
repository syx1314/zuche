package com.zql.app.lib.util.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.zql.app.lib.util.ReflectUtil;

/**
 * 窗体工具
 * @author sszvip
 *
 */
public class ContextUtil {
	private static Context appContext; //全局上下文

	/**
	 * 得到当前窗体的名称
	 * @param ctx
	 * @return
     */
	public static String getRunningActivityName(Context ctx) {
		String contextString = ctx.toString();
		return contextString.substring(contextString.lastIndexOf(".") + 1,contextString.indexOf("@"));
	}

	/**
	 * 得到全局上下文
	 * @return
     */
	public static Context getAppContext() {
		if (appContext == null) {
			Class c = ReflectUtil.getClassFromName("android.app.ActivityThread");
			Object staMet = ReflectUtil.invokeStaticMethodAll(c,"currentApplication",new Class[]{},new Object[]{});
			Object oCont = ReflectUtil.invokeMethodAll(staMet,"getApplicationContext",new Class[]{},new Object[]{});
			appContext = (Context)oCont;
		}
		return appContext;
	}

	/**
	 * 设置全局上下文
	 * @param con
     */
	public static void setAppContext(Context con) {
		appContext = con;
	}

	/**
	 * 跳转
	 * @param con
	 * @param cls
     */
	public static void startActivity(Context con, Class<?> cls){
		con.startActivity(new Intent(con,cls));
	}

	/**
	 * 选择颜色
	 * @param color
	 * @return
	 */
	public static int getColor(int color){
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			return getAppContext().getResources().getColor(color,null);
		}else{
			return getAppContext().getResources().getColor(color);
		}
	}

}
