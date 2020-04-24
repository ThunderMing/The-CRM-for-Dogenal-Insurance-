package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.mapper.InsuranceMapper;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.query.ReviewQueryObject;
import CRM_Donegal.Donegal_CRM.service.IReviewService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Business of Check and Insurance 
 * Author: Thunder Lei
 */
@Service
public class ReviewServiceImpl implements IReviewService {
    @Autowired
    InsuranceMapper insuranceMapper;


    /*
        Rollback operation, change policy status

     */
    public void rollback(Long id) {
        Insurance insurance = insuranceMapper.selectByPrimaryKey(id);
        Integer status = insurance.getBillstatus();
        if (status == 2) {  
            insuranceMapper.rollbackOrPass(Insurance.BILL_AUDI_BACK, id);
        } else if (status == 5) { 
            insuranceMapper.rollbackOrPass(Insurance.BILL_EDIT_AUDIT_OK, id);
        }
    }

    /*
      Rollback operation, change policy status
     */
    public void pass(Long id) {
        Insurance insurance = insuranceMapper.selectByPrimaryKey(id);
        Integer status = insurance.getBillstatus();
        if (status == 2) {  
            insuranceMapper.rollbackOrPass(Insurance.BILL_PAY_WAIT, id);
        } else if (status == 5) { 
            insuranceMapper.rollbackOrPass(Insurance.BILL_OK, id);
        }
    }

    /**
     * Query out the pending order status
     *
     * @return
     */
    public PageResult selectByInsuranceAutit(ReviewQueryObject qo) {
        Integer total = insuranceMapper.queryForCount(qo);
        if (total > 0) {
            List<Insurance> list = insuranceMapper.selectByInsuranceAutit(qo);
            return new PageResult(insuranceMapper.selectByInsuranceAutit(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }

    /**
     *Save the information updated 
     * @param insurance
     */
    public void updateByMessager(Insurance insurance) {
        String masager = insurance.getMessage();
        Long insId = insurance.getId();
        insuranceMapper.updateByMessager(masager, insId);
    }
}
