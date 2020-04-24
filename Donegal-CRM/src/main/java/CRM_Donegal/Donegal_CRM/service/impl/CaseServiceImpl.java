package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Case;
import CRM_Donegal.Donegal_CRM.mapper.CaseMapper;
import CRM_Donegal.Donegal_CRM.query.CaseQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.ICaseService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function: Claims
 * Author: Thunder Lei
 * 
 */
@Service
public class CaseServiceImpl implements ICaseService {
    @Autowired
    CaseMapper caseMapper;

    @Override
    public void saveOrUpdate(Case entity) {
        if (entity.getId() == null) {
            caseMapper.insert(entity);
        } else {
            caseMapper.updateByPrimaryKey(entity);
        }
    }

    @Override
    public void delete(Long id) {
        caseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Case get(Long id) {
        return caseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Case> selectAll() {
        return caseMapper.selectAll();
    }

    @Override
    public PageResult query(CaseQueryObject qo) {

        Integer total = caseMapper.queryForCount(qo);
        if (total > 0) {
            List<?> list = caseMapper.queryForList(qo);
            return new PageResult(list, total);
        }
        return PageResult.EMPTY_PAGE;
    }

    /**
     * Function: Click the button to set the report form to an invalid state
     */
    @Override
    public void makeInvalidById(Long id) {
        caseMapper.makeInvalidById(id);
    }

    /**
     * 
	Function: survey and determine damage, update the report form;
     * @param caseBill Encapsulate the three update parameters passed 
     * from the front desk and ID
     * @return
     */
    @Override
    public void checkUpdate(Case caseBill) {
        caseMapper.checkUpdate(caseBill);
    }

    /**
     * Author: Thunder Lei
     * Function: Advanced query to review the report form
     * @param qo
     * @return
     */
    @Override
    public PageResult queryForAudit(CaseQueryObject qo) {
        Integer total = caseMapper.queryForAuditCount(qo);
        if (total > 0) {
            List<?> list = caseMapper.queryForAuditList(qo);
            return new PageResult(list, total);
        }
        return PageResult.EMPTY_PAGE;
    }

    /**
     * Interface: audit report form
     *Function: Click the button to set the report form 
     *to the state of approval and payment

     */
    @Override
    public void makePassById(Long id) {
        caseMapper.makePassById(id);
    }

    /**
     * Interface: audit report form
     * Function: Click the button to set the report form as deductible
     */
    @Override
    public void makeNopayById(Long id) {
        caseMapper.makeNopayById(id);
    }

    /**
     * Author: Thunder Lei
     *
	Function: Advanced query for report form query

     * @param qo
     * @return
     */
    @Override
    public PageResult queryForCaseList(CaseQueryObject qo) {
        Integer total = caseMapper.queryForListCount(qo);
        if (total > 0) {
            List<?> list = caseMapper.queryForListList(qo);
            return new PageResult(list, total);
        }
        return PageResult.EMPTY_PAGE;
    }

}
