package com.css.crm.service;

import com.css.crm.pojo.Customer;
import com.css.crm.pojo.QueryVO;
import com.css.crm.utils.Page;

import java.util.List;

/**
 * Created by 46597 on 2018/2/15.
 */
public interface CustomerService {

    List<Customer> queryAllCustomer();

    Page<Customer> queryCustomerPage(Page<Customer> customerPage, QueryVO queryVO);
}
