package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Department;
import CRM_Donegal.Donegal_CRM.mapper.DepartmentMapper;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.IDepartmentService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public void insert(Department record) {
        departmentMapper.insert(record);
    }

    @Override
    public Department selectByPrimaryKey(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Department> selectAll() {
        return departmentMapper.selectAll();
    }

    @Override
    public void updateByPrimaryKey(Department record) {
        departmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public PageResult query(QueryObject qo) {
        int total = departmentMapper.queryForCount(qo);
        if (total > 0) {
            List<Department> rows = departmentMapper.queryForList(qo);
            return new PageResult(rows, total);
        }
        return new PageResult(Collections.EMPTY_LIST,0);
    }

    @Override
    public void changeState(Long id) {
        departmentMapper.changeState(id);
    }
}
