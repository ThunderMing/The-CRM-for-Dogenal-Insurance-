package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Case;
import CRM_Donegal.Donegal_CRM.query.CaseQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

/**
 * Author: Thunder Lei
 * Function: Claims
 */
public interface ICaseService {

    void saveOrUpdate(Case entity);
    
    void delete(Long id);

    Case get(Long id);

    List<Case> selectAll();

    PageResult query(CaseQueryObject qo);

    void makeInvalidById(Long id);

    void checkUpdate(Case caseBill);

    PageResult queryForAudit(CaseQueryObject qo);

    void makePassById(Long id);

    void makeNopayById(Long id);

    PageResult queryForCaseList(CaseQueryObject qo);
}
