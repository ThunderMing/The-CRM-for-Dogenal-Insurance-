package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.Case;
import CRM_Donegal.Donegal_CRM.query.CaseQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;

import java.util.List;


/**
 * The Form of reporting
 * Author: Thunder Lei
 * Function: The Settlement of Claim
 */
public interface CaseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Case record);

    Case selectByPrimaryKey(Long id);

    List<Case> selectAll();

    int updateByPrimaryKey(Case record);
    /**
     * Advanced Query and Pagination
     * @param qo
     * @return
     */
    Integer queryForCount(QueryObject qo);
    List<?> queryForList(QueryObject qo);

    /**
     * User: on the page of reporting form
     * Function:click button and make the report form invalid
     */
    void makeInvalidById(Long id);

    /**
     * Function:check the loss and make a decision. And update the report form 
     * @param caseBill encapsulate the three parameters and id updated from front
     * @return
     */
    void checkUpdate(Case caseBill);

    /**
     * Auditing Function--Advanced Query and Pagination
     * @param qo
     * @return
     */
    Integer queryForAuditCount(CaseQueryObject qo);
    List<?> queryForAuditList(CaseQueryObject qo);

    /**
     * Interface:audit the report form
     * Function:click button and make the report form passed and done with payment 
     */
    void makePassById(Long id);

    /**
    * Interface:audit the report form
     * Function: click the button and make the report form reset as dedutible 
     */
    void makeNopayById(Long id);

    /**
     * The function of Reporting Checking Form: Advanced Query and Pagination
     * @param qo
     * @return
     */
    Integer queryForListCount(CaseQueryObject qo);
    List<?> queryForListList(CaseQueryObject qo);
}