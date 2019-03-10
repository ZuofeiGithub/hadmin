package com.jili.hadmin.json;

import lombok.Data;

/**
 * @Author: 左飞
 * @Date: 2019/3/8 9:57
 * @Version 1.0
 */
@Data
public class BaseResp {
    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(int errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    int errcode;
    String errmsg;
}
