package CRM_Donegal.Donegal_CRM.web.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Thunder Lei
 */

@Controller
@RequestMapping("staff")
public class StaffController {
   
    @RequestMapping("signed")
    public String signed(){
        return "staff/signed";
    }
    
    @RequestMapping("mission")
    public String mission(){
        return "staff/mission";
    }
    
    @RequestMapping("salary")
    public String salary(){
        return "staff/salary";
    }
}
