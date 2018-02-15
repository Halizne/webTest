package com.css.crm.service;

import com.css.crm.mapper.CustomerMapper;
import com.css.crm.pojo.Customer;
import com.css.crm.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 46597 on 2018/2/15.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public List<Customer> queryAllCustomer() {
        return customerMapper.queryAllCustomer();
    }

    @Override
    public Page<Customer> queryCustomerPage(Page<Customer> customerPage) {


        int count = customerMapper.queryCount();
        customerPage.setTotal(count);

        List<Customer> rows = customerMapper.queryCustomerByPage((customerPage.getPage() - 1) * customerPage.getSize(), customerPage.getSize());
        customerPage.setRows(rows);
        return customerPage;
    }
}
