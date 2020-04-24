package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    int updateByPrimaryKey(Employee record);

    /**
     * 
     * @param qo
     * @return
     */
    Integer queryForCount(QueryObject qo);
    List<?> queryForList(QueryObject qo);

    /**
     * 
     * @param username
     * @return
     */
    Employee selectByUsername(String username);

    /**
     * 
     * @param realname
     * @return
     */
    Employee selectByRealname(String realname);

    /**
     * 
     * @param id
     */
    void changeState(Long id);


    /**
     * 
     * @param employeeId
     */
    void deleteRoleRelation(Long employeeId);
    void insertRoleRelation(@Param("employeeId") Long employeeId,
                            @Param("roleId")Long roleId);

    /**
     * 
     */
    List<Employee> selectAll();
}