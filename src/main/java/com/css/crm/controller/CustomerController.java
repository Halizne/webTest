package com.css.crm.controller;

import com.css.crm.pojo.BaseDict;
import com.css.crm.pojo.Customer;
import com.css.crm.pojo.QueryVO;
import com.css.crm.service.BaseDictService;
import com.css.crm.service.CustomerService;
import com.css.crm.utils.Page;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by 46597 on 2018/2/14.
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

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

        System.out.println(queryVO.getCustName());

        if(StringUtils.isNotBlank(queryVO.getCustName())) {
            try {
                queryVO.setCustName(new String(queryVO.getCustName().getBytes("ISO8859-1"), "utf-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("转码异常");
            }
        }
       // System.out.println(queryVO.getCustName());


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

    @RequestMapping("edit")
    @ResponseBody
    public Customer  queryCustomerById( String id){

        Customer customer = customerService.queryCustomerById(id);
        return customer;

    }

    @RequestMapping("delete")
    @ResponseBody
    public boolean deleteCustomerById( String id){

      Boolean flag =  customerService.deleteCustomerById(id);
      return flag ;

    }

}
