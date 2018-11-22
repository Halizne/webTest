package com.css.crm.controller;

import com.css.crm.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 46597 on 2018/10/28.
 */
@Controller
@RequestMapping(value="test")
public class TestAnnotationValidController {

    @RequestMapping
    public ModelAndView index() {
        ModelAndView view = new ModelAndView("/index", "user", new User());
        return view;
    }

    @RequestMapping(value="/add", method= RequestMethod.POST)
    public ModelAndView add(@ModelAttribute @Valid User user, BindingResult result) {
        ModelAndView view = new ModelAndView("/index");
        view.addObject("user", user);

        if(result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for(FieldError err : errors) {
                System.out.println("ObjectName:" + err.getObjectName() + "\tFieldName:" + err.getField()
                        + "\tFieldValue:" + err.getRejectedValue() + "\tMessage:" + err.getDefaultMessage() );
            }
        }

        return view;
    }




}
