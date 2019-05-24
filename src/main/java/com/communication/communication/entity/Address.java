package com.communication.communication.entity;

import java.io.Serializable;

/**
 * 通讯录实体需包含如下必要属性：姓名、工作单位、电话号码1、电话号码2、电子邮箱、自定义分组；
 */
public class Address implements Serializable {

    private String id;
    /**
     * 姓名、
     */
    private  String  name;

    /**
     * 工作单位、
     */
    private  String unit;
    /**
     * 电话号码1
     */
    private String telephone ;
    /**
     * 电话号码2
     */
    private String telephone2;
    /**
    电子邮箱
     */
    private String email;
    /**
     * 自定义分组
     */
    private String grouptype;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone2() {
        return telephone2;
    }

    public void setTelephone2(String telephone2) {
        this.telephone2 = telephone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
