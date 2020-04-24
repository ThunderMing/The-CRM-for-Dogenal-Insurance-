package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Menu;

import java.util.List;

public interface IMenuService {

   List<Menu> selectRootMenu();

   List<Long> selectByRoleId(Long roleId);

    List<Menu> selectEmployeeMenu(Long id);

    List<Menu> list();
}
