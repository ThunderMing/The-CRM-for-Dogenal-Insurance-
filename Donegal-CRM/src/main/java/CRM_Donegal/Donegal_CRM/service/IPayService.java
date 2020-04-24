package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.query.PayQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

public interface IPayService {
    /**
     * Check payment information
     * @return
     */
    List<Insurance> selectPayInfo();

    /**
     * 
	Change payment status
     * @param id
     */
    void changeState(Long id);

    /**
     * Advanced Query
     * @param qo
     * @return
     */
    PageResult query(PayQueryObject qo);
}
