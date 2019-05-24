package com.communication.communication.service.imple;

import com.communication.communication.dao.GroupsDao;
import com.communication.communication.entity.Groups;
import com.communication.communication.service.GroupService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("GroupsService")
public class GroupServiceImpl implements GroupService {

    @Resource
    private GroupsDao GroupsDao;

    @Override
    public Groups getGroupsById(String GroupsId) {
        return GroupsDao.selectByPrimaryKey(GroupsId);
    }
    @Override
    public boolean addGroups(Groups record){
        boolean result = false;
        try {
            GroupsDao.insertSelective(record);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    @Override
    public List<Groups> getAllList(){
        List<Groups> Groups=new ArrayList<Groups>();
        try {
            Groups=GroupsDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Groups;
    }
    @Override
    public List<Groups> findData(Groups record){
       return GroupsDao.findData(record);

    }
    @Override
    public int delGroups(Groups record){
     return    GroupsDao.deleteByPrimaryKey(record.getGrouptype());
    }
    @Override
    public int updateGroups(Groups record){
        return GroupsDao.updateByPrimaryKey(record);
    }
}
