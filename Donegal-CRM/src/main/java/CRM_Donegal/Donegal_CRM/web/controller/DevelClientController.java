package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.DevelClient;
import CRM_Donegal.Donegal_CRM.query.DevelClientQueryObject;
import CRM_Donegal.Donegal_CRM.service.IDevelClientService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("develClient")
@SuppressWarnings("all")
public class DevelClientController {

    @Autowired
    private IDevelClientService develClientService;

    @RequestMapping("view")
    public String potentialClient(){

        return "client/develClient";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(DevelClientQueryObject qo){

        return develClientService.query(qo);
    }

    @RequestMapping("follow")
    public String formalClient(){

        return "client/followClient";
    }


   //The plan of delete
    @RequestMapping("delete")
    @ResponseBody
    public JSONResult delete(Long id){

        JSONResult json = new JSONResult();
        try{
           develClientService.deleteByPrimaryKey(id);
        }catch(Exception e){
            e.printStackTrace();
            return json.mark(e.getMessage());
        }
        return json;
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public JSONResult saveOrUpdate(DevelClient develClient){

        JSONResult json = new JSONResult();
        try{
            if (develClient.getId()== null) {
                develClientService.insert(develClient);
            }else{
                develClientService.updateByPrimaryKey(develClient);
            }
        }catch(Exception e){
            e.printStackTrace();
            return json.mark(e.getMessage());
        }
        return json;
    }

    @RequestMapping("updateResult")
    @ResponseBody
    public JSONResult updateResult(Long id,String result){
        JSONResult json = new JSONResult();
        try {
            develClientService.updateResult(id,result);
        }catch (Exception e){
            e.printStackTrace();
            return json.mark(e.getMessage());
        }
        return json;
    }

}
