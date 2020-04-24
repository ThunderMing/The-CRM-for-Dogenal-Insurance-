package CRM_Donegal.Donegal_CRM.service;
import CRM_Donegal.Donegal_CRM.domain.Permission;

import java.util.Collection;
import java.util.List;

public interface IPermissionService {

    void saveOrUpdate(Permission entity);

    void delete(Long id);

    Permission get(Long id);

    List<Permission> selectAll();

    List<Permission> selectByRoleId(Long roleId);

    void reload();

    /**
     * 
		Find out the corresponding authority resource 
		according to the role id
     * @param employeeId
     * @return
     */
    List<String> selectByEmployeeId(Long employeeId);
}
