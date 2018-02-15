package com.css.crm.service;

import com.css.crm.mapper.CustomerMapper;
import com.css.crm.pojo.Customer;
import com.css.crm.pojo.QueryVO;
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
    public Page<Customer> queryCustomerPage(Page<Customer> customerPage, QueryVO queryVO) {


        int count = customerMapper.queryCount(queryVO);
        customerPage.setTotal(count);

        queryVO.setStart((customerPage.getPage() - 1) * customerPage.getSize());
        queryVO.setEnd(customerPage.getSize());

        List<Customer> rows = customerMapper.queryCustomerByPage(queryVO);
        customerPage.setRows(rows);
        return customerPage;
    }

    @Override
    public Customer queryCustomerById(String id) {
        Customer customer = customerMapper.queryCustomerById(Integer.valueOf(id));
        return customer;
    }

    @Override
    public Boolean deleteCustomerById(String id) {

        int i = customerMapper.deleteCustomerById(Integer.valueOf(id));
        return i > 0;
    }
}
