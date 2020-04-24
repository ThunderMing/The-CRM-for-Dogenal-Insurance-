package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.ClientTransfer;
import CRM_Donegal.Donegal_CRM.query.ClientQueryObejct;
import CRM_Donegal.Donegal_CRM.query.TransferQueryObject;

import java.util.List;

public interface ClientTransferMapper {

    int insert(ClientTransfer record);

    /**
     * Records of query 
     * @param qo
     * @return
     */
    Integer queryForCount(TransferQueryObject qo);

    /**
     * 
     * @param qo
     * @return
     */
    List<?> queryForList(TransferQueryObject qo);
}