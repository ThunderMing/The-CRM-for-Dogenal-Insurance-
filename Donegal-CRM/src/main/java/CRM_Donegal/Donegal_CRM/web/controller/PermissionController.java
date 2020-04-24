package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.Permission;
import CRM_Donegal.Donegal_CRM.domain.Role;
import CRM_Donegal.Donegal_CRM.service.IPermissionService;
import CRM_Donegal.Donegal_CRM.service.IRoleService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {
    @Autowired
    IPermissionService permissionService;

    @RequestMapping("selectAll")
    @ResponseBody
    public Object selectAll(){
        return permissionService.selectAll();
    }

    @RequestMapping("reload")
    public void reload(){
        permissionService.reload();
    }

    @RequestMapping("selectByRoleId")
    @ResponseBody
    public Object selectByRoleId(Long roleId){
        return permissionService.selectByRoleId(roleId);
    }
}
