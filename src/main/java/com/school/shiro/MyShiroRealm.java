package com.school.shiro;

import com.school.entity.SystemUser;
import com.school.service.SystemUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by chendonglin on 2018/4/25.
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private SystemUserService systemUserService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
//        user user = upmsApiService.selectUpmsUserByUsername(username);
//
//        // 当前用户所有角色
//        List<UpmsRole> upmsRoles = upmsApiService.selectUpmsRoleByUpmsUserId(user.getUserId());
        Set<String> roles = new HashSet<>();
//        for (UpmsRole upmsRole : upmsRoles) {
//            if (StringUtils.isNotBlank(upmsRole.getName())) {
//                roles.add(upmsRole.getName());
//            }
//        }
//
//        // 当前用户所有权限
//        List<UpmsPermission> upmsPermissions = upmsApiService.selectUpmsPermissionByUpmsUserId(user.getUserId());
        Set<String> permissions = new HashSet<>();
//        for (UpmsPermission upmsPermission : upmsPermissions) {
//            if (StringUtils.isNotBlank(upmsPermission.getPermissionValue())) {
//                permissions.add(upmsPermission.getPermissionValue());
//            }
//        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 验证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        String password = new String(usernamePasswordToken.getPassword());
        //  密码验证
        // 查询用户信息
        SystemUser user = systemUserService.selectByUsername(username);
        if (null == user) {
            throw new UnknownAccountException();
        }
        if (!user.getPassword().equals(password)) {
            throw new IncorrectCredentialsException();
        }
        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
