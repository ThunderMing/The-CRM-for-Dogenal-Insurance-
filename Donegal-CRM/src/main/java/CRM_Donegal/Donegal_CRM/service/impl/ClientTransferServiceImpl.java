package CRM_Donegal.Donegal_CRM.service.impl;
import CRM_Donegal.Donegal_CRM.domain.ClientTransfer;
import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.mapper.ClientTransferMapper;
import CRM_Donegal.Donegal_CRM.mapper.EmployeeMapper;
import CRM_Donegal.Donegal_CRM.query.TransferQueryObject;
import CRM_Donegal.Donegal_CRM.service.IClientService;
import CRM_Donegal.Donegal_CRM.service.IClientTransferService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import CRM_Donegal.Donegal_CRM.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientTransferServiceImpl implements IClientTransferService{

    @Autowired
    private ClientTransferMapper clientTransferMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * @param record
     * @return
     */
    public int insert(ClientTransfer record,Long newEmpl) {
        Employee employee = employeeMapper.selectByPrimaryKey(newEmpl);
        record.setNewEmpl(employee);
      
        record.setTransferTime(new Date());
       
        record.setOperationEmpl(UserContext.getCurrentUser().getUsername());

        clientTransferMapper.insert(record);
        return 0;
    }

    public PageResult query(TransferQueryObject qo) {

        Integer count = clientTransferMapper.queryForCount(qo);
        if (count == 0) {
            return PageResult.EMPTY_PAGE;
        }
        List<?> list = clientTransferMapper.queryForList(qo);
        return new PageResult(list,count);
    }
}
