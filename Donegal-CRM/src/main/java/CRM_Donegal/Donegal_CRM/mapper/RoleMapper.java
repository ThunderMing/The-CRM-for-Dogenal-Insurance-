package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.Role;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    /**
     * @param qo
     * @return
     */
    Integer queryForCount(QueryObject qo);
    List<?> queryForList(QueryObject qo);

    /**
     * Maintain authority relationships
     * @param roleId
     */
    void deletePermissionRelation(Long roleId);
    void insertPermissionRelation(@Param("roleId") Long roleId, @Param("permissionId") Object object);


    /**
     * Maintain menu relationships
     * @param roleId
     * @param object
     */

    void insertMenuRelation(@Param("roleId") Long roleId, @Param("menuId")Object object);
    void deleteMenuRelation(Long roleId);

    /**
     * 根据用户id查找角色id
     * @param employeeId
     * @return Collection of the role id
     */

    List<Long> selectByEmployeeId(Long employeeId);

    /**
   	* Find all corresponding role names based on user id
     * @param employeeId
     * @return Collection of character names
     */
    List<String> selectNameByEmployeeId(Long employeeId);


}