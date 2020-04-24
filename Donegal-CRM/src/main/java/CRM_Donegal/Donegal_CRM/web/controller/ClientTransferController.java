package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.ClientTransfer;
import CRM_Donegal.Donegal_CRM.query.TransferQueryObject;
import CRM_Donegal.Donegal_CRM.service.IClientTransferService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("clientTransfer")
public class ClientTransferController {

    @Autowired
    private IClientTransferService clientTransferService;

    @RequestMapping("view")
    public String view(){

        return "client/clientTransfer";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(TransferQueryObject qo){

        return clientTransferService.query(qo);

    }

    @RequestMapping("save")
    @ResponseBody
    public JSONResult saveOrUpdate(ClientTransfer ct,Long newEmplId){

        JSONResult json = new JSONResult();
        try{
           clientTransferService.insert(ct,newEmplId);
       }catch (Exception e){
           e.printStackTrace();
           return json.mark(e.getMessage());
       }
        return json;
    }

}
