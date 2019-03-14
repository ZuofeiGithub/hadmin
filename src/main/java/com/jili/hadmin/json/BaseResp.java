package com.jili.hadmin.json;

/**
 * @Author: 左飞
 * @Date: 2019/3/8 9:57
 * @Version 1.0
 */
public class BaseResp {
    int errcode;
    String errmsg;
    String token;
    public int getErrcode() {
        return errcode;
    }
    public BaseResp setErrcode(int errcode) {
        this.errcode = errcode;
        return this;
    }
    public String getErrmsg() {
        return errmsg;
    }

    public BaseResp setErrmsg(String errmsg) {
        this.errmsg = errmsg;
        return this;
    }


    public String getToken() {
        return token;
    }

    public BaseResp setToken(String token) {
        this.token = token;
        return this;
    }
}
