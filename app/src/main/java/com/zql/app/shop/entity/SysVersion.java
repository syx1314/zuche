package com.zql.app.shop.entity;

/**
 * Created by Administrator on 2019/8/15 0015.
 */

public class SysVersion {


    /**
     * gmtCreate : 1528453098000
     * gmtModified : 1528453098000
     * id : 2
     * processType : 2
     * userCreate : 1
     * userModified : 1
     * version : 3.0.0
     * versionType : 2
     */

    private long gmtCreate;
    private long gmtModified;
    private Integer id;
    /**1强制2提示**/
    private Integer processType;
    private Integer userCreate;
    private Integer userModified;
    private String version;
    private Integer versionType;

    public long getGmtCreate() {
        return gmtCreate;
    }

    public long getGmtModified() {
        return gmtModified;
    }

    public Integer getId() {
        return id;
    }

    public Integer getProcessType() {
        return processType;
    }

    public Integer getUserCreate() {
        return userCreate;
    }

    public Integer getUserModified() {
        return userModified;
    }

    public String getVersion() {
        return version;
    }

    public Integer getVersionType() {
        return versionType;
    }
}
