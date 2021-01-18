/**  
 * Project Name:Android_Car_Example  
 * File Name:RegeocodeTask.java  
 * Package Name:com.amap.api.car.example  
 * Date:2015年4月2日下午6:24:53  
 *  
 */

package com.zql.app.shop.util;

import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.geocoder.GeocodeResult;
import com.amap.api.services.geocoder.GeocodeSearch;
import com.amap.api.services.geocoder.GeocodeSearch.OnGeocodeSearchListener;
import com.amap.api.services.geocoder.RegeocodeQuery;
import com.amap.api.services.geocoder.RegeocodeResult;
import com.zql.app.lib.core.CommonCallback;
import com.zql.app.lib.util.Validator;
import com.zql.app.lib.util.map.PositionEntity;
import com.zql.app.shop.TbiApplication;


/**
 * ClassName:RegeocodeTask <br/>
 * Function: 简单的封装的逆地理编码功能 <br/>
 * Date: 2015年4月2日 下午6:24:53 <br/>
 * 
 * @author yiyi.qi
 * @version
 * @since JDK 1.6
 * @see
 */
public class RegeocodeTask implements OnGeocodeSearchListener {
	private static final float SEARCH_RADIUS = 50;
	private CommonCallback<PositionEntity> mOnLocationGetListener;

	private GeocodeSearch mGeocodeSearch;

	public RegeocodeTask() {
		mGeocodeSearch = new GeocodeSearch(TbiApplication.getInstance());
		mGeocodeSearch.setOnGeocodeSearchListener(this);
	}

	public void search(double latitude, double longitude) {
		RegeocodeQuery regecodeQuery = new RegeocodeQuery(new LatLonPoint(
				latitude, longitude), SEARCH_RADIUS, GeocodeSearch.AMAP);
		mGeocodeSearch.getFromLocationAsyn(regecodeQuery);
	}

	public void setOnLocationGetListener(
			CommonCallback<PositionEntity> onLocationGetListener) {
		mOnLocationGetListener = onLocationGetListener;
	}

	@Override
	public void onGeocodeSearched(GeocodeResult arg0, int arg1) {

	}

	@Override
	public void onRegeocodeSearched(RegeocodeResult regeocodeReult,
			int resultCode) {
			if (regeocodeReult != null
					&& regeocodeReult.getRegeocodeAddress() != null
					&& mOnLocationGetListener != null) {
				String address ="";
				if(Validator.isNotEmpty(regeocodeReult.getRegeocodeAddress().getProvince())){
					address =regeocodeReult.getRegeocodeAddress().getFormatAddress().replace(regeocodeReult.getRegeocodeAddress().getProvince(),"");
				}else{
					address = regeocodeReult.getRegeocodeAddress().getFormatAddress();
				}

				String city = regeocodeReult.getRegeocodeAddress().getCity();
		 
				PositionEntity entity = new PositionEntity();
				entity.address = address;
				entity.city = city;
				mOnLocationGetListener.onCallBack(entity);

			}else {
				mOnLocationGetListener.onCallBack(new PositionEntity());
			}
	}


}
