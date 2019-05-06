package com.xiaoy.user.shiro;

import com.xiaoy.user.entity.users.User;
import com.xiaoy.user.service.userservice.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

import javax.annotation.Resource;

public class UserRealm extends AuthorizingRealm {

    @Resource
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("调试信息：已进入授权逻辑");
        AuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User)subject.getPrincipal();
        userService.getUserByName(user.getUser_name());
        System.out.println(user.getPerms());
        ((SimpleAuthorizationInfo) info).addStringPermission(String.valueOf(user.getPerms()));
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("调试信息：已进入认证逻辑");
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        User user = userService.getUserByName(token.getUsername());
        if (user==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"UserRealm");
    }
}
