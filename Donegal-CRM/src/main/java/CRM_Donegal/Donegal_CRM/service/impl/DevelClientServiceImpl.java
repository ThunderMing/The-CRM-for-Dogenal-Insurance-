package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Client;
import CRM_Donegal.Donegal_CRM.domain.DevelClient;
import CRM_Donegal.Donegal_CRM.mapper.ClientMapper;
import CRM_Donegal.Donegal_CRM.mapper.DevelClientMapper;
import CRM_Donegal.Donegal_CRM.query.DevelClientQueryObject;
import CRM_Donegal.Donegal_CRM.service.IDevelClientService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import CRM_Donegal.Donegal_CRM.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DevelClientServiceImpl implements IDevelClientService {

    @Autowired
    private DevelClientMapper develClientMapper;
    @Autowired
    private ClientMapper clientMapper;


    public int deleteByPrimaryKey(Long id) {

        return develClientMapper.deleteByPrimaryKey(id);
    }

    /**
     * Functions to be improved 
     * @param record
     * @return
     */
    public int insert(DevelClient record) {

       
        Long id = record.getClient().getId();
        Client client = clientMapper.selectByClient(id);
        
        if (client.getState() == Client.ONE ) {
          
            record.setStatus(DevelClient.FORMAL);
        }else if(client.getState() == Client.ZERO){
            
            record.setStatus(DevelClient.POTENTIAL);
        }
        
        record.setFoundEmpl(UserContext.getCurrentUser());

        develClientMapper.insert(record);
        return 0;
    }

    public DevelClient selectByPrimaryKey(Long id) {

        return develClientMapper.selectByPrimaryKey(id);
    }

    public List<DevelClient> selectAll() {

        return develClientMapper.selectAll();
    }

    /**
     * @param id
     * @param result
     */
    public void updateResult(Long id, String result) {

        develClientMapper.updateResult(id,result);

    }

    /**
     * @param record
     * @return
     */
    public int updateByPrimaryKey(DevelClient record) {

      
        Long id = record.getClient().getId();
        Client client = clientMapper.selectByClient(id);
     
        if (client.getState() == Client.ONE ) {
          
            record.setStatus(DevelClient.FORMAL);
        }else if(client.getState() == Client.ZERO){
          
            record.setStatus(DevelClient.POTENTIAL);
        }

        develClientMapper.updateByPrimaryKey(record);
        return 0;
    }

    public PageResult query(DevelClientQueryObject qo) {

        Integer count = develClientMapper.queryForCount(qo);

        if (count==0) {
            return PageResult.EMPTY_PAGE;
        }
        List<?> list = develClientMapper.queryForList(qo);

        return new PageResult(list,count);
    }
}
