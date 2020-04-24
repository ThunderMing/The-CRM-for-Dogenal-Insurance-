package CRM_Donegal.Donegal_CRM.mapper;
import CRM_Donegal.Donegal_CRM.domain.Department;
import CRM_Donegal.Donegal_CRM.query.QueryObject;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    int queryForCount(QueryObject qo);

    List<Department> queryForList(QueryObject qo);

    void changeState(Long id);
}