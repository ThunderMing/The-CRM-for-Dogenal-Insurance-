package CRM_Donegal.Donegal_CRM.web.controller;


import CRM_Donegal.Donegal_CRM.domain.Client;
import CRM_Donegal.Donegal_CRM.query.ClientQueryObejct;
import CRM_Donegal.Donegal_CRM.service.IClientService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("client")
@SuppressWarnings("all")
public class ClientController {

    @Autowired
    private IClientService clientService;

  
    @RequestMapping("view")
    public String potentialClient(){

        return "client/potentialClient";
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Object selectAll(){
        return clientService.selectAll();
    }

   
    @RequestMapping("query")
    @ResponseBody
    public Object query(ClientQueryObejct qo){

        return clientService.query(qo);
    }
 
    @RequestMapping("formal")
    public String formalClient(){

        return "client/formalClient";
    }

    @RequestMapping("resourcePool")
    public String resourcePool(){

        return "client/resourcePool";
    }


    @RequestMapping("absorb")
    @ResponseBody
    public JSONResult absorb(Long id){
        JSONResult josn = new JSONResult();
        try{
            clientService.updateByState(id);
        }catch(Exception e){
            e.printStackTrace();
            josn.mark(e.getMessage());
        }
        return josn;
    }


    @RequestMapping("delete")
    @ResponseBody
    public JSONResult delete(Long id){
        JSONResult josn = new JSONResult();
        try{
            clientService.delete(id);
        }catch(Exception e){
            e.printStackTrace();
            josn.mark(e.getMessage());
        }
        return josn;
    }

 
    @RequestMapping("updateDutyEmpl")
    @ResponseBody
    public JSONResult updateDutyEmpl(Long id,Long cId){
        JSONResult json = new JSONResult();

        try {
            clientService.updateDutyEmpl(id,cId);
        }catch (Exception e){
            e.printStackTrace();
            return json.mark(e.getMessage());
        }
        return json;
    }


    @RequestMapping("moveResource")
    @ResponseBody
    public JSONResult moveResource(Long id){
        JSONResult josn = new JSONResult();
        try{
            clientService.updateByMoveResouce(id);
        }catch(Exception e){
            e.printStackTrace();
            josn.mark(e.getMessage());
        }
        return josn;
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public JSONResult saveOrUpdate(Client client){

        JSONResult json = new JSONResult();
        try{
            if (client.getId()== null) {
                clientService.insert(client);
            }else{
                clientService.updateByPrimaryKey(client);//(potential client)
            }
        }catch(Exception e){
            e.printStackTrace();
            return json.mark(e.getMessage());
        }
        return json;
    }

    @RequestMapping("saveOrUpdate1")
    @ResponseBody
    public JSONResult saveOrUpdate1(Client client){

        JSONResult json = new JSONResult();
        try{
            if (client.getId()== null) {
                clientService.insert(client);
            }else{
                clientService.updateByPrimaryKey1(client);//(formal client)
            }
        }catch(Exception e){
            e.printStackTrace();
            return json.mark(e.getMessage());
        }
        return json;
    }

    @RequestMapping("saveOrUpdate2")
    @ResponseBody
    public JSONResult saveOrUpdate2(Client client){

        JSONResult json = new JSONResult();
        try{
            if (client.getId()== null) {
                clientService.insert(client);
            }else{
                clientService.updateByPrimaryKey2(client);//the resource pool of client
            }
        }catch(Exception e){
            e.printStackTrace();
            return json.mark(e.getMessage());
        }
        return json;
    }

}
