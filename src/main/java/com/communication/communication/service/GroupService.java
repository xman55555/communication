package com.communication.communication.service;
import com.communication.communication.entity.Groups;

import java.util.List;

public interface GroupService {
    /**
     *
     * @param GroupsId
     * @return
     */
    public Groups getGroupsById(String GroupsId);

    boolean addGroups(Groups record);

    public List<Groups> getAllList();

    public List<Groups> findData(Groups record);

    public int delGroups(Groups record);

    public int updateGroups(Groups record);

}