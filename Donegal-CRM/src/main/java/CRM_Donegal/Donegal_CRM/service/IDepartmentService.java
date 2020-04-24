package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Department;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

public interface IDepartmentService {
    void insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    void updateByPrimaryKey(Department record);

    PageResult query(QueryObject qo);

    void changeState(Long id);
}
