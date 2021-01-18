package com.zql.app.lib.util;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.inputmethodservice.ExtractEditText;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.AppCompatRadioButton;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;


import com.google.gson.Gson;
import com.zql.app.lib.entity.BaseDTO;
import com.zql.app.lib.entity.widget.Option;
import com.zql.app.lib.util.ui.DialogUtil;
import com.zql.app.lib.view.widget.MyCheckBox;
import com.zql.app.lib.view.widget.MyRadioButton;
import com.zql.app.lib.view.widget.MyRadioGroup;
import com.zql.app.lib.view.widget.SingleSpinner;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * 数据工具类
 *
 * @author 曾繁添
 * @version 1.0
 * @link http://www.cnblogs.com/fly100/
 * @email mengzhongyouni@gmail.com
 */
public class DataUtil {

  public static final String TAG = "DataUtil";

  /**
   * 判断单个输入框是否为空
   *
   * @param mContext
   * @param input
   * @param mFieldName
   * @return
   */
  public static boolean hasEmpty(Context mContext, EditText input, String mFieldName) {
    if (null == mContext || null == input || TextUtils.isEmpty(mFieldName)) return false;

    if (TextUtils.isEmpty(input.getText().toString())) {
        DialogUtil.showToastCust(mContext, mFieldName + "不能为空");
        input.requestFocus();
        input.setFocusable(true);
        return true;
    }
    return false;
  }

  /**
   * 一起判断表单必须录入的项目，返回对应的提示信息
   *
   * @param mContext
   * @param input
   * @param mFieldName
   * @return
   */
  public static boolean hasEmpty(Context mContext, EditText[] input, String[] mFieldName) {
    if (null == mContext || null == input || null == mFieldName) return false;
    String strResultMsg = "";
    for (int i = 0; i < input.length; i++) {
      String text = input[i].getText().toString();
      if (TextUtils.isEmpty(text)) {
        strResultMsg += mFieldName[i] + "不能为空\n";
      }
    }

    if (!TextUtils.isEmpty(strResultMsg)) {
        DialogUtil.showToastCust(mContext, strResultMsg);
        input[0].requestFocus();
        input[0].setFocusable(true);
        return true;
    }

    return false;
  }


  /**
   * 设置表单只读
   *
   * @param formRoot
   */
  public static void readonlyForm(ViewGroup formRoot) {
    if (null == formRoot || formRoot.getChildCount() == 0) return;

    for (int i = 0; i < formRoot.getChildCount(); i++) {
      View view = formRoot.getChildAt(i);
      // 容器级别控件需要进行递归
      if (view instanceof ViewGroup) {
        readonlyForm((ViewGroup) view);
      }
      // 非容器级别控件不用递归
      view.setEnabled(false);
    }
  }

