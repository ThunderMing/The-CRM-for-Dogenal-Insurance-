package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.domain.Role;
import CRM_Donegal.Donegal_CRM.mapper.EmployeeMapper;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.IEmployeeService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public void saveOrUpdate(Employee entity) {
        if (entity.getId() == null) {
            entity.setState(true);
            Md5Hash hash = new Md5Hash(entity.getPassword(), entity.getUsername(),2);
            entity.setPassword(hash.toString());
            employeeMapper.insert(entity);
        } else {
            employeeMapper.deleteRoleRelation(entity.getId());
            employeeMapper.updateByPrimaryKey(entity);
        }
      
        List<Role> roles = entity.getRoles();
        if (roles != null) {
            for (Role role : roles) {
                employeeMapper.insertRoleRelation(entity.getId(), role.getId());
            }
        }
    }

    @Override
    public void delete(Long id) {
        employeeMapper.deleteRoleRelation(id);
        employeeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Employee get(Long id) {
        return employeeMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(QueryObject qo) {
        Integer total = employeeMapper.queryForCount(qo);
        if (total > 0) {
            return new PageResult(employeeMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }

    @Override
    public Employee selectByRealname(String realname) {
        return employeeMapper.selectByRealname(realname);
    }

    @Override
    public Employee selectByUsername(String username) {
        return employeeMapper.selectByUsername(username);
    }

    @Override
    public void changeState(Long id) {
        employeeMapper.changeState(id);
    }

    @Override
    public List<Employee> selectAll() {
        return employeeMapper.selectAll();
    }
}
