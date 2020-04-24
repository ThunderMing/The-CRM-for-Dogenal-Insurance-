package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.domain.Organization;
import CRM_Donegal.Donegal_CRM.query.OrganizationQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.query.ReviewQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

/**
 * Object: The Business of check and insurance 
 * Author: Thunder Lei
 */
public interface IReviewService {

    /*
        Rollback or review pass operation, change policy status
     */
    void rollback(Long id);

    /*
       Auditing Approved operation, change policy status
     */
    void pass(Long id);

    /**
     * Query out the pending order status
     * @return  Author: Thunder Lei
     */
    PageResult selectByInsuranceAutit(ReviewQueryObject qo);

    /**
     * Save Operation,Update the information of note 
     * @param insurance
     */
    void updateByMessager(Insurance insurance);

}
