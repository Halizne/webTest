package com.css.crm.test;

import com.css.crm.mapper.KbsalesTaskDOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 46597 on 2018/11/2.
 */
public class SpringTest {

    @Test
    public void test(){

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-*.xml");
        //从spring容器中获取bean对象
        KbsalesTaskDOMapper kbsalesTaskDOMapper =(KbsalesTaskDOMapper)applicationContext.getBean("KbsalesTaskDOMapper");
        //测试业务功能
        System.out.println(kbsalesTaskDOMapper);






    }



}
