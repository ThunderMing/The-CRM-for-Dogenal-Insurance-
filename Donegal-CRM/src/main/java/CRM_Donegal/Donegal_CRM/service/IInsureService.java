package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.query.PayQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.query.ReviewQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

public interface IInsureService {

    void save(Insurance entity);

    void update(Insurance entity);
    
    void delete(Long id);

    Insurance get(Long id);

    List<Insurance> selectAll();

    PageResult query(QueryObject qo);

    /**
     *Query out the pending order status
     * @return
     */
    List<Insurance> selectByInsuranceAutit(ReviewQueryObject qo);

    PageResult selectPayInfoState(ReviewQueryObject qo);

    /**
     *Query all policies to be reviewed and modified
     * @param qo
     * @return
     */
    PageResult queryWaitAndEdit(QueryObject qo);

    /**
     * 
		Pending withdrawal
     * @param id
     */
    void changeAsRollback(Long id);

    /**
     *Policy review
     * @param id
     */
    void changeAsAudit(Long id);

    void updateBillStatus(Insurance insurance);
}
