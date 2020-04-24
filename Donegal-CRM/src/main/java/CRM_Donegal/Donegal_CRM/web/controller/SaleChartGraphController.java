package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.query.SalesChartQueryObject;
import CRM_Donegal.Donegal_CRM.service.ISaleChartGraphService;
import CRM_Donegal.Donegal_CRM.util.JSONUtil;
import CRM_Donegal.Donegal_CRM.util.MyDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Pie and Bar charts
 * Thunder Lei
 */
@Controller
@RequestMapping("chart")
public class SaleChartGraphController {
    @Autowired
    private ISaleChartGraphService chartService;

    //Bar Charts
    @RequestMapping("saleByBar")
    public String saleByBar(@ModelAttribute("qo") SalesChartQueryObject qo, Model model) {
        List<Object> x = new ArrayList<>();
        List<Object> y = new ArrayList<>();
        List<Map<String, Object>> list = chartService.saleByBar(qo);
        for (Map<String, Object> map : list) {
            x.add(map.get("groupType"));
            y.add(map.get("totalAmount"));
        }
        model.addAttribute("groupType", MyDictionary.SALE_MAP.get(qo.getGroupType()));
        model.addAttribute("x", JSONUtil.toJSONString(x));
        model.addAttribute("y", JSONUtil.toJSONString(y));
        return "chart/saleByBar";
    }

    //Pie Charts 
    @RequestMapping("saleByPie")
    public String saleByPie(@ModelAttribute("qo") SalesChartQueryObject qo, Model model) {
        List<Object> x = new ArrayList<>();
        List<Object> y = new ArrayList<>();
        List<Map<String, Object>> list = chartService.saleByPie(qo);
        for (Map<String, Object> map : list) {
            x.add(map.get("groupType"));
            Map<String, Object> obj = new HashMap<>();
            obj.put("name", map.get("groupType"));
            obj.put("value", map.get("totalAmount"));
            y.add(obj);
        }
        model.addAttribute("groupType", MyDictionary.SALE_MAP.get(qo.getGroupType()));
        model.addAttribute("x", JSONUtil.toJSONString(x));
        model.addAttribute("y", JSONUtil.toJSONString(y));
        return "chart/saleByPie";
    }
}
