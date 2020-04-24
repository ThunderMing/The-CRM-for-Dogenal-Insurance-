package CRM_Donegal.Donegal_CRM.web.controller;
import CRM_Donegal.Donegal_CRM.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("menu")
public class MenuController {
    @Autowired
    IMenuService menuService;

    @RequestMapping("list")
    @ResponseBody
    public Object list() {
        return menuService.list();
    }

    @RequestMapping("selectRootMenu")
    @ResponseBody
    public Object selectRootMenu() {
        return menuService.selectRootMenu();
    }

    @RequestMapping("selectByRoleId")
    @ResponseBody
    public Object selectByRoleId(Long roleId) {
        return menuService.selectByRoleId(roleId);
    }

    @RequestMapping("selectEmployeeMenu")
    @ResponseBody
    public Object selectEmployeeMenu(Long id) {
        return menuService.selectEmployeeMenu(id);
    }

    @RequestMapping("saveOrUpdate")
    public Object saveOrUpdate() {
        return null;
    }

    @RequestMapping("delete")
    public Object delete() {
        return null;
    }

    @RequestMapping("view")
    public String view() {
        return "menu/list";
    }

}
