package com.jili.hadmin.json;

import java.util.List;

/**
 * @Author: 左飞
 * @Date: 2019/3/9 13:51
 * @Version 1.0
 */
public class TableData {
    private int code;
    private String msg;
    private int count;
    private List<Object> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
