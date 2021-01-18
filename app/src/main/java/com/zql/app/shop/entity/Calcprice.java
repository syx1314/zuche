package com.zql.app.shop.entity;

import com.zql.app.lib.entity.BaseBean;
import com.zql.app.lib.util.ListUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页
 * Created by huangzhe on 2017/6/13.
 */

public class Calcprice extends BaseBean {

    private Object iconUrl;
    private List<Pics> pics_0;//个人轮播图
    private List<Pics> pics_1;//个人热门图
    private List<Pics> pics_2;//企业轮播图
    private List<TravelHotBean> travelHot;//热门路线
    private List<TravelHotBean> airticketsHot;//特价机票

    /**
     * 轮播图转换
     *
     * @param pics
     * @return
     */
    public List<String> convertPicsList(List<Pics> pics) {
        List<String> list = new ArrayList<>();
        if (ListUtil.isNotEmpty(pics)) {
            for (Pics pic : pics) {
                list.add(pic.getAdvPic());
            }
        }
        return list;
    }

    public Object getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(Object iconUrl) {
        this.iconUrl = iconUrl;
    }

    public List<Pics> getPics_0() {
        return pics_0;
    }

    public void setPics_0(List<Pics> pics_0) {
        this.pics_0 = pics_0;
    }

    public List<Pics> getPics_1() {
        return pics_1;
    }

    public void setPics_1(List<Pics> pics_1) {
        this.pics_1 = pics_1;
    }

    public List<Pics> getPics_2() {
        return pics_2;
    }

    public void setPics_2(List<Pics> pics_2) {
        this.pics_2 = pics_2;
    }

    public List<TravelHotBean> getTravelHot() {
        return travelHot;
    }

    public void setTravelHot(List<TravelHotBean> travelHot) {
        this.travelHot = travelHot;
    }

    public List<TravelHotBean> getAirticketsHot() {
        return airticketsHot;
    }

    public void setAirticketsHot(List<TravelHotBean> airticketsHot) {
        this.airticketsHot = airticketsHot;
    }

    public static class TravelHotBean {

        private String productId;
        private String productName;//产品名称
        private Integer productType;//产品类型
        private Integer price;//价格
        private Integer salePrice;
        private String startCity;
        private String arriveCity;
        private String showContract;
        private String confirm;
        private String imgUrl;
        private Integer region;//国际还是国内
        private Integer hot;//热度
        private String productDescription;//描述
        private String label;//标签

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }

        public Integer getProductType() {
            return productType;
        }

        public void setProductType(Integer productType) {
            this.productType = productType;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public Integer getSalePrice() {
            return salePrice;
        }

        public void setSalePrice(Integer salePrice) {
            this.salePrice = salePrice;
        }

        public String getStartCity() {
            return startCity;
        }

        public void setStartCity(String startCity) {
            this.startCity = startCity;
        }

        public String getArriveCity() {
            return arriveCity;
        }

        public void setArriveCity(String arriveCity) {
            this.arriveCity = arriveCity;
        }

        public String getShowContract() {
            return showContract;
        }

        public void setShowContract(String showContract) {
            this.showContract = showContract;
        }

        public String getConfirm() {
            return confirm;
        }

        public void setConfirm(String confirm) {
            this.confirm = confirm;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public Integer getRegion() {
            return region;
        }

        public void setRegion(Integer region) {
            this.region = region;
        }

        public Integer getHot() {
            return hot;
        }

        public void setHot(Integer hot) {
            this.hot = hot;
        }

        public String getProductDescription() {
            return productDescription;
        }

        public void setProductDescription(String productDescription) {
            this.productDescription = productDescription;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }
    }

    /**
     * 轮播图
     */
    public static class Pics {
        private String advUrl;//链接
        private int advId;
        private String advPic;//图片地址 ,
        private String remark4;
        private String advType;//广告类型（存汉字，也根据汉字检索分类）
        private String advTitle;//标题
        private int sort;//排序
        private int state;//状态：0-停用；1-启用
        private String remark1;//备用字段
        private String remark3;//备用字段
        private String advContent;//内容
        private String remark2;//备用字段

        public String getAdvUrl() {
            return advUrl;
        }

        public void setAdvUrl(String advUrl) {
            this.advUrl = advUrl;
        }

        public int getAdvId() {
            return advId;
        }

        public void setAdvId(int advId) {
            this.advId = advId;
        }

        public String getAdvPic() {
            return advPic;
        }

        public void setAdvPic(String advPic) {
            this.advPic = advPic;
        }

        public String getRemark4() {
            return remark4;
        }

        public void setRemark4(String remark4) {
            this.remark4 = remark4;
        }

        public String getAdvType() {
            return advType;
        }

        public void setAdvType(String advType) {
            this.advType = advType;
        }

        public String getAdvTitle() {
            return advTitle;
        }

        public void setAdvTitle(String advTitle) {
            this.advTitle = advTitle;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getRemark1() {
            return remark1;
        }

        public void setRemark1(String remark1) {
            this.remark1 = remark1;
        }

        public String getRemark3() {
            return remark3;
        }

        public void setRemark3(String remark3) {
            this.remark3 = remark3;
        }

        public String getAdvContent() {
            return advContent;
        }

        public void setAdvContent(String advContent) {
            this.advContent = advContent;
        }

        public String getRemark2() {
            return remark2;
        }

        public void setRemark2(String remark2) {
            this.remark2 = remark2;
        }
    }
}
