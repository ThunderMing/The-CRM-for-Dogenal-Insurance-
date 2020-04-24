package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.domain.LossOrFail;
import CRM_Donegal.Donegal_CRM.query.LossOrFailQueryObject;
import CRM_Donegal.Donegal_CRM.service.ILossOrFailService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("lossOrFail")
public class LossOrFailController {

    @Autowired
    private ILossOrFailService lossOrFailService;

   
    @RequestMapping("loss")
    public String loss() {

        return "client/loss";
    }

    @RequestMapping("query")
    @ResponseBody
    public PageResult query(LossOrFailQueryObject qo) {

        return lossOrFailService.query(qo);
    }

   
    @RequestMapping("fail")
    public String fail() {

        return "client/fail";
    }

    @RequestMapping("save")
    @ResponseBody
    public JSONResult saveOrUpdate(LossOrFail lossOrFail) {
        JSONResult json = new JSONResult();
        try {
            lossOrFailService.insert(lossOrFail);
        } catch (Exception e) {
            e.printStackTrace();
            return json.mark(e.getMessage());
        }
        return json;
    }

    @RequestMapping("save_loss")
    @ResponseBody
    public JSONResult save_loss(LossOrFail lossOrFail) {
        JSONResult json = new JSONResult();
        try {
            lossOrFailService.save_loss(lossOrFail);
        } catch (Exception e) {
            e.printStackTrace();
            return json.mark(e.getMessage());
        }
        return json;
    }


}
