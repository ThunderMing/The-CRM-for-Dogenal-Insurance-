package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.Department;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.IDepartmentService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("department")
@SuppressWarnings("all")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("selectAll")
    @ResponseBody
    public Object selectAll(){
        return departmentService.selectAll();
    }

    @RequiresPermissions(value = {"department:view","The interface of Department"},logical = Logical.OR)
    @RequestMapping("view")
    public String view() {
        return "system/department";
    }

    @RequiresPermissions(value={"department:list","The List of Department"},logical = Logical.OR)
    @RequestMapping("query")
    @ResponseBody
    public PageResult query(QueryObject qo) {
        return departmentService.query(qo);
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public JSONResult saveOrUpdate(Department entity) {
        JSONResult result = new JSONResult();
        try {
            if (entity.getId() == null) {
                departmentService.insert(entity);
            }else {
                departmentService.updateByPrimaryKey(entity);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result.mark("Fail to save!");
        }
    }

    @RequestMapping("changeState")
    @ResponseBody
    public JSONResult changeState(Long id) {
        JSONResult result = new JSONResult();
        try {
            departmentService.changeState(id);
            return result;
        }
         catch (Exception e) {
            e.printStackTrace();
            return result.mark("Fail to modify the status");
        }
    }

}
