package com.css.crm.mapper;

import com.css.crm.pojo.BaseDict;

import java.util.List;

/**
 * Created by 46597 on 2018/2/14.
 */
public interface BaseDictMapper {

    /**
     * 根据类别代码查询数据
     * @param dictTypeCode
     * @return
     */
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);


}
