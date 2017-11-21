package org.tis.tools.shiro.realm;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.tis.tools.common.utils.StringUtil;
import org.tis.tools.model.def.ACConstants;
import org.tis.tools.model.po.ac.AcOperator;
import org.tis.tools.rservice.ac.capable.IAuthenticationRService;
import org.tis.tools.rservice.ac.capable.IOperatorRService;
import org.tis.tools.rservice.ac.capable.IRoleRService;
import org.tis.tools.shiro.authenticationToken.UserIdPasswordIdentityToken;

import java.util.Map;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private IOperatorRService operatorRService;

    @Autowired
    private IAuthenticationRService authenticationRService;

    @Autowired
    private IRoleRService roleRService;

    // TODO 从配置文件获取APPCODE
    private static final String appCode = "ABF";

    // 获取授权信息
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Map map = (Map)principals.getPrimaryPrincipal();
        String userId = (String) map.get("userId");
        String appCode = (String) map.get("appCode");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

//        Set<String> roles = roleRService.queryAllRoleByUserId(userId).stream().map(AcRole::getRoleCode).collect(Collectors.toSet());
//        authorizationInfo.setRoles(roles);
        authorizationInfo.setStringPermissions(authenticationRService.getPermissions(userId, appCode).getBhvPermissions());
        return authorizationInfo;
    }

    // 获取身份验证相关信息
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws
            AuthenticationException {
        UserIdPasswordIdentityToken token = (UserIdPasswordIdentityToken) authcToken;
        String userId = token.getUserId(); //获取用户名
        String identity = token.getIdentity(); //获取身份
        String appCode = token.getAppCode(); //获取身份
        if(StringUtils.isBlank(userId)) {
            throw new AccountException("用户名不能为空");
        }
        AcOperator user = authenticationRService.loginCheck2(userId, identity, appCode);
        if(user == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        // 如果用户状态不是 LOGOUT，LOGIN， PAUSE ，不允许登录
        if(!StringUtil.isEqualsIn(user.getOperatorStatus(),
                ACConstants.OPERATE_STATUS_LOGOUT,
                ACConstants.OPERATE_STATUS_LOGIN,
                ACConstants.OPERATE_STATUS_PAUSE)) {
            throw new AccountException("用户当前状态[" + user.getOperatorStatus() + "]不允许登录！");
        }
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配
        return new SimpleAuthenticationInfo(
                user.getUserId(), // 用户名
                user.getPassword(),
                ByteSource.Util.bytes(user.getGuid()), // salt=username+salt
                user.getUserId() // realm name
        );
    }
}