  /**
   * 回填表单数据，根据控件的tag与BaseDTO的key匹配回填Text
   *
   * @param formRoot 表单容器
   * @param formData 表单数据
   */
  public static void fillBackForm(ViewGroup formRoot, BaseDTO<String, Object> formData) {
    if (null == formRoot || null == formData || formData.isEmpty()) return;

    if (formRoot.getChildCount() > 0) {
      for (int i = 0; i < formRoot.getChildCount(); i++) {
        View view = formRoot.getChildAt(i);
        // 容器级别控件需要进行递归
        if (view instanceof LinearLayout) {
          fillBackForm((LinearLayout) view, formData);
        } else if (view instanceof RelativeLayout) {
          fillBackForm((RelativeLayout) view, formData);
        } else if (view instanceof FrameLayout) {
          fillBackForm((FrameLayout) view, formData);
        } else if (view instanceof AbsoluteLayout) {
          fillBackForm((AbsoluteLayout) view, formData);
        } else if (view instanceof RadioGroup) {
          fillBackForm((RadioGroup) view, formData);
        } else if (view instanceof MyRadioGroup) {
          fillBackForm((MyRadioGroup) view, formData);
        } else if (view instanceof TableLayout) {
          fillBackForm((TableLayout) view, formData);
        }

        // 非容器级别控件不用递归
        /**
         * EditText.class
         */
        else if (view.getTag() != null && view instanceof EditText) {
          ((EditText) view).setText(String.valueOf(formData.get(view.getTag())));
        }

        /**
         * TextView.class
         */
        else if (view.getTag() != null && view instanceof TextView) {
          ((TextView) view).setText(String.valueOf(formData.get(view.getTag())));
        }

        /**
         * RadioButton.class
         */
        else if (view.getClass().getName().equals(AppCompatRadioButton.class.getName())) {
          if (((AppCompatRadioButton) view).getText().toString()
              .equals(formData.get(view.getTag()))) {
            ((AppCompatRadioButton) view).setChecked(true);
          } else {
            ((AppCompatRadioButton) view).setChecked(false);
          }
        } else if (view.getClass().getName().equals(MyRadioButton.class.getName())) {
          MyRadioButton mView = (MyRadioButton) view;
          if (mView.getText().toString().equals(formData.get(mView.getKey()))) {
            mView.setChecked(true);
          } else {
            mView.setChecked(false);
          }
        }

        /**
         * CheckBox.class(需要拼装选中复选框)
         */
        else if (view.getClass().getName().equals(AppCompatCheckBox.class.getName())) {
          AppCompatCheckBox mView = (AppCompatCheckBox) view;
          String strFormValue = String.valueOf(formData.get(view.getTag()));
          if (strFormValue.indexOf(mView.getText().toString()) != -1) {
            mView.setChecked(true);
          } else {
            mView.setChecked(false);
          }
        } else if (view.getClass().getName().equals(MyCheckBox.class.getName())) {
          MyCheckBox mView = (MyCheckBox) view;
          String strFormValue = String.valueOf(formData.get(mView.getKey()));
          if (strFormValue.indexOf(mView.getText().toString()) != -1) {
            mView.setChecked(true);
          } else {
            mView.setChecked(false);
          }
        }

        /**
         * Spinner.class
         */
        else if (view.getClass().getName().equals(android.widget.Spinner.class.getName())) {
          android.widget.Spinner mView = (android.widget.Spinner) view;
          int mItemCount = mView.getAdapter().getCount();
          for (int j = 0; j < mItemCount; j++) {
            Object item = mView.getAdapter().getItem(j);
            if (item.equals(formData.get(view.getTag()))) {
              mView.setSelection(j);
            }
          }
        } else if (view.getClass().getName()
            .equals(SingleSpinner.class.getName())) {
          SingleSpinner mView = (SingleSpinner) view;
          int mItemCount = mView.getAdapter().getCount();
          for (int j = 0; j < mItemCount; j++) {
            Option item = (Option) mView.getAdapter().getItem(j);
            if (item.getValue().equals(formData.get(mView.getKey()))) {
              mView.setSelection(j);
            }
          }

        }
      }
    }
  }

  /**
   * 获取表单控件数据
   *
   * @param root 当前表单容器
   * @param formData 当前表单数据
   * @return 表单数据（CheckBox多选选项以##拼接）
   */
  public static BaseDTO<String, Object> gainForm(ViewGroup root, BaseDTO<String, Object> formData) {
    if (root.getChildCount() > 0) {
      for (int i = 0; i < root.getChildCount(); i++) {
        View view = root.getChildAt(i);
        // 容器级别控件需要进行递归
        if (view instanceof LinearLayout) {
          gainForm((LinearLayout) view, formData);
        } else if (view instanceof RelativeLayout) {
          gainForm((RelativeLayout) view, formData);
        } else if (view instanceof FrameLayout) {
          gainForm((FrameLayout) view, formData);
        } else if (view instanceof AbsoluteLayout) {
          gainForm((AbsoluteLayout) view, formData);
        } else if (view instanceof RadioGroup) {
          gainForm((android.widget.RadioGroup) view, formData);
        } else if (view instanceof MyRadioGroup) {
          gainForm((MyRadioGroup) view, formData);
        } else if (view instanceof TableLayout) {
          gainForm((TableLayout) view, formData);
        }

        // 非容器级别控件不用递归
        /**
         * EditText.class
         */
        else if (view.getTag() != null && view instanceof EditText) {
          formData.put((String) view.getTag(), ((EditText) view).getText().toString());
        } else if (view.getTag() != null && view instanceof AutoCompleteTextView) {
          formData.put((String) view.getTag(), ((AutoCompleteTextView) view).getText().toString());
        } else if (view.getTag() != null && view instanceof MultiAutoCompleteTextView) {
          formData.put((String) view.getTag(), ((MultiAutoCompleteTextView) view).getText()
              .toString());
        } else if (view.getTag() != null && view instanceof ExtractEditText) {
          formData.put((String) view.getTag(), ((ExtractEditText) view).getText().toString());
        }

        /**
         * RadioButton.class
         */
        else if (view.getClass().getName().equals(RadioButton.class.getName())) {
          if (((RadioButton) view).isChecked()) {
            formData.put((String) view.getTag(), ((RadioButton) view).getText()
                .toString());
          }
        } else if (view.getClass().getName()
            .equals(MyRadioButton.class.getName())) {
          MyRadioButton mView = (MyRadioButton) view;
          if (mView.isChecked()) {
            formData.put(mView.getKey(), mView.getValue());
          }
        }
        else if (view.getClass().getName().equals(AppCompatRadioButton.class.getName())) {
          if (((AppCompatRadioButton) view).isChecked()) {
            formData.put((String) view.getTag(), ((AppCompatRadioButton) view).getText()
                    .toString());
          }
        }

        /**
         * CheckBox.class(需要拼装选中复选框)
         */
        else if (view.getClass().getName().equals(android.widget.CheckBox.class.getName())) {
          if (((android.widget.CheckBox) view).isChecked()) {
            if (formData.containsKey(view.getTag())) {
              Object value = formData.get(view.getTag());
              value = value + "##" + ((android.widget.CheckBox) view).getText().toString();
              formData.put((String) view.getTag(), value);
            } else {
              formData.put((String) view.getTag(), ((android.widget.CheckBox) view).getText()
                  .toString());
            }
          }

        }

        else if (view.getClass().getName().equals(AppCompatCheckBox.class.getName())) {
          if (((AppCompatCheckBox) view).isChecked()) {
            if (formData.containsKey(view.getTag())) {
              Object value = formData.get(view.getTag());
              value = value + "##" + ((AppCompatCheckBox) view).getText().toString();
              formData.put((String) view.getTag(), value);
            } else {
              formData.put((String) view.getTag(), ((AppCompatCheckBox) view).getText()
                      .toString());
            }
          }

        }

        else if (view.getClass().getName().equals(MyCheckBox.class.getName())) {

          MyCheckBox mView = (MyCheckBox) view;
          if (mView.isChecked()) {
            if (formData.containsKey(mView.getKey())) {
              Object value = formData.get(mView.getKey());
              value = value + "##" + mView.getValue();
              formData.put(mView.getKey(), value);
            } else {
              formData.put(mView.getKey(), mView.getValue());
            }
          }
        }

        /**
         * Spinner.class
         */
        else if (view.getClass().getName().equals(android.widget.Spinner.class.getName())) {
          formData.put((String) view.getTag(), ((android.widget.Spinner) view).getSelectedItem()
              .toString());
        } else if (view.getClass().getName()
            .equals(SingleSpinner.class.getName())) {
          SingleSpinner mView = (SingleSpinner) view;
          formData.put(mView.getKey(), mView.getSelectedValue());
        }
      }
    }

    return formData;
  }

