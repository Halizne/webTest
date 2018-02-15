package com.css.crm.controller;

import com.css.crm.pojo.BaseDict;
import com.css.crm.service.BaseDictService;
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

    /**
     * 显示用户列表
     *
     * @return
     */
    @RequestMapping("list")
    public String queryCustomerList(Model model) {


        List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode("009");

        List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode("001");

        List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode("006");


        model.addAttribute("fromType", fromType);

        model.addAttribute("industryType", industryType);

        model.addAttribute("levelType",levelType);



        //除了这个显示应该还有带分页的数据展示；






        return "customer";
    }

}
