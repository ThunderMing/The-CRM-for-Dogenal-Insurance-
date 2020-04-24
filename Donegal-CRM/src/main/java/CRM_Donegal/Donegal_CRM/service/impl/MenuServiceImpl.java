package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.domain.Menu;
import CRM_Donegal.Donegal_CRM.mapper.MenuMapper;
import CRM_Donegal.Donegal_CRM.service.IMenuService;
import CRM_Donegal.Donegal_CRM.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

/**
 * Object: Institution Information
 * Author: Thunder Lei
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<Menu> selectRootMenu() {
        return menuMapper.selectRootMenu();
    }

    @Override
    public List<Long> selectByRoleId(Long roleId) {
        return menuMapper.selectByRoleId(roleId);
    }

    @Override
    public List<Menu> selectEmployeeMenu(Long id) {
      
        List<Menu> menus = menuMapper.selectRootMenu();
        
        Employee emp = UserContext.getCurrentUser();
        
        if(!emp.getAdmin()){
           
            List<Long> ids = menuMapper.seleByEmployeeId(emp.getId());
          
            checkPermission(menus, ids);
        }
        return menus;
    }

    @Override
    public List<Menu> list() {
        return menuMapper.selectAll();
    }

    private void checkPermission(List<Menu> menus, List<Long> ids) {
      
        Iterator<Menu> iterator = menus.iterator();
        while(iterator.hasNext()){
            Menu menu = iterator.next();
         
            if(!ids.contains(menu.getId())){
             
                iterator.remove();
                continue;
            }
      
            if(menu.getChildren().size() > 0){
                checkPermission(menu.getChildren(), ids);
            }
        }
    }
}
