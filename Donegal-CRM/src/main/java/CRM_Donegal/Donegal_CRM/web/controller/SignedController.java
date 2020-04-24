package CRM_Donegal.Donegal_CRM.web.controller;
import CRM_Donegal.Donegal_CRM.query.SignedQueryObject;
import CRM_Donegal.Donegal_CRM.service.ISignedService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Attendance Management Controller
 */
@Controller
@RequestMapping("signed")
public class SignedController {
    @Autowired
    ISignedService signedService;

    /**
     * The interface of Attendance Management 
     * @return
     */
    @RequestMapping("view")
    public String view(){
        return "staff/signed";
    }

    /**
     * @param qo
     * @return
     */
    @RequestMapping("query")
    @ResponseBody
    public Object query(SignedQueryObject qo){
        return signedService.query(qo);
    }

    /**
     * Function of going to work 
     * @return
     */
    @RequestMapping("startwork")
    @ResponseBody
    public Object startwork(){
        try {
            signedService.startwork();
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }

    /**
     * Function of Getting off work 
     * @return
     */
    @RequestMapping("offwork")
    @ResponseBody
    public Object offwork(){
        try {
            signedService.offwork();
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }


}