package com.zql.app.shop.entity.yiwei;

import java.util.List;

public class YiweiCarRequest {
   //{"isNewEdition":"1","startLatitude":"#####","pageSize":"20","startLongitude":"*****","pageNo":"1"}
   private String isNewEdition="1";
   private String startLatitude="39.05183403862847";
   private String pageSize="20";
   private String startLongitude="117.1266750759549";
   private String pageNo="1";

   public String getIsNewEdition() {
      return isNewEdition;
   }

   public void setIsNewEdition(String isNewEdition) {
      this.isNewEdition = isNewEdition;
   }

   public String getStartLatitude() {
      return startLatitude;
   }

   public void setStartLatitude(String startLatitude) {
      this.startLatitude = startLatitude;
   }

   public String getPageSize() {
      return pageSize;
   }

   public void setPageSize(String pageSize) {
      this.pageSize = pageSize;
   }

   public String getStartLongitude() {
      return startLongitude;
   }

   public void setStartLongitude(String startLongitude) {
      this.startLongitude = startLongitude;
   }

   public String getPageNo() {
      return pageNo;
   }

   public void setPageNo(String pageNo) {
      this.pageNo = pageNo;
   }
}
