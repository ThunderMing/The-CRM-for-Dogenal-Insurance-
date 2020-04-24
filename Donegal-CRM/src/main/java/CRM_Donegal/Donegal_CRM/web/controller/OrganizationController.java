package CRM_Donegal.Donegal_CRM.web.controller;
import CRM_Donegal.Donegal_CRM.domain.Organization;
import CRM_Donegal.Donegal_CRM.query.OrganizationQueryObject;
import CRM_Donegal.Donegal_CRM.service.IOrganizationService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *Object: Institution Information 
 * Author: Thunder Lei
 */
@Controller
@RequestMapping("organization")
public class OrganizationController {
    @Autowired
    IOrganizationService organizationService;

    @RequestMapping("view")
    @RequiresPermissions({"organization:view", "The page of Institution Information"})
    public String view() {
        return "information/organization";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(OrganizationQueryObject qo) {
        PageResult query = organizationService.query(qo);
        return organizationService.query(qo);
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public List<Organization> selectAll() {
        return organizationService.selectAll();
    }

    @RequestMapping("saveOrUpdate")
    @RequiresPermissions({"organization:saveOrUpdate", "The change of Institution Information"})
    @ResponseBody
    public Object saveOrUpdate(Organization entity) {
        try {
            organizationService.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }
}
