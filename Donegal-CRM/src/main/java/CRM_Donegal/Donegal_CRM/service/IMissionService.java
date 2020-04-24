package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Mission;
import CRM_Donegal.Donegal_CRM.query.MissionQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;
/**
 * TASK MANAGEMENT INTERFACE
 * Thunder Lei
 * Jan, 2020
 */
public interface IMissionService {

    void saveOrUpdate(Mission entity);
    
    void delete(Long id);

    Mission get(Long id);

    /**
     * Advanced Query
     * @param qo
     * @return
     */
    PageResult query(MissionQueryObject qo);

    /**
     * change the status of task into "finished"
     * @param id
     */
    void changeState(Long id);
}
