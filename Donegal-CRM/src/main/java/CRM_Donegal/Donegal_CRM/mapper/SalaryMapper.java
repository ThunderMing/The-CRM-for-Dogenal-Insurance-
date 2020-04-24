package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.Salary;
import CRM_Donegal.Donegal_CRM.query.MissionQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.query.SalaryQueryObject;

import java.util.List;

/**
 * Salary Management Mapper
 * Thunder Lei
 * Jan, 2020
 */

public interface SalaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Salary record);

    Salary selectByPrimaryKey(Long salaryId);

    List<Salary> selectAll();

    int updateByPrimaryKey(Salary record);

    /**
     *
	* Advanced query paging
     * @param qo Customize
     * @return
     */
    Integer queryForCount(SalaryQueryObject qo);

    List<?> queryForList(SalaryQueryObject qo);
}