package com.zql.app.shop.entity;

/**
 * 火车城市 新的 为了和老的斜街 没改老的
 * Created by yyj on 2018/4/16.
 * "hotStation": "1",
 * "id": 2,
 * "stationCity": "北京",
 * "stationCode": "BJP",
 * "stationName": "北京",
 * "stationPy": "beijing"
 */

public class TrainNewCity {
    private String hotStation;
    private int id;
    private String stationCity;
    private String stationCode;
    private String stationName;
    private String stationPy;

    public String getHotStation() {
        return hotStation;
    }

    public void setHotStation(String hotStation) {
        this.hotStation = hotStation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationCity() {
        return stationCity;
    }

    public void setStationCity(String stationCity) {
        this.stationCity = stationCity;
    }

    public String getStationCode() {
        return stationCode;
    }

    public void setStationCode(String stationCode) {
        this.stationCode = stationCode;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationPy() {
        return stationPy;
    }

    public void setStationPy(String stationPy) {
        this.stationPy = stationPy;
    }
}
