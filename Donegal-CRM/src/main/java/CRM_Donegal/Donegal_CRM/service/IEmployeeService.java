package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

public interface IEmployeeService {

    void saveOrUpdate(Employee entity);
    
    void delete(Long id);

    Employee get(Long id);

    PageResult query(QueryObject qo);

    Employee selectByRealname(String realname);

    /**
     * find out the information of user based on the username 
     * @param username
     * @param id
     * @return
     */
    Employee selectByUsername(String username);

    /**
     * Change employment status based on user id
     * @param id
     */
    void changeState(Long id);

    List<Employee> selectAll();
}
