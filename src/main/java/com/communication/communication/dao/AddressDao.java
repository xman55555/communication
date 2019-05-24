package com.communication.communication.dao;

import com.communication.communication.entity.Address;

import java.util.List;

public interface AddressDao {
    int deleteByPrimaryKey(String id);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);

    List<Address> getAll();

    List<Address> findData(Address record);
}