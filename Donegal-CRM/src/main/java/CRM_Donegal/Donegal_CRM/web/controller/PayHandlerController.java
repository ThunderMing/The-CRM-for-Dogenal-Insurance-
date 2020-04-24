package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.query.PayQueryObject;
import CRM_Donegal.Donegal_CRM.service.IPayService;
import CRM_Donegal.Donegal_CRM.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Payment Management
 */
@Controller
@RequestMapping("pay")
public class PayHandlerController {
    @Autowired
    private IPayService payService;

    @RequestMapping("view")
    public String view() {
        return "pay/pay";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(PayQueryObject qo) {
        return payService.query(qo);
    }

    @RequestMapping("changeState")
    @ResponseBody
    public JSONResult changeState(Long id) {
        JSONResult result = new JSONResult();
        try {
            payService.changeState(id);
        } catch (Exception e) {
            e.printStackTrace();
            return result.mark("Fail to make a payment!");
        }
        return result;
    }

}
