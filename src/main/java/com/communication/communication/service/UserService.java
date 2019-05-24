package com.communication.communication.service;
import com.communication.communication.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     *
     * @param userId
     * @return
     */
    public User getUserById(int userId);

    boolean addUser(User record);

    public List<User> getAllList();

}