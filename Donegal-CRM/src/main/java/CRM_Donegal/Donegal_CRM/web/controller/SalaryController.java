package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.Salary;
import CRM_Donegal.Donegal_CRM.query.SalaryQueryObject;
import CRM_Donegal.Donegal_CRM.service.ISalaryService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Salary Management Controller
 * Thunder Lei
 */
@Controller
@RequestMapping("salary")
public class SalaryController {
    @Autowired
    ISalaryService salaryService;

    /**
     * The interface of Salary Management 
     * @return
     */
    @RequestMapping("view")
    public String view(){
        return "staff/salary";
    }

    /**
     * Advanced Query of Salary Management 
     * @param qo
     * @return
     */
    @RequestMapping("query")
    @ResponseBody
    public Object query(SalaryQueryObject qo){
        return salaryService.query(qo);
    }

    /**
     * Add and Modify 
     * @param entity
     * @return
     */
    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Salary entity){
        try {
            salaryService.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }
}