package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.Role;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.IRoleService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("role")
public class RoleController {
    @Autowired
    IRoleService roleService;
    @RequestMapping("view")
    public String view(){
        return "system/role";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(QueryObject qo){
        return roleService.query(qo);
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Object selectAll(){
        return roleService.selectAll();
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Role entity){
        try {
            roleService.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }

    @RequestMapping("selectByEmployeeId")
    @ResponseBody
    public Object selectByEmployeeId(Long employeeId){
        return roleService.selectByEmployeeId(employeeId);
    }
}
