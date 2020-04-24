package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Menu;
import CRM_Donegal.Donegal_CRM.domain.Permission;
import CRM_Donegal.Donegal_CRM.domain.Role;
import CRM_Donegal.Donegal_CRM.mapper.RoleMapper;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.IRoleService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleMapper roleMapper;

    @Override
    public void saveOrUpdate(Role entity) {
        if (entity.getId() == null) {
            roleMapper.insert(entity);
        } else {
            roleMapper.deletePermissionRelation(entity.getId());
            roleMapper.deleteMenuRelation(entity.getId());
            roleMapper.updateByPrimaryKey(entity);
        }
      
        List<Permission> permissions = entity.getPermissions();
        if (permissions != null) {
            for (Permission permission : permissions) {
                roleMapper.insertPermissionRelation(entity.getId(), permission.getId());
            }
        }
       
        List<Menu> menus = entity.getMenus();
        if (menus != null) {
            for (Menu menu : menus) {
                roleMapper.insertMenuRelation(entity.getId(), menu.getId());
            }
        }
    }

    @Override
    public void delete(Long id) {
        roleMapper.deletePermissionRelation(id);
        roleMapper.deleteMenuRelation(id);
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role get(Long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Role> selectAll() {
        return roleMapper.selectAll();
    }

    @Override
    public PageResult query(QueryObject qo) {
        Integer total = roleMapper.queryForCount(qo);
        if (total > 0) {
            return new PageResult(roleMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }

    @Override
    public List<Long> selectByEmployeeId(Long employeeId) {
        return roleMapper.selectByEmployeeId(employeeId);
    }

    @Override
    public List<String> selectNameByEmployeeId(Long employeeId) {
        return roleMapper.selectNameByEmployeeId(employeeId);
    }

}