  /**
   * 读取Assets目录的json文件,并转成指定的Bean
   *
   * @param mContext 上下文
   * @param jsonFileName 不带扩展名的文件名
   * @param clazz 需要转成对应的Bean
   * @return
   */
  public static <T> void gainAssetsData(final Context mContext, final String jsonFileName,
                                        final T clazz, final IDataCallBackHandler handler) {
    final Handler mCallHandler = new Handler() {
      @Override
      public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (null == handler) return;

        if (msg.what == 1) {
          handler.onSuccess(msg.obj);
        } else {
          handler.onFailure((String) msg.obj);
        }
      }
    };
    // 开启子线程初始化
    new Thread(new Runnable() {

      @Override
      public void run() {
        Looper.prepare();
        final Message mgs = mCallHandler.obtainMessage();
        try {
          String strJsonData = FileUtil.readAssetsValue(mContext, jsonFileName);
          // 判断是否含有resultData
          JSONObject json = new JSONObject(strJsonData);
          String data =
              json.has("resultData") ? json.getJSONObject("resultData").toString() : strJsonData;

          // JSON转成Bean
          T result = null;
          result = new Gson().fromJson(data, (Type) clazz);
          mgs.what = 1;
          mgs.obj = result;
        } catch (Exception e) {
          Log.e(TAG, "JSONObject转Bean失败,原因：" + e.getMessage());
          mgs.what = -1;
          mgs.obj = e.getMessage();
        }
        // 将获取的消息利用Handler发送到主线程
        mCallHandler.sendMessage(mgs);
        Looper.loop();
      }
    }).start();
  }

  /**
   * 读取Assets目录的json文件
   *
   * @param mContext 上下文
   * @param jsonFileName 不带扩展名的文件名称
   * @return
   */
  public static JSONObject gainAssetsData(Context mContext, String jsonFileName) {
    String strJsonData = FileUtil.readAssetsValue(mContext, jsonFileName);
    JSONObject result = null;
    try {
      result = new JSONObject(strJsonData);
    } catch (JSONException e) {
      Log.e(TAG, "构建JSONObject失败，原因：" + e.getMessage());
      result = new JSONObject();
    }
    return result;
  }

  /**
   * 将Bean反射成Map
   *
   * @param dto 装载成员属性容器
   * @param bean 请求参数实例
   */
  public static void fillDTO(Map<String, Object> dto, Object bean) {
    if (null == dto || null == bean) return;
    // 反射获取属性
    // Field[] mFields =
    // requestParam.getClass().getDeclaredFields();//当前类的public属性
    Field[] mFields = bean.getClass().getFields();// 所有可见public的属性、包括父类、接口
    for (Field field : mFields) {
      field.setAccessible(true);
      try {
        dto.put(field.getName(), field.get(bean));
      } catch (Exception e) {
        Log.e(TAG, "反射" + bean.getClass().getName() + "成员属性失败，原因：" + e.getMessage());
      }
    }
  }

  /**
   * 将Map反射至Bean
   *
   * @param dto 装载成员属性容器
   * @return  bean 请求参数实例
   */
  public static <T> Object fillBean(Map<String, Object> dto, T clazz) {
    // 数据合法性校验
    if (null == dto || dto.isEmpty()) return null;
    // 将Map转成json格式字符串
    String strGson = new Gson().toJson(dto);
    // 将json格式字符串转Bean
    Object bean = new Gson().fromJson(strGson, (Type) clazz);

    return bean;
    // //遍历Map
    // Iterator<Map.Entry<String, Object>> it = dto.entrySet().iterator();
    // while (it.hasNext()) {
    // Map.Entry<String, Object> entry = (Map.Entry<String, Object>) it.next();
    // try {
    // String mWriteMethod = "set"+ToolString.capitalFirst(entry.getKey());
    // Method m = bean.getClass().getDeclaredMethod(mWriteMethod, entry.getValue().getClass());
    // m.setAccessible(true);
    // m.invoke(bean, entry.getValue());
    // } catch (Exception e) {
    // ToolLog.e(TAG, "装填属性-->"+entry.getKey()+"失败，原因："+e.getMessage());
    // }
    // }
  }

  /**
   * 将对象转成json字符串
   *
   * @param data
   * @return
   */
  public static String beanToJson(Object data) {
    if (null == data) return "";
    return new Gson().toJson(data);
  }

  /**
   * 将JSON转成Bean
   *
   * @param strJsonData
   * @param clazz
   * @param handler
   */
  public static <T> void jsonToBean(final String strJsonData, final T clazz,
                                    final IDataCallBackHandler handler) {

    final Handler mCallHandler = new Handler() {
      @Override
      public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (null == handler) return;

        if (msg.what == 1) {
          handler.onSuccess(msg.obj);
        } else {
          handler.onFailure((String) msg.obj);
        }
      }
    };
    // 开启子线程初始化
    new Thread(new Runnable() {

      @Override
      public void run() {
        Looper.prepare();
        final Message mgs = mCallHandler.obtainMessage();
        try {
          // JSON转成Bean
          T result = null;
          result = new Gson().fromJson(strJsonData, (Type) clazz);
          mgs.what = 1;
          mgs.obj = result;
        } catch (Exception e) {
          Log.e(TAG, "JSONObject转Bean失败,原因：" + e.getMessage());
          mgs.what = -1;
          mgs.obj = e.getMessage();
        }
        // 将获取的消息利用Handler发送到主线程
        mCallHandler.sendMessage(mgs);
        Looper.loop();
      }
    }).start();
  }

  /**
   * 读取AndroidManifest.xml配置的meta-data数据
   *
   * @param mContext 上下文
   * @param target Activity/BroadcastReceiver/Service/Application
   * @param key 配置的name
   * @return
   */
  public static String gainMetaData(Context mContext, Class target, String key) {
    String result = "";
    try {
      Log.d(TAG, target.getSuperclass().getName());

      int flags = PackageManager.GET_META_DATA;
      Object obj = target.newInstance();
      if (obj instanceof Activity) {
        ActivityInfo info2 =
            mContext.getPackageManager().getActivityInfo(((Activity) mContext).getComponentName(),
                flags);
        result = info2.metaData.getString(key);
      } else if (obj instanceof Application) {
        ApplicationInfo info1 =
            mContext.getPackageManager().getApplicationInfo(mContext.getPackageName(), flags);
        result = info1.metaData.getString(key);
      } else if (obj instanceof Service) {
        ComponentName cn1 = new ComponentName(mContext, target);
        ServiceInfo info3 = mContext.getPackageManager().getServiceInfo(cn1, flags);
        result = info3.metaData.getString(key);
      } else if (obj instanceof BroadcastReceiver) {
        ComponentName cn2 = new ComponentName(mContext, target);
        ActivityInfo info4 = mContext.getPackageManager().getReceiverInfo(cn2, flags);
        result = info4.metaData.getString(key);
      }
    } catch (Exception e) {
      Log.e(TAG, "读取meta元数据失败，原因：" + e.getMessage());
    }
    return result;
  }

  public interface IDataCallBackHandler<T> {

    void onSuccess(T result);

    void onFailure(String errorMsg);
  }
}
