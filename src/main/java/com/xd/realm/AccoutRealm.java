package com.xd.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

/**
 * shiro 的具体 授权认证类
 */
public class AccoutRealm extends AuthorizingRealm {
    @Autowired
//    private UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //从数据库中根据权限角色表查询出角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<>();
        roles.add("role1");
        roles.add("role2");
        simpleAuthorizationInfo.addRoles(roles);

        Set<String> perms = new HashSet<>();
        perms.add("perms1");
        perms.add("perms2");
        simpleAuthorizationInfo.addStringPermissions(perms);
        return simpleAuthorizationInfo;

    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        String username = token.getUsername();
//        QueryWrapper<User> wrapper = new QueryWrapper<User>().eq("username", username);
//        User one = userService.getOne(wrapper);
//        System.out.println("one = " + one);
//        if (one != null) {
//            return new SimpleAuthenticationInfo(username, one.getPwd(), getName());
//        }
        throw  new AuthenticationException("并没有找到该用户");
    }
}
