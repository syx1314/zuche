package com.zql.app.shop;

import com.zql.app.lib.core.IBaseConst;

/**
 * Created by shikeyue on 17/4/10.
 */

public interface IConst extends IBaseConst {

    /**
     * 基础常量
     */
    interface BASE {
        String DB_NAME = "newobtAndCus.db";  //数据库名称
        int DB_VER_NUM = 1;         //数据库版本号
        int PAGE_ROWS = 15;//分页一次加载数据
        int DEFAULT_ZOOM = 12;//地图默认缩放级别
        int DEFAULT_MAXPRICE = 2000;//默认最大的价格
        int C_DEFAULT_MAXPRICE = 3000;//默认最大的价格
        int NO_LIMIT_PRICE = 20000;//价格不限
        String URL_BASE = BuildConfig.FIX_URL_BASE;//测试的本地服务器地址
        String URL_BASE_EXT = BuildConfig.URL_BASE_EXT;//测试/版
        String FIX_URL_BASE = BuildConfig.FIX_URL_BASE;//加载h/tml 页面的地址

        //城市接口代码
        String CITYS_HOTEL_LIST = "hotel_city";//酒店城市
        String CITYS_FLIGHT_LIST = "flight_city";//机票城市
        String CITYS_TRAVEL_IN_LIST = "travel_domestic_cits";//旅游国内城市 目的地
        String CITYS_TRAVEL_OUT_LIST = "travel_abroad_cits";//旅游国外城市 目的地
        String CITYS_OTHER = "other";//机场
        String CITYS_TRAVEL_ORIGIN_IN = "travel_origin_cits";//旅游国内 出发地
        String CITYS_TRAVEL_ORIGIN_OUT = "travel_abroad_origin_cits";//旅游国外 出发地

        //主页Fragment的Tag名称
        String MAIN_TAG_HOME = "mainTagHome";//首页
        String MAIN_TAG_MY = "mainTagMy";//我的
        String MAIN_TAG_ORDER = "mainTagOrder";//企业订单列表
        String MAIN_TAG_TRIP = "mainTagTrip";//行程

        String MAIN_TAG_C_MAIN = "mainTagCMain";//企业
        String MAIN_TAG_P_MAIN = "mainTagPMain";//个人
        //CommonMemberFaq中json文件名
        String COMMON_MEMBER_FAQ = "faqs.json";
        String COMMON_MEMBER_PAY = "pays.json";
        String COMMON_MEMBER_BETA = "beta.json";
        //COldCommonOrderDetailsActivity
        String ORDER_ITEM_FLIGHT = "orderItemFlight";//机票类
        String ORDER_ITEM_HOTEL = "orderItemHotel";//酒店类
        String ORDER_ITEM_SURANCE = "orderItemSurance";//保险类
        String ORDER_ITEM_APPROVAL = "orderItemApproval";//审批流程记录
        String ORDER_ITEM_TRAIN = "orderItemTrain";//火车票
        String ORDER_ITEM_CAR = "orderItemCar";//专车


        //当前是否处于Debug模式  企业机票
        boolean isDebugComAirplane = false;
        //region 旅游类型
        String REGION_IN = "RegionIn";//国内
        String REGION_OUT = "RegionOut";//国际
        //endregion

        String WXPAY_APPID = "wx8294a942631b1cbf"; //微信商户的唯一标识码
        String WXPAY_ACTIVITY_TAG = "MicroMsg.SDKSample.WXPayEntryActivity"; //用于日志输出，微信支付类的标识

        String DATE_SINGLE = "1";
        //2018-3-6
//        String DOWN_FILE_PATH = "http://www.btravelplus.com/slj/TBIShop.apk"; //TODO zql DownLoad Path (eg. http://www.btravelplus.com/testCustomer.apk)
        String DOWN_FILE_PATH = "http://app.tbiplus.com/TBIShop2.0.apk"; //TODO 2019年4月10日 10:14:24 部长说换成这个
        /* 应用名称 */
        String DOWN_APK_NAME = "TBIShop2.0.apk";

