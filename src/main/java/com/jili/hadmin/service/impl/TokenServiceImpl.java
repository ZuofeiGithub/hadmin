package com.jili.hadmin.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.jili.hadmin.entity.SysUser;
import com.jili.hadmin.service.TokenService;
import org.springframework.stereotype.Service;

@Service("TokenService")
public class TokenServiceImpl implements TokenService {
    @Override
    public String getToken(SysUser user) {
        return JWT.create().withAudience(user.getUsername())// 将 user id 保存到 token 里面
                .sign(Algorithm.HMAC256(user.getPassword()));// 以 password 作为 token 的密钥
    }
}
