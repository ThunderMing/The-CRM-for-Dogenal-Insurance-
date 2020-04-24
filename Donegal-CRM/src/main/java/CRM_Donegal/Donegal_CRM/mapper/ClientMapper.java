package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.CarMessage;
import CRM_Donegal.Donegal_CRM.domain.Client;
import CRM_Donegal.Donegal_CRM.query.ClientQueryObejct;
import CRM_Donegal.Donegal_CRM.query.DevelClientQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;

import java.util.List;

public interface ClientMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Client record);

    List<Client> selectAll();

    int updateByPrimaryKey(Client record);

    int updateByPrimaryKey1(Client record);

    int updateByPrimaryKey2(Client record);

    /**
     * The records of querying 
     * @param qo
     * @return
     */
    Integer queryForCount(ClientQueryObejct qo);

    /**
     * Pagination Query 
     * @param qo
     * @return
     */
    List<?> queryForList(ClientQueryObejct qo);

    /**
     * 
     * @param state
     * @return
     */
    //List<?> selectByState(ClientQueryObejct qo);

    /**
     * 
     * @param id
     * @return
     */
    Client selectByClient(Long id);

    /**
     *
     * @param client
     */
    void updateByState(Client client);

    /**
     * 
     * @param client
     */
    void updateByMoveResouce(Client client);

    /**
     *
     * @param client
     */
    void updateDutyEmpl(Client client);

	Client selectByClient(Object id);
}