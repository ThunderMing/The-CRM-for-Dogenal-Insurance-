package CRM_Donegal.Donegal_CRM.util;

import CRM_Donegal.Donegal_CRM.domain.Employee;
import org.apache.commons.fileupload.RequestContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class UserContext {

    public static Employee getCurrentUser(){
        return (Employee) SecurityUtils.getSubject().getPrincipal();
    }

    public static HttpServletRequest getRequest(){
       return ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }
}
