package com.communication.communication.dao;

import com.communication.communication.entity.Groups;

import java.util.List;

public interface GroupsDao {
    int deleteByPrimaryKey(String id);

    int insert(Groups record);

    int insertSelective(Groups record);

    Groups selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Groups record);

    int updateByPrimaryKey(Groups record);

    List<Groups> getAll();

    List<Groups> findData(Groups record);
}