package com.communication.communication.service.imple;

import com.communication.communication.dao.AddressDao;
import com.communication.communication.entity.Address;
import com.communication.communication.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("AddressService")
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressDao AddressDao;

    @Override
    public Address getAddressById(String AddressId) {
        return AddressDao.selectByPrimaryKey(AddressId);
    }
    @Override
    public boolean addAddress(Address record){
        boolean result = false;
        try {
            AddressDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    @Override
    public List<Address> getAllList(){
        List<Address> Addresss=new ArrayList<Address>();
        try {
            Addresss=AddressDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Addresss;
    }
    @Override
    public List<Address> findData(Address record){
       return AddressDao.findData(record);

    }
    @Override
    public int delAddress(Address record){
     return    AddressDao.deleteByPrimaryKey(record.getId());
    }
    @Override
    public int updateAddress(Address record){
        return AddressDao.updateByPrimaryKey(record);
    }
}