        //TODO:个人版酒店使用
        String gnAir = "0";//国内air
        String gJAir = "1";//国际air
        String DTAir = "A";//定投air
        String TJAir = "F";//特价air
        String PTAir = "P";//特价air
        String goTrip = "0";//去程
        String backTrip = "1";//回程
        //TODO:个人版旅游
        String ZB = "0"; //周边
        String ZYX = "2";// 自由行
        //TODO:酒店 国内 国际
        String HOTEL_GN = "1";
        String HOTEL_GJ = "2";
        String HOTEL_DT = "DT";

        //个人版首页权限
        String PERMISSION = "p_permission";

        //国际机票控制时间刷新 20分钟
        int INTER_AIR_REFRESH_TIME=1200000;
//        int INTER_AIR_REFRESH_TIME=1000*60*5;
        //国内机票控制时间刷新 20分钟
        int HOME_AIR_REFRESH_TIME=1000*60*1;
//        int HOME_AIR_REFRESH_TIME=1200000;


    }

    /**
     * 本地数据保存
     */
    interface PreManager extends IBaseConst.PreManager {
        String USER_PHONE = "userphone";     //用户注册用的手机号
        String USER_VERIFY_CODE = "verifyCode";  //用户注册时获取的验证码
        String LOCATION_CITY = "locationCity";//保存定位城市
        String SELECT_HIS_CITY = "selectHisCity";//保存选中的城市

        String WIN_MAIN_PAGE = "winMainPage";//切换页面
        String WIN_MAIN_RELOAD = "winMainReLoad";//标识主页的订单列表需要刷新

        String MAIN_USER_TYPE = "mainUserType";//首页当前选择的是企业还是个人
        String USER_INFO = "userInfo";//用户信息
        String HOME_INFO = "homeInfo";//首页信息
        String ContactPeople = "ContactPeople";//途途帮用的联系人

        String WELCOME = "welcome";//启动页只启动一次
        String NEWHOTELHISTORYCITY="NEWHOTELHISTORYCITY0911";

        String AIR_HISTORY="air_history";
        String B_CONTACT_PEOPLE="B_ContactPeople";
        String HOME_AIR_TIME="HOME_AIR_TIME";//保存内际机票的全程时间 比如20分钟
        String INTER_AIR_TIME="INTER_AIR_TIME";//保存国际机票的全程时间 比如20分钟
        String INTER_AIR_CALANDER_DAY="INTER_AIR_CALANDER_DAY";//国际机票日期控制的天数
        String HOME_AIR_CALANDER_DAY="HOME_AIR_CALANDER_DAY";//国内机票日期控制的天数

        String INTER_AIR_ONE_REQUEST="INTER_AIR_ONE_REQUEST";//国际机票第一次请求数据
        String HOME_AIR_ONE_REQUEST="HOME_AIR_ONE_REQUEST";//国内机票请求数据
        String REBOOK_HOME_AIR_ONE_REQUEST="REBOOK_HOME_AIR_ONE_REQUEST";//国内机票改签请求数据
        String INTER_AIT_CITY="INTER_AIT_CITY";//国际城市

        String REFRESHBUSSINESSORDER="REFRESHBUSSINESSORDER";//出差单刷新
        String REFRESHEXPENSEORDER="REFRESHEXPENSEORDER";//出差单刷新

    }

    /**
     * 系统开关
     */
    interface OnOff {
        String BASE = "ONOFF_";
    }

