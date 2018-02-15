package com.css.crm.controller;

import com.css.crm.pojo.BaseDict;
import com.css.crm.pojo.QueryVO;
import com.css.crm.service.BaseDictService;
import com.css.crm.service.CustomerService;
import com.css.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by 46597 on 2018/2/14.
 */
@Controller
@RequestMapping("customer")
public class Customer {

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    /**
     * 显示用户列表
     *
     * @return
     */
    @RequestMapping("list")
    public String queryCustomerList(Model model, Integer page , QueryVO queryVO) {

        //代码写的丑陋点就丑陋点吧； 能实现功能就行

        List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode("009");

        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode("001");

        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode("006");


        model.addAttribute("fromType", fromType);
        model.addAttribute("industryType", industryType);
        model.addAttribute("levelType", levelType);


        Page<com.css.crm.pojo.Customer> customerPage = new Page<>();


        if (page == null || page <= 1) {

            customerPage.setPage(1);

        } else {

            customerPage.setPage(page);
        }
        customerPage.setSize(10);

        customerPage = customerService.queryCustomerPage(customerPage,queryVO);

        model.addAttribute("page", customerPage);

        return "customer";
    }

}
