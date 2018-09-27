package com.hector.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.ByteSource;

public class JdbcRealm extends AuthenticatingRealm {
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        String username = token.getUsername();
        String password =  String.valueOf(token.getPassword());

        if (username.equals("hector") && password.equals("123456")){
            ByteSource bytes = ByteSource.Util.bytes(password);
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, this.getName());
            return  info;
        }
        else{
            throw new UnknownAccountException("用户名不存在");
        }

    }
}
