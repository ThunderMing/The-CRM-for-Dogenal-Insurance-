package CRM_Donegal.Donegal_CRM.service;
import CRM_Donegal.Donegal_CRM.domain.ClientTransfer;
import CRM_Donegal.Donegal_CRM.domain.LossOrFail;
import CRM_Donegal.Donegal_CRM.query.LossOrFailQueryObject;
import CRM_Donegal.Donegal_CRM.query.TransferQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

public interface ILossOrFailService {


    /**
     * Add customer development record
     * @param record
     * @return
     */
    int insert(LossOrFail record);

    int updateByPrimaryKey(LossOrFail record);

    /**

     * @param qo
     * @return
     */
    PageResult query(LossOrFailQueryObject qo);

    /**
     * Add customer churn records
     * @param record
     */
    void save_loss(LossOrFail record);

}
