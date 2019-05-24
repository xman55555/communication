package com.communication.communication.service;
import com.communication.communication.entity.Address;

import java.util.List;

public interface AddressService {
    /**
     *
     * @param AddressId
     * @return
     */
    public Address getAddressById(String AddressId);

    boolean addAddress(Address record);

    public List<Address> getAllList();

    public List<Address> findData(Address record);

    public int delAddress(Address record);

    public int updateAddress(Address record);

}