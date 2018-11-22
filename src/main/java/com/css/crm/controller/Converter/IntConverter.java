package com.css.crm.controller.Converter;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by 46597 on 2018/10/28.
 */
public class IntConverter  implements Converter<String, Integer> {


    @Override
    public Integer convert(String text) {
        if (text == null || "".equals(text)) {
            return 0;
        } else {
            try {
                Integer value = Integer.parseInt(text);
                return value;
            } catch (Exception e) {
                return 0;
            }
        }
    }

}
