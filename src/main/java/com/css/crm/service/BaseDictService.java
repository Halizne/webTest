package com.css.crm.service;

import com.css.crm.pojo.BaseDict;

import java.util.List;

/**
 * Created by 46597 on 2018/2/14.
 */
public interface BaseDictService {

    /**
     * 根据类别代码查询
     *
     * @param dictTypeCode
     * @return
     */


    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);


}
