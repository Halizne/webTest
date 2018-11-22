package com.css.crm.controller.Converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 46597 on 2018/10/28.
 */
public class DateConverter implements Converter<String, Date> {


        @Override
        public Date convert(String text) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateFormat.setLenient(false);
            try {
                return dateFormat.parse(text);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }


}
