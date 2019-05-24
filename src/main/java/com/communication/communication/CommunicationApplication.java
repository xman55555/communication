package com.communication.communication;

import com.communication.communication.config.SpringApplicationContextUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * 简单的通讯录程序设计
 * 要求：设计一个实用的小型通讯录程序，
 * 具有添加，修改，查询和删除功能。
 * 根据题目要求自行完成实体类及功能类设计；
 * 通过文件读写操作来加载及保存记录信息；
 * 通讯录实体需包含如下必要属性：姓名、工作单位、电话号码1、电话号码2、电子邮箱、自定义分组；
 * 自定义分组属性的可选值为：家人、同事、朋友、同学、其他；能够根据姓名、工作单位、自定义分组等关键字实现相关记录的检索；
 * 能够统计各定义分组中的记录数及总记录数；系统界面使用控制台菜单或图形用户界面均可。
 */
@SpringBootApplication
@MapperScan("com.communication.communication.dao")
public class CommunicationApplication {


    public static void main(String[] args) {
        ApplicationContext run= SpringApplication.run(CommunicationApplication.class, args);
        SpringApplicationContextUtil.setApplicationContext(run);
    }

}
