package CRM_Donegal.Donegal_CRM.realm;

import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.service.IEmployeeService;
import CRM_Donegal.Donegal_CRM.service.IPermissionService;
import CRM_Donegal.Donegal_CRM.service.IRoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IPermissionService permissionService;

    /**
     * 
	After adding the ehcache cache, 
	the permissions will be cached after the first query, 
	and it will not enter this method again when judging the permissions again.
     * Authorization
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        Employee emp = (Employee) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        
        if(emp.getAdmin()){
       
            info.addRole("ADMIN");
            info.addStringPermission("*:*");
        } else {
           
            info.addRoles(roleService.selectNameByEmployeeId(emp.getId()));
            info.addStringPermissions(permissionService.selectByEmployeeId(emp.getId()));
        }
        return info;
    }

    /**
     * Authentication
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String principal = (String) token.getPrincipal();
       
        Employee emp = employeeService.selectByUsername(principal);
       if(emp != null){
           return new SimpleAuthenticationInfo(emp, emp.getPassword(), ByteSource.Util.bytes(emp.getUsername()),this.getName());
       }
        return null;
    }
}
