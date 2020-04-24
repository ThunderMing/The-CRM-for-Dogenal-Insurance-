package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.CarMessage;
import CRM_Donegal.Donegal_CRM.query.CarMessageQueryObject;
import CRM_Donegal.Donegal_CRM.service.ICarMessageService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * The Information of Cars
 * Author: Thunder Lei
 */
@Controller
@RequestMapping("carMessage")
public class CarMessageController {
    @Autowired
    ICarMessageService carMessageService;

    @RequestMapping("view")
    @RequiresPermissions({"carMessage:view","The page of Car Information"})
    public String view(){
        return "information/carMessage";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(CarMessageQueryObject qo){
        PageResult query = carMessageService.query(qo);
        return query;
    }

    @RequestMapping("selectAll")
    @ResponseBody
    public Object selectAll(){
        List<CarMessage> car = carMessageService.selectAll();
        return car;
    }

    @RequestMapping("saveOrUpdate")
    @RequiresPermissions({"carMessage:saveOrUpdate","The adding and Modification of car information"})
    @ResponseBody
    public Object saveOrUpdate(CarMessage entity){
        try {
            carMessageService.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }
}
