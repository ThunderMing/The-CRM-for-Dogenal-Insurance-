package CRM_Donegal.Donegal_CRM.web.filter;

import CRM_Donegal.Donegal_CRM.util.JSONResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFormFilter extends FormAuthenticationFilter {
    /**
     * The method of implementation when login successfully 
     * @param token
     * @param subject
     * @param request
     * @param response
     * @return Return true to pass, false to filter, 
     * 			i.e. don't execute the following filter or controller method
     * @throws Exception
     */
    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        //Log in successfully and output json data to the browser
        response.getWriter().print(new ObjectMapper().writeValueAsString(new JSONResult()));
        return false;
    }

    /**
     * Method to execute after login failure
     * @param token
     * @param e
     * @param request
     * @param response
     * @return Return true to pass, false to filter, 
     * 			i.e. don't execute the following filter or controller method
     */
    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        //Print out exceptions for easy debugging
        e.printStackTrace();
        String errorMsg = "For other abnormal reasons, please contact the administrator";
        if(e instanceof UnknownAccountException){
            errorMsg = "User does not exist";
        } else if(e instanceof IncorrectCredentialsException){
            errorMsg = "Wrong Password";
        }
        try {
            //Format content
            response.setContentType("application/json;charset=utf-8");
            //Output the failed json data to the browser
            response.getWriter().print(new ObjectMapper().writeValueAsString(new JSONResult().mark(errorMsg)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

   /*
      Solve the problem of not being able to log in repeatedly
    */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        //Determine if it is a login request
    	
        if(isLoginRequest(request,response)){
            //If yes, cancel the subject
            Subject subject = SecurityUtils.getSubject();
            if(subject.isAuthenticated()){
                subject.logout();
            }
        }

        return super.isAccessAllowed(request, response, mappedValue);
    }
}
