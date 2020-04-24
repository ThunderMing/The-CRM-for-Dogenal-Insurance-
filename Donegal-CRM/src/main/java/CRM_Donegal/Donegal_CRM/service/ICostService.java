package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.query.CostQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

public interface ICostService {
    /**
     * Query charging information
     *
     * @return
     */
    List<Insurance> selectCostInfo();

    /**
     * Advanced Query
     *
     * @param qo
     * @return
     */
    PageResult query(CostQueryObject qo);
}
