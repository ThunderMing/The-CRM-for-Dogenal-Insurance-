package CRM_Donegal.Donegal_CRM.util;

import CRM_Donegal.Donegal_CRM.domain.SystemLog;
import CRM_Donegal.Donegal_CRM.service.ISystemLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class SystemLogUtil {
    @Autowired
    ISystemLogService systemLogService;
    public void writeLog(JoinPoint joinPoint){

        /*
            Solve the problem of infinite loop, reason: 
            because the entry point of AOP is the method of each service, 
            and there is also a service related to the log operation, resulting in
            The method of recording the log that is called when saving the log results in an infinite loop
         */
        if(joinPoint.getTarget() instanceof ISystemLogService){
            return;
        }

        SystemLog log = new SystemLog();
       
        log.setOpTime(new Date());
        
        log.setOpUser(UserContext.getCurrentUser());
       
        log.setOpIp(UserContext.getRequest().getRemoteAddr());
       
        String className = joinPoint.getTarget().getClass().getName();
        
        String methodName = joinPoint.getSignature().getName();
      
        log.setFunction(className+":"+methodName);
     

        try {
            log.setParams(new ObjectMapper().writeValueAsString(joinPoint.getArgs()));
            systemLogService.insert(log);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
