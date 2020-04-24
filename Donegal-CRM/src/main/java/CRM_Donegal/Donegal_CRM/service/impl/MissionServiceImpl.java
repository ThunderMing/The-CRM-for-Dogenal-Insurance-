package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.domain.Mission;
import CRM_Donegal.Donegal_CRM.domain.Role;
import CRM_Donegal.Donegal_CRM.mapper.DepartmentMapper;
import CRM_Donegal.Donegal_CRM.mapper.EmployeeMapper;
import CRM_Donegal.Donegal_CRM.mapper.MissionMapper;
import CRM_Donegal.Donegal_CRM.query.MissionQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.IMissionService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Implementing Task Management
 * Thunder Lei
 * Jan, 2020
 */

@Service
public class MissionServiceImpl implements IMissionService {
    @Autowired
    MissionMapper missionMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    /**
     * Add and Modify
     * @param entity 
     */
    @Override
    public void saveOrUpdate(Mission entity) {
        if (entity.getId() == null) {
         
            Employee e = employeeMapper.selectByRealname(entity.getName());
          
            String dept = e.getName();
           
            entity.setDept(dept);
            
            entity.setState(false);
            missionMapper.insert(entity);
        } else {
           
            Employee e = employeeMapper.selectByRealname(entity.getName());
          
            String dept = e.getName();
           
            entity.setDept(dept);
            missionMapper.updateByPrimaryKey(entity);
        }
    }

    public void delete(Long id) {
        missionMapper.deleteByPrimaryKey(id);
    }

    public Mission get(Long id) {
        return missionMapper.selectByPrimaryKey(id);
    }

    public PageResult query(MissionQueryObject qo) {
        Integer total = missionMapper.queryForCount(qo);
        if (total > 0) {
            return new PageResult(missionMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }

    /**
     * The status changed has finished 
     * @param id
     */
    public void changeState(Long id) {
        Mission m = new Mission();
        missionMapper.changeState(id);
    }
}
