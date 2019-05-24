package com.communication.communication.controller;

import com.alibaba.fastjson.JSONArray;
import com.communication.communication.Utils.Utils;
import com.communication.communication.entity.Address;
import com.communication.communication.entity.Groups;
import com.communication.communication.service.AddressService;
import com.communication.communication.service.GroupService;
import com.communication.communication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/group")
public class GroupController {

    @Resource
    private GroupService groupService;
    private final static Logger logger = LoggerFactory.getLogger(GroupController.class);

    @RequestMapping("/toGroups")
    public String index(Model model , HttpServletRequest request){
        List<Groups> groupsArrayList=new ArrayList<Groups>();
        groupsArrayList=groupService.getAllList();
        model.addAttribute("groupsArrayList",groupsArrayList);
        return "group/groupIndex";
    }
    @RequestMapping("/toAddGroups")
    public String toAddGroups(Model model , HttpServletRequest request){
        model.addAttribute("type","add");
        return "group/editGroups";
    }
    @RequestMapping("/toEditGroup")
    public String toEditGroup(Model model , HttpServletRequest request,Groups record){
        model.addAttribute("type","edit");
        if(!StringUtils.isEmpty(record.getGrouptype())){
            Groups Groups=groupService.getGroupsById(record.getGrouptype());
            model.addAttribute("groups",Groups);
        }
        return "group/editGroups";
    }
    @RequestMapping("/addGroup")
    @ResponseBody
    public Map<String ,String>  addGroup( Model model,Groups record){
        Map<String,String > resultmap=new HashMap<String, String>() ;
        resultmap.put("result","fail");
        if(record!=null&&
                !StringUtils.isEmpty(record.getGroupName())){
            record.setGrouptype(Utils.generateTimeStringId());
            groupService.addGroups(record);
            resultmap.put("result","success");
        }
        return resultmap;
    }
    @RequestMapping("/editGroup")
    @ResponseBody
    public Map<String ,String> editGroup(Model model, Groups record){
        Map<String,String > resultmap=new HashMap<String, String>() ;
        resultmap.put("result","fail");
        if(record!=null&&
                !StringUtils.isEmpty(record.getGrouptype())){
            int isAdd=groupService.updateGroups(record);
            if(isAdd>0){
                resultmap.put("result","success");
            }
        }
        return resultmap;
    }
    @RequestMapping("/delGroup")
    @ResponseBody
    public Map<String ,String> delGroup(Model model, Groups record){
        Map<String,String > resultmap=new HashMap<String, String>() ;
        resultmap.put("result","fail");
        int i=0;
        if(record!=null&&
                !StringUtils.isEmpty(record.getGrouptype())){
            i=groupService.delGroups(record);
        }
        if(i>0){
            resultmap.put("result","success");

        }
        return resultmap;
    }
    @RequestMapping("/getGroupData")
    @ResponseBody
    public Map<String ,String> getGroupData(Model model, Groups record){
        Map<String,String > resultmap=new HashMap<String, String>() ;
        resultmap.put("result","fail");
        List<Groups> GroupesList=new ArrayList<Groups>();
        GroupesList=groupService.findData(record);
        if(GroupesList!=null&&GroupesList.size()>0){
            resultmap.put("result","success");
            resultmap.put("GroupesList", JSONArray.toJSONString(GroupesList));
        }
        return resultmap;
    }


}