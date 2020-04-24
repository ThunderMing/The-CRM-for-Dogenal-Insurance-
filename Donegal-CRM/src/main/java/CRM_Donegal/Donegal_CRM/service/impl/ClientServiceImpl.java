package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Client;
import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.mapper.ClientMapper;
import CRM_Donegal.Donegal_CRM.mapper.EmployeeMapper;
import CRM_Donegal.Donegal_CRM.query.ClientQueryObejct;
import CRM_Donegal.Donegal_CRM.query.DevelClientQueryObject;
import CRM_Donegal.Donegal_CRM.service.IClientService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import CRM_Donegal.Donegal_CRM.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClientServiceImpl implements IClientService {

    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private EmployeeMapper employeeMapper;

    public int deleteByPrimaryKey(Long id) {

        return clientMapper.deleteByPrimaryKey(id);
    }

    /**
     * haven't written
     * @param record
     * @return
     */
    public int insert(Client record) {

   
        record.setFoundEmpl(UserContext.getCurrentUser());
   
        record.setFoundEmpl(UserContext.getCurrentUser());
     
        record.setBiginDate(new Date());

        clientMapper.insert(record);
        return 0;
    }

    public List<Client> selectAll() {

        return clientMapper.selectAll();
    }

    /**
     * Haven't recorded (potential client)
     * @param record
     * @return
     */
    public int updateByPrimaryKey(Client record) {

        clientMapper.updateByPrimaryKey(record);
        return 0;
    }

    /**
     * formal client
     * @param record
     * @return
     */
    public int updateByPrimaryKey1(Client record) {

        record.setBiginDate1Date(Client.ONE);
        clientMapper.updateByPrimaryKey(record);
        return 0;
    }

    /**
     * 
     * @param record
     * @return
     */
    public int updateByPrimaryKey2(Client record) {

        record.setBiginDate(Client.TWO);

        clientMapper.updateByPrimaryKey(record);
        return 0;
    }

    public PageResult query(ClientQueryObejct qo) {

        Integer count = clientMapper.queryForCount(qo);
        if(count == 0){
            return PageResult.EMPTY_PAGE;
        }

        List<?> list = clientMapper.queryForList(qo);

        return new PageResult(list,count);
    }

    /**
     * @param id
     */
    public void updateByState(Long id) {
        Client client = clientMapper.selectByClient(id);
     
        client.setBiginDate(new Date());
               client.setBiginDate(Client.ZERO);
  
        client.setFoundEmpl(UserContext.getCurrentUser());
        clientMapper.updateByState(client);
    }

    public void updateByMoveResouce(Long id) {

        Client client = clientMapper.selectByClient(id);
    
        client.setBiginDate(new Date());
        
        client.setBiginDate(Client.TWO);
        clientMapper.updateByMoveResouce(client);
    }

    public void updateDutyEmpl(Long id,Long cId) {

        Client client = clientMapper.selectByClient(cId);
       
        Employee employee = employeeMapper.selectByPrimaryKey(id);

        client.setFoundEmpl(employee);
        clientMapper.updateDutyEmpl(client);

    }

    public void delete(Long id) {
        clientMapper.deleteByPrimaryKey(id);
    }
}
