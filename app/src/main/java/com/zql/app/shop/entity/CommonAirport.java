package com.zql.app.shop.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/4/24.
 */

public class CommonAirport implements Serializable {
    private String aptName;
    private String firstWord;
    private String aptSpell;
    private String aptShortSpell;
    private String aptCode;
    private boolean firstBean;
    private boolean LastBean;

    public CommonAirport() {
    }

    public CommonAirport(String aptName, String firstWord, String aptSpell, String aptCode, boolean firstBean) {
        this.aptName = aptName;
        this.firstWord = firstWord;
        this.aptSpell = aptSpell;
        this.aptCode = aptCode;
        this.firstBean = firstBean;
    }

    public String getAptName() {
        return aptName;
    }

    public void setAptName(String aptName) {
        this.aptName = aptName;
    }

    public String getAptCode() {
        return aptCode;
    }

    public void setAptCode(String aptCode) {
        this.aptCode = aptCode;
    }

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord;
    }

    public boolean isFirstBean() {
        return firstBean;
    }

    public void setFirstBean(boolean firstBean) {
        this.firstBean = firstBean;
    }

    public String getAptSpell() {
        return aptSpell;
    }

    public void setAptSpell(String aptSpell) {
        this.aptSpell = aptSpell;
    }

    public String getAptShortSpell() {
        return aptShortSpell;
    }

    public void setAptShortSpell(String aptShortSpell) {
        this.aptShortSpell = aptShortSpell;
    }

    public boolean isLastBean() {
        return LastBean;
    }

    public void setLastBean(boolean lastBean) {
        LastBean = lastBean;
    }

    @Override
    public String toString() {
        return "CommonAirport{" +
                "aptName='" + aptName + '\'' +
                ", firstWord='" + firstWord + '\'' +
                ", aptSpell='" + aptSpell + '\'' +
                ", aptShortSpell='" + aptShortSpell + '\'' +
                ", aptCode='" + aptCode + '\'' +
                ", firstBean=" + firstBean +
                '}';
    }
}
