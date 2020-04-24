package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.mapper.InsuranceMapper;
import CRM_Donegal.Donegal_CRM.query.CostQueryObject;
import CRM_Donegal.Donegal_CRM.service.ICostService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostServiceImpl implements ICostService {
    @Autowired
    InsuranceMapper insuranceMapper;

    /**
     * Check the information of the payment  
     * @return
     */
    @Override
    public List<Insurance> selectCostInfo() {
        return insuranceMapper.selectCostInfo();
    }

    public PageResult query(CostQueryObject qo) {
        Integer total = insuranceMapper.queryCostForCount(qo);
        if (total > 0) {
            return new PageResult(insuranceMapper.queryCostForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }
}
