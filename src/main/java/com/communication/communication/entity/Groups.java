package com.communication.communication.entity;

public class Groups {

    /**
     * id 用于关联
     */
    private String grouptype;

    /**
     * 组名称: 显示
     */
    private String groupName;

    /**
     * 组描述
     */
    private String groupDescribe ;

    public String getGrouptype() {
        return grouptype;
    }

    public void setGrouptype(String grouptype) {
        this.grouptype = grouptype;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescribe() {
        return groupDescribe;
    }

    public void setGroupDescribe(String groupDescribe) {
        this.groupDescribe = groupDescribe;
    }
}