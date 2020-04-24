package CRM_Donegal.Donegal_CRM.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Enhance controller
 */
@ControllerAdvice
public class HandlerExceptionUtil {
    /*
        
	Handle different exceptions (unauthorized exceptions)
     */
    @ExceptionHandler(UnauthorizedException.class)
    public void handlerException(HttpServletResponse response, HandlerMethod method) throws IOException {
        //the request of ajax is not valid 
        //ajax request(if there is responseBody annotation),if it is and return json,if not and it will jump page 
        RequestBody anno = method.getMethodAnnotation(RequestBody.class);
        if (anno != null) {
            
            response.setContentType("application/json;charset=utf-9");
            response.getWriter().print(new ObjectMapper().writeValueAsString(new JSONResult().mark("You don't have permission to operate")));
        } else {
            response.sendRedirect("/nopermission.jsp");
        }
    }
}
