package com.css.crm.mapper;



import com.css.crm.pojo.Customer;
import com.css.crm.pojo.QueryVO;

import java.util.List;

/**
 * Created by 46597 on 2018/2/15.
 */
public interface CustomerMapper {
    /**
     *
     * 查询所有的客户列表 ，按创建时间排序
     *
     * @return
     */
    public List<Customer> queryAllCustomer();

    /**
     * 查询总数
     *
     * @return
     * @param queryVO
     */
    public int queryCount(QueryVO queryVO);


    /**
     *  分页查询数据
     *
     * @param start
     * @param end
     * @param queryVO
     * @return
     */
    public List<Customer> queryCustomerByPage(int start, int end, QueryVO queryVO);



}
