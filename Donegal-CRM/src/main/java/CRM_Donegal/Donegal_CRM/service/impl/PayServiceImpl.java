package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.mapper.InsuranceMapper;
import CRM_Donegal.Donegal_CRM.query.PayQueryObject;
import CRM_Donegal.Donegal_CRM.service.IPayService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements IPayService {
    @Autowired
    InsuranceMapper insuranceMapper;

    /**
     * Query the information of payment 
     *
     * @return
     */
    @Override
    public List<Insurance> selectPayInfo() {
        return insuranceMapper.selectPayInfo();
    }

    /**
     * Change the status of payment 
     *
     * @param id
     */
    @Override
    public void changeState(Long id) {
        insuranceMapper.changeState(id);
    }

    public PageResult query(PayQueryObject qo) {
        Integer total = insuranceMapper.queryPayForCount(qo);
        if (total > 0) {
            return new PageResult(insuranceMapper.queryPayForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }
}
