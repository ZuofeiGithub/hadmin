package com.jili.hadmin.service;

import com.jili.hadmin.entity.SysUser;


/**
 * @author jinbin
 * @date 2018-07-08 21:04
 */
public interface TokenService {
     String getToken(SysUser user);
}
