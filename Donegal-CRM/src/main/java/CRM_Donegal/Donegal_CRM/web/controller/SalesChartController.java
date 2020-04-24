package CRM_Donegal.Donegal_CRM.web.controller;
import CRM_Donegal.Donegal_CRM.query.SalesChartQueryObject;
import CRM_Donegal.Donegal_CRM.service.ISalesChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The Form of Sale Reports
 * Thunder Lei
 */
@Controller
@RequestMapping("salesChart")
public class SalesChartController {
    @Autowired
    private ISalesChartService salesChartService;

    @RequestMapping("view")
    public String view() {
        return "chart/salesChart";
    }

    @RequestMapping("query")
    @ResponseBody
    public Object query(SalesChartQueryObject qo) {
        return salesChartService.SalesChartQuery(qo);
    }
}
