package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Client;
import CRM_Donegal.Donegal_CRM.query.ClientQueryObejct;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

public interface IClientService {

    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    List<Client> selectAll();

    int updateByPrimaryKey(Client record);

    int updateByPrimaryKey1(Client record);

    int updateByPrimaryKey2(Client record);

    /**
    
     * @param qo
     * @return
     */
    PageResult query(ClientQueryObejct qo);

    /**
     *
     * @param id
     */
    void updateByState(Long id);

    /**
     * 
     * @param client
     */
    void updateByMoveResouce(Long id);

    void updateDutyEmpl(Long id,Long cId);

    void delete(Long id);
}
