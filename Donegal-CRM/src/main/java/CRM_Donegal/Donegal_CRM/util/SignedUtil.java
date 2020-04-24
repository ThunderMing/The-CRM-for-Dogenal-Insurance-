package CRM_Donegal.Donegal_CRM.util;

import CRM_Donegal.Donegal_CRM.domain.Signed;
import java.util.Date;

/**
 * The tool used to Login
 * Thunder Lei
 *Jan 2020
 * used to encapsulate the method of repeating setting
 */

public abstract class SignedUtil {
    public static Signed startWork(Signed s,Date formatDate, String realname, String deptName,Date date,Long empId){
        
        s.setCheckTime(formatDate);
       
        s.setEmpRealname(realname);
       
        s.setDeptName(deptName);
       
        s.setStartWork(date);
        
        s.setState(false);
        
        s.setEmpId(empId);
        return s;
    }
}
