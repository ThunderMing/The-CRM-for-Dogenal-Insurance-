package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.DictionaryDir;
import CRM_Donegal.Donegal_CRM.domain.DictionaryDirItem;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.IDictionaryDirItemService;
import CRM_Donegal.Donegal_CRM.service.IDictionaryDirService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
@RequestMapping("dictionary")
public class DictionaryController {
    @Autowired
    IDictionaryDirService dirService;
    @Autowired
    IDictionaryDirItemService itemService;

    @RequestMapping("view")
    public String view(){
        return "system/dictionary";
    }
    //--------------------//
    //     Object Method      //
    //=====================//
    @RequestMapping("query")
    @ResponseBody
    public Object query(QueryObject qo){
        return dirService.query(qo);
    }

    @RequestMapping("delete")
    @ResponseBody
    public Object delete(Long id){
        try{
            dirService.delete(id);
        } catch (Exception e){
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Object selectAll(){
        return dirService.selectAll();
    }

    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(DictionaryDir entity){
        try {
            dirService.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }

    //--------------------//
    //     Items Method      //
    //=====================//

    @RequestMapping("queryByDirSn")
    @ResponseBody
    public Object queryByDirSn(String sn){
        if(sn != null){
            return itemService.selectByDirSn(sn);
        }
        return new ArrayList<>();
    }

    @RequestMapping("saveOrUpdateItem")
    @ResponseBody
    public Object saveOrUpdateItem(DictionaryDirItem entity){
        try {
            itemService.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }

    @RequestMapping("deleteItem")
    @ResponseBody
    public Object deleteItem(Long id){
        try{
            itemService.delete(id);
        } catch (Exception e){
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }

}
