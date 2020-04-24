package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Role;
import CRM_Donegal.Donegal_CRM.domain.Role;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

public interface IRoleService {

    void saveOrUpdate(Role entity);
    
    void delete(Long id);

    Role get(Long id);

    List<Role> selectAll();

    PageResult query(QueryObject qo);

    List<Long> selectByEmployeeId(Long employeeId);

    /**
     * Check the name of all the role 
     * According to the corresponding user ID 
     * @param employeeId
     * @return
     */
    List<String> selectNameByEmployeeId(Long employeeId);
}
