package com.css.crm.utils;

import java.util.List;

public class Page<T> {

    private int total; // 数据的总数
    private int page; // 页码
    private int size;   // 每页的数据量
    private List<T> rows; // 真实的数据信息；

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }


}