    /**
     * 用于窗口间传值
     */
    interface Bundle {
        String WIN_RESULT = "winResult";//标识窗体类型
        int WIN_CP_COMMON_SELECT_CITY = 2003;//选择城市返回值
        int WIN_CP_COMMON_SELECT_CITY_AREA = 0x2003;//选择城市返回值
        int UPATE_CUSTOMER = 0x2004;//更细乘车人
        String HOTLE_QUERY_TO_HOTEL_LIST = "hotelQueryToHotelList";   //酒店跳转酒店列表
        String HOTEL_RESERVE_INFO = "hotelReserveInfo";             //酒店预订担保信息
        int WIN_SELECT_DATE = 2001;                   //选择日期
        String SHOW_START_DATE = "showStartDate";       //日历显示的开始时间
        String SELECTDATE_START_DATE = "selectdateStartDate";       //酒店入住开始时间
        String SELECTDATE_END_DATE = "selectdateEndDate";           //酒店入住离店时间
        String SELECTDATE_TOTAL_NIGHT = "selectdateTotalNight";     //酒店入住几晚
        String IS_END_DATE_INPUT = "isEndDateInput";                //是否在结束时间输入框触发时间控件
        String IS_SINGLE_DATE_WIDGET = "isSingleDateWidget";        //仅有一个控件，调用日期控件的出发点不是一个日期范围

        String SELECT_CITY_TYPE = "selectCityType";//选择城市对应的类型[酒店、机票]
        String SELECT_CITY = "selectCity";//选择城市
        String SELECT_CITYAREA = "selectCityArea";//选择城市
        String SELECT_CITYAREA_NAME = "selectCityAreaName";//选择区域名字
        String SELECT_CITYAREAID = "selectCityAreaID";//选择城市
        String SELECT_KEYWORD = "selectKeyWord";//选择关键字

        String AIRPLANE_SELECT_AIRPORT = "selectAirport";  //机票的机场选择
        String AIR_BUSSINESS_TYPE = "AIR_BUSSINESS_TYPE";//飞机的业务类型 单程 多程 等
        String AIR_QUERY_BEAN = "AIR_QUERY_BEAN";//飞机查询页包装
        int WIN_C_HOTEL_SELECT_COMPANY_ACTIVITY = 2004;//选择分公司
        String C_HOTEL_SELECT_COMPANY_CITY = "cHotelSelectCompanyCity";//通过城市的中文查询
        String C_HOTEL_SELECT_COMPANY = "cHotelSelectCompany";//选择分公司
        //首页选中标签
        String MAIN_PAGE_HOME = "mainPageHome";//首页
        String MAIN_PAGE_TRIP = "mainPageTrip";//行程
        String MAIN_PAGE_ORDER = "mainPageOrder";//订单
        String IS_REFRESH = "IS_REFRESH";//刷新
        String MAIN_PAGE_MY = "mainPageMy";//我的
        //常见问题传参
        String COMMON_MEMBER_FAQ = "commonMemberFaq";
        String P_LOGIN_IS_FINISH = "pLoginIsFinish";//登录是否跳转到首页

        String SPECIAL_HOTEL_OBJECT = "specialHotleObject";   //特殊要求对象

        String C_MAIN_FRAGEMNT_TYPE = "cMainFragmentType";//秘书型跳转传值
        String C_MAIN_FRAGEMNT_TYPE_WIN_OTHER = "winOther";//弹出

        int C_CHOICE_EMPLOYEE_WIN_OPEN = 2002;//弹出回调类型
        String SELECTED_EMPLOYEE_LIST_BEAN = "selectedEmployeeListBean";//返回选中的员工

        String CHOICE_EMPLOYEE_BEAN = "choiceEmployeeBean";//选择人员统一传参

        String C_CHOICE_EMPLOYEE = "cChoiceEmployee";//选择旅客

        String COMMON_HOTEL_DETAILS_MORE = "commonHotelDetailsMore";//查看酒店地址

        String C_HOTEL_ORDER_ID = "cHotelOrderId";//酒店订单号
        String C_ORDER_ID = "C_ORDER_ID";//订单号
        String C_HOTEL_CURRENT_APV_LEVEL = "cHotelCurrentApvLevel";   //当前审批级别
        String C_HOTEL_CURRENT_APV_UID = "cHotelCurrentApvUid";       //当前审批人UID

        String WIN_C_ORDER_BUSINESS_CHANGE_ACTIVITY = "winCOrderBusinessChangeActivity";//修改出差单

        String MAIN_ORDER_ORDER_STATE = "mainOrderOrderState";//订单列表状态


