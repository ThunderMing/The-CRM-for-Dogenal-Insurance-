package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.query.CostQueryObject;
import CRM_Donegal.Donegal_CRM.service.ICostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Deal with charge
 */
@Controller
@RequestMapping("costH")
public class CostQueryController {
    @Autowired
    private ICostService costService;

    @RequestMapping("view")
    public String view() {
        return "cost/cost";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(CostQueryObject qo) {
        return costService.query(qo);
    }
}
