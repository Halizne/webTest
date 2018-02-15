package com.css.crm.service;

import com.css.crm.mapper.BaseDictMapper;
import com.css.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 46597 on 2018/2/14.
 */
@Service
public class BaseDictServiceImpl implements BaseDictService {


    @Autowired
    private BaseDictMapper baseDictMapper ;

    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {

        List<BaseDict> list = baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
        return list;
    }
}
