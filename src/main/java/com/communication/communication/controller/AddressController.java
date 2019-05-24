package com.communication.communication.controller;

import com.alibaba.fastjson.JSONArray;
import com.communication.communication.Utils.Utils;
import com.communication.communication.entity.Address;
import com.communication.communication.entity.User;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class AddressController  {

    @Resource
    private GroupService groupService;
    @Resource
    private AddressService addressService;
    private final static Logger logger = LoggerFactory.getLogger(AddressController.class);

    private void getGroupS(Model model){
        model.addAttribute("groupList",groupService.getAllList());
    }

    @RequestMapping("/")
    public String index1( Model model){
        List<Address> addressesList=new ArrayList<Address>();
        addressesList=addressService.getAllList();
        model.addAttribute("addressesList",addressesList);
        return "address/index";
    }
    @RequestMapping("/index")
    public String index( Model model){
        List<Address> addressesList=new ArrayList<Address>();
        addressesList=addressService.getAllList();
        model.addAttribute("addressesList",addressesList);
        return "address/index";
    }
    @RequestMapping("/toAddressAdd")
    public String toAddressAdd( Model model,Address record){
        getGroupS(model);
        return "address/addressAdd";
    }
    @RequestMapping("/toEditAddress")
    public String toEditAddress( Model model,Address record){
        if(!StringUtils.isEmpty(record.getId())){
            Address address=addressService.getAddressById(record.getId());
            model.addAttribute("address",address);
        }
        getGroupS(model);
        return "address/editAddress";
    }

    @RequestMapping("/addAddress")
    @ResponseBody
    public Map<String ,String>  addAddress( Model model,Address record){
        Map<String,String > resultmap=new HashMap<String, String>() ;
        resultmap.put("result","fail");
        if(record!=null&&
                !StringUtils.isEmpty(record.getName())){
            record.setId(Utils.generateTimeStringId());
            addressService.addAddress(record);
            resultmap.put("result","success");
        }
        return resultmap;
    }
    @RequestMapping("/editAddress")
    @ResponseBody
    public Map<String ,String>  editAddress( Model model,Address record){
        Map<String,String > resultmap=new HashMap<String, String>() ;
        resultmap.put("result","fail");
        if(record!=null&&
                !StringUtils.isEmpty(record.getName())){

            int i =addressService.updateAddress(record);
            if(i>0){
                resultmap.put("result","success");
            }
        }
        return resultmap;
    }

    @RequestMapping("/delAddress")
    @ResponseBody
    public Map<String ,String> delAddress(Model model, Address record){
        Map<String,String > resultmap=new HashMap<String, String>() ;
        resultmap.put("result","fail");
        int i=0;
        if(record!=null&&
                !StringUtils.isEmpty(record.getId())){
             i=addressService.delAddress(record);
        }
        if(i>0){
            resultmap.put("result","success");

        }
        return resultmap;
    }
    @RequestMapping("/getAddressData")
    @ResponseBody
    public Map<String ,String> getAddressData(Model model, Address record){
        Map<String,String > resultmap=new HashMap<String, String>() ;
        resultmap.put("result","fail");
        List<Address> addressesList=new ArrayList<Address>();
        addressesList=addressService.findData(record);
        if(addressesList!=null&&addressesList.size()>0){
            resultmap.put("result","success");
            resultmap.put("addressesList", JSONArray.toJSONString(addressesList));
        }
        return resultmap;
    }

}