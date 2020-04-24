package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.LossOrFail;
import CRM_Donegal.Donegal_CRM.query.LossOrFailQueryObject;
import CRM_Donegal.Donegal_CRM.query.TransferQueryObject;

import java.util.List;

public interface LossOrFailMapper {

    int insert(LossOrFail record);

    int updateByPrimaryKey(LossOrFail record);

    /**
     *
     * @param qo
     * @return
     */
    Integer queryForCount(LossOrFailQueryObject qo);

    /**
     * 
     * @param qo
     * @return
     */
    List<?> queryForList(LossOrFailQueryObject qo);
}