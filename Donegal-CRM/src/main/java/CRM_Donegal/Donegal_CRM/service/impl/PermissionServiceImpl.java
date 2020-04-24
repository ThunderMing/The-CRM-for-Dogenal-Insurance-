package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Permission;
import CRM_Donegal.Donegal_CRM.mapper.PermissionMapper;
import CRM_Donegal.Donegal_CRM.service.IPermissionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    RequestMappingHandlerMapping rmhm;

    @Override
    public void saveOrUpdate(Permission entity) {
        if (entity.getId() == null) {
            permissionMapper.insert(entity);
        } else {
            permissionMapper.updateByPrimaryKey(entity);
        }
    }

    @Override
    public void reload() {
        List<String> resources = permissionMapper.selectAllResource();
        
       //RequestMappingHandlerMapping manages the methods posted on Controller with RequestMapping annotation, this object belongs to springmvc
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = rmhm.getHandlerMethods();
        //RequestMapping Annotation Method
        Collection<HandlerMethod> values = handlerMethods.values();
        for (HandlerMethod method : values) {
            RequiresPermissions anno = method.getMethodAnnotation(RequiresPermissions.class);
            if(anno != null){
                //value of Property
                String[] value = anno.value();
                
                if(!resources.contains(value[0])){
                    Permission permission = new Permission();
                    permission.setResource(value[0]);
                    permission.setName(value[1]);
                    permissionMapper.insert(permission);
                }
            }
        }
    }

    @Override
    public List<String> selectByEmployeeId(Long employeeId) {
        return permissionMapper.selectByEmployeeId(employeeId);
    }

    @Override
    public void delete(Long id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Permission get(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Permission> selectAll() {
        return permissionMapper.selectAll();
    }

    @Override
    public List<Permission> selectByRoleId(Long roleId) {
        return permissionMapper.selectByRoleId(roleId);
    }

}
