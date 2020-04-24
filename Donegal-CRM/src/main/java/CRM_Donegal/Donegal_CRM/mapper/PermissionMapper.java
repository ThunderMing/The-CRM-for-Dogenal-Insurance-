package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.Permission;
import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    List<Permission> selectByRoleId(Long roleId);

    List<String> selectAllResource();

    /**
     * Find out the corresponding authority resource according to the role id
     * @param employeeId
     * @return
     */
    List<String> selectByEmployeeId(Long employeeId);
}