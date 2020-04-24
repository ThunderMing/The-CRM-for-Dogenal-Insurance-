package CRM_Donegal.Donegal_CRM.service.impl;

/**
 Implementing Salary Management
 * Thunder Lei
 * Jan, 2020
 */

import CRM_Donegal.Donegal_CRM.domain.Salary;
import CRM_Donegal.Donegal_CRM.mapper.EmployeeMapper;
import CRM_Donegal.Donegal_CRM.mapper.SalaryMapper;
import CRM_Donegal.Donegal_CRM.mapper.SignedMapper;
import CRM_Donegal.Donegal_CRM.query.SalaryQueryObject;
import CRM_Donegal.Donegal_CRM.service.ISalaryService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import CRM_Donegal.Donegal_CRM.util.SalaryUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.ParseException;

@Service
public class SalaryServiceImpl implements ISalaryService {
    @Autowired
    SalaryMapper salaryMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SignedMapper signedMapper;

    /**
     * Add and MOdify 
     * @param entity 
     */
    @Override
    public void saveOrUpdate(Salary entity) throws ParseException {
        if (entity.getId() == null) {
            SalaryUtill.totalSalary(entity,employeeMapper,signedMapper);
            salaryMapper.insert(entity);
        } else {
            SalaryUtill.totalSalary(entity,employeeMapper,signedMapper);
            salaryMapper.updateByPrimaryKey(entity);
        }
    }

    public void delete(Long id) {
        salaryMapper.deleteByPrimaryKey(id);
    }

    public Salary get(Long id) {
        return salaryMapper.selectByPrimaryKey(id);
    }

    public PageResult query(SalaryQueryObject qo) {
        Integer total = salaryMapper.queryForCount(qo);
        if (total > 0) {
            return new PageResult(salaryMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }
}
