package com.css.crm.pojo;

import java.io.Serializable;

/**
 * Created by 46597 on 2018/2/15.
 */
public class QueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String  custSource;

    private String custIndustry;

    private String custLevel;

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public String getCustIndustry() {
        return custIndustry;
    }

    public void setCustIndustry(String custIndustry) {
        this.custIndustry = custIndustry;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }
}
