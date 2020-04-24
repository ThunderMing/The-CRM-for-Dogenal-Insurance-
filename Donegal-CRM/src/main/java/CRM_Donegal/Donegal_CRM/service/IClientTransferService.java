package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Client;
import CRM_Donegal.Donegal_CRM.domain.ClientTransfer;
import CRM_Donegal.Donegal_CRM.query.ClientQueryObejct;
import CRM_Donegal.Donegal_CRM.query.TransferQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

public interface IClientTransferService {


    int insert(ClientTransfer record,Long newEmpl);

    /**
     * @param qo
     * @return
     */
    PageResult query(TransferQueryObject qo);

}
