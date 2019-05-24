package com.communication.communication.service.imple;

import com.communication.communication.dao.UserDao;
import com.communication.communication.entity.User;
import com.communication.communication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User getUserById(int userId) {
        return userDao.selectByPrimaryKey(userId);
    }
    @Override
    public boolean addUser(User record){
        boolean result = false;
        try {
            userDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    @Override
    public List<User> getAllList(){
        List<User> users=new ArrayList<User>();
        try {
            users=userDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

}