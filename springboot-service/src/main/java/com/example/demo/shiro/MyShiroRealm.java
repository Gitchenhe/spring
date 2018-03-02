package com.example.demo.shiro;

import com.example.demo.service.RoleService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by chenhe on 2018/3/2.
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {

    //这里因为没有调用后台，直接默认只有一个用户("luoguohui"，"123456")
    private static final String USER_NAME = "luoguohui";
    private static final String PASSWORD = "123456";

    @Autowired
    private RoleService roleService;

    private Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Subject subject = SecurityUtils.getSubject();
        logger.info("----- 查询授权信息 -----");
        if (!subject.isAuthenticated()) {
            doClearCache(principalCollection);
            subject.logout();
            return null;
        }
        String userName = (String)principalCollection.getPrimaryPrincipal();

        logger.info("查询用户角色:userName={}",userName);
        Set<String> roleName = roleService.queryRole(userName); //查询角色
        Set<String> permissions = roleService.QueryPermissions(userName);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permissions);
        info.setRoles(roleName);
        return info;
    }

    /**
     * 登录
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("host:{},userName:{},password:{}", token.getHost(), token.getUsername(), token.getPassword());
        if (token.getUsername().equals(USER_NAME)) {
            return new SimpleAuthenticationInfo(USER_NAME, PASSWORD, getName());
        }
        throw new AuthenticationException();
    }
}
