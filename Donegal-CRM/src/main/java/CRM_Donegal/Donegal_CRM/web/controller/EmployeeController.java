package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.query.EmployeeQueryObject;
import CRM_Donegal.Donegal_CRM.service.IEmployeeService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @RequestMapping("view")
    @RequiresPermissions({"employee:view","The page of employee"})
    public String view(){
        return "system/employee";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(EmployeeQueryObject qo){
        //Judging control authority through logic
        Subject subject = SecurityUtils.getSubject();
        if (subject.hasRole("MANAGER")) {
            
        } else {
            
        }
        return employeeService.query(qo);
    }

    @RequestMapping("validName")
    @ResponseBody
    public Object validName(String username, Long id){
        //The user name can find the data, and the id in the data is 
    	//the same as the incoming id, then it is confirmed as an edit operation
        Employee employee = employeeService.selectByUsername(username);
        //if it is True, it stands for available 
        return employee == null || employee.getId() == id;
    }

    @RequestMapping("saveOrUpdate")
    @RequiresPermissions({"employee:saveOrUpdate","Employee changes"})
    @ResponseBody
    public Object saveOrUpdate(Employee entity){
        try {
            employeeService.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }

    @RequestMapping("changeState")
    @RequiresPermissions({"employee:changeState","Employee dismissal"})
    @ResponseBody
    public Object changeState(Long id){
        if (id == null) {
            return new JSONResult().mark("Parameters Error!");
        }
        try {
            employeeService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Object selectAll(){
        List<Employee> employees = employeeService.selectAll();
        return employees;
    }
}
