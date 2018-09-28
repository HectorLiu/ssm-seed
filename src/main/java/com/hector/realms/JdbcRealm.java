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
        String password = "7fa914dc322d180eb14d348cec76814b";

        if (username.equals("hector")) {
            ByteSource salt = ByteSource.Util.bytes(username);
//            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, this.getName());
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password, salt, this.getName());
            return info;
        } else {
            throw new UnknownAccountException("用户名不存在");
        }

    }
}
