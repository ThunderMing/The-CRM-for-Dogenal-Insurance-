package CRM_Donegal.Donegal_CRM.service;
import CRM_Donegal.Donegal_CRM.domain.Salary;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.query.SalaryQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.text.ParseException;

/**
 * The Interface of Salary Management 
 *Thunder Lei
 * Jan, 2020
 */
public interface ISalaryService {

    void saveOrUpdate(Salary entity) throws ParseException;
    
    void delete(Long id);

    Salary get(Long id);

    /**
     * Advanced Query 
     * @param qo
     * @return
     */
    PageResult query(SalaryQueryObject qo);
}