        String COMMON_MEMBER_BETA = "commonMemberBeta";//跳转Beta页面
        String TYPE_MARK = "typeMark";                  //标明日期控件的文字显示是关于哪种类型的

        String P_ORDER_HOTEL_DETAILS_TO_P_ORDER_HOTEL_PRICE_DETAIL = "pOrderHotelDetailsToPOrderHotelPriceDetail";//个人酒店详情跳转价格明细

        String P_HOTEL_REIMBURSEMENT = "pHotelReimbursement"; //报销凭证

        String IS_CHOICE_TICKET_FOR_OTHER = "isChoiceTicketForOther";//机票选择用户给后面的页面

        String ORDER_NO = "orderNo";//出差单号
        String ORDER_ID = "orderId";//订单号
        String APPROVE_NO = "approveNo";//出差单号



        String APV_RULE_ID = "apvRuleId";//审批规则ID
        String TRAVEL_POLICY_ID = "travelPolicyId";//差旅政策ID
        String ENABLE_ORDER = "enable_order";//违反差旅政策是否可以预定 传递的参数



        String COMMON_PICK_DATE_FRAGEMNT_PARA = "commonPickDateFragemntPara";//通用日期选择
        String COMMON_PICK_DATE_FRAGEMNT_TITLE = "commonPickDateFragemntTitle";//标题


        String P_TRAVEL_RESERVE_SUBMIT = "pTravelReserveSubmit";//提交订单实体

        String P_TRAVEL_SELECT_PERSION = "pTravelSelectPersion";//选中的人

        String C_NOTICE_CUR = "cNoticeCur";//当前公告
        String C_NOTICE_LIST = "cNoticeList";//全部公告

        String TRAVEL_REGION_TYPE = "travelRegionType";//类型
        String TRAVEL_TYPE = "travelType";//旅游类型

        String TRAVEL_LIST_PARAM = "travelListParam";//跳转旅游列表参数
        String TRAVEL_SEND_CITYS_LIST = "travelSendCitysList";//出发城市列表

        String WIN_APPROVAL_SUCCESS_TYPE = "winAppovalSuccessType";//审批完成页面


        String WIN_ADVERT_URL = "winAdvertUrl";//跳转广告页面
        //region 火车票
        String TRAIN_BEAN = "trainBean";//火车票传递实体
        String TRAIN_QUERY_TYPE = "trainQueryType";//火车查询类型

        int START_TIME_SELECT = 1001;//出发城市选择框
        int END_TIME_SELECT = 1002;//到达城市选择框

        int SELECT_DATE = 1003;//选择日期

        String TRAIN_PASSAGE = "trainPassage";//选择乘客信息

        int SELECT_PASSAGE = 1005;//选择人员
        int SELECT_PERSION = 1006;//选择联系人

        String TRAIN_TRIP_STATUS = "trainTripStatus";//回调占座状态

        String URL = "URL";
        String TITLE = "TiTLE";
        String ID = "id";
        String STOCK_ID = "stock_id";//库存id
        String PRICE = "price";
        //endregion
        String noPay = "noPay";//订单没有支付
        String createOrderFail = "createOrderFail";//创建订单失败
        String payFail = "payFail";//支付失败
        String paySuccess = "paySuccess";//支付成功
        String nendConfirm = "nendConfirm";//需要二次确认的订单
        String reOrderSuccess = "reOrderSuccess";//改期成功
        String reOrderFail = "reOrderFail";//改期失败
        String xianPay = "xianPay";//现付

    }

    /**
     * 支付宝返回状态码
     */
    interface PayCallBackCode {
        String ALIPAY_SUCCESS = "9000"; //订单支付成功
        String ALIPAY_PROCESS_UNKNOWN = "8000"; //支付结果确认中
        String ALIPAY_FAILURE = "4000"; //订单支付失败
        String ALIPAY_REPEAT_REQUEST = "5000"; //重复请求
        String ALIPAY_CANCLE = "6001"; //用户中途取消
        String ALIPAY_CONNECT_FAIL = "6002"; //网络连接错误
        String ALIPAY_UNKNOWN = "6004"; //支付结果未知
    }


}
