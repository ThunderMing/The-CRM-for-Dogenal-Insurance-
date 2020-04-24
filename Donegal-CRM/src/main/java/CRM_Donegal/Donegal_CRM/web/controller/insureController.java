package CRM_Donegal.Donegal_CRM.web.controller;
import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.query.ReviewQueryObject;
import CRM_Donegal.Donegal_CRM.query.WaitAndEditQueryObject;
import CRM_Donegal.Donegal_CRM.query.PayQueryObject;
import CRM_Donegal.Donegal_CRM.service.IInsureService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("insure")
public class insureController {
    @Autowired
    IInsureService insureService;

    @RequestMapping("view")
    public String view(){
        return "insure/insure";
    }


    @RequestMapping("saveOrUpdate")
    @ResponseBody
    public Object saveOrUpdate(Insurance insurance){
        String applysn = StringUtils.hasLength(insurance.getApplysn()) ? insurance.getApplysn() : null;
        try {
            if (applysn == null) {
                insureService.save(insurance);
            } else {
                insureService.update(insurance);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }

    @RequestMapping("queryWaitAndEdit")
    @ResponseBody
    public Object queryWaitAndEdit(WaitAndEditQueryObject qo){
        return insureService.queryWaitAndEdit(qo);
    }
    @RequestMapping("changeAsRollback")
    @ResponseBody
    public Object changeAsRollback(Long id){
        try {
            insureService.changeAsRollback(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }
    @RequestMapping("changeAsAudit")
    @ResponseBody
    public Object changeAsAudit(Long id){
        try {
            insureService.changeAsAudit(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONResult().mark(e.getMessage());
        }
        return new JSONResult();
    }


}
