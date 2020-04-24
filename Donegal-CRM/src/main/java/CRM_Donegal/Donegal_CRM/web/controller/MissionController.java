package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.Mission;
import CRM_Donegal.Donegal_CRM.query.MissionQueryObject;
import CRM_Donegal.Donegal_CRM.service.IMissionService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Task Management Controller
 * Thunder Lei
 */
@Controller
@RequestMapping("mission")
public class MissionController {
    @Autowired
    IMissionService missionService;

    /**
     * The interface of Task Management 
     * @return
     */
    @RequestMapping("view")
    public String view(){
        return "staff/mission";
    }

    /**
     * @param qo
     * @return
     */
    @RequestMapping("query")
    @ResponseBody
    public Object query(MissionQueryObject qo){
        return missionService.query(qo);
    }

    /**
     * Add and Modify 
     * @param entity
     * @return
     */
    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Mission entity){
        try {
            missionService.saveOrUpdate(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }

    /**
     * @param id
     * @return
     */
    @RequestMapping("changeState")
    @ResponseBody
    public Object changeState(Long id){
        if (id == null) {
            return new JSONResult().mark("Parameters Error!");
        }
        try {
            missionService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }
}
