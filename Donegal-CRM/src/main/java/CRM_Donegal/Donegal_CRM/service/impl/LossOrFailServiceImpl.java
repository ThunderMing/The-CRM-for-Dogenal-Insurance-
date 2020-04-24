package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.ClientTransfer;
import CRM_Donegal.Donegal_CRM.domain.LossOrFail;
import CRM_Donegal.Donegal_CRM.mapper.LossOrFailMapper;
import CRM_Donegal.Donegal_CRM.query.LossOrFailQueryObject;
import CRM_Donegal.Donegal_CRM.query.TransferQueryObject;
import CRM_Donegal.Donegal_CRM.service.ILossOrFailService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LossOrFailServiceImpl implements ILossOrFailService{

    @Autowired
    private LossOrFailMapper lossOrFailMapper;

    /**
     * Add the records of failing to develop client
     * @param record
     * @param newEmpl
     * @return
     */
    public int insert(LossOrFail record) {

        record.setLossOrFailTime(new Date());
        record.setState(LossOrFail.FAIL);
        lossOrFailMapper.insert(record);
        return 0;
    }

    /**
     * Add the records of client loss
     * @param record
     */
    public void save_loss(LossOrFail record) {

        record.setLossOrFailTime(new Date());
        record.setState(LossOrFail.LOSS);
        lossOrFailMapper.insert(record);
    }

    /**
    The functions which Haven't finished 
     * @param record
     * @return
     */
    public int updateByPrimaryKey(LossOrFail record) {
        return 0;
    }

    public PageResult query(LossOrFailQueryObject qo) {

        Integer count = lossOrFailMapper.queryForCount(qo);
        if (count==0) {
            return PageResult.EMPTY_PAGE;
        }
        List<?> list = lossOrFailMapper.queryForList(qo);

        return new PageResult(list,count);
    }
}
