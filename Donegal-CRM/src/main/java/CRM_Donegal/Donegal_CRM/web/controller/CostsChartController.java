package CRM_Donegal.Donegal_CRM.web.controller;

import CRM_Donegal.Donegal_CRM.query.CostsChartQueryObject;
import CRM_Donegal.Donegal_CRM.service.ICostsChartService;
import CRM_Donegal.Donegal_CRM.util.JSONUtil;
import CRM_Donegal.Donegal_CRM.util.MyDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The form of Claims
 * Author: THunder Lei
 */
@Controller
@RequestMapping("cost")
public class CostsChartController {
    @Autowired
    private ICostsChartService chartService;

    @RequestMapping("view")
    public String view() {
        return "/chart/costsChart";
    }

    
    @RequestMapping("query")
    @ResponseBody
    public Object query(CostsChartQueryObject qo) {
        return chartService.costsChartQuery(qo);
    }

        @RequestMapping("costByBar")
    public String costByBar(@ModelAttribute("qo") CostsChartQueryObject qo, Model model) {
        List<Object> x = new ArrayList<>();
        List<Object> y = new ArrayList<>();
        List<Map<String, Object>> list = chartService.costsByBar(qo);
        for (Map<String, Object> map : list) {
            x.add(map.get("groupType"));
            y.add(map.get("totalAmount"));
        }
        model.addAttribute("groupType", MyDictionary.SALE_MAP.get("e.name"));
        model.addAttribute("x", JSONUtil.toJSONString(x));
        model.addAttribute("y", JSONUtil.toJSONString(y));
        return "/chart/costByBar";
    }

   
    @RequestMapping("costByPie")
    public String costByPie(@ModelAttribute("qo") CostsChartQueryObject qo, Model model) {
        List<Object> x = new ArrayList<>();
        List<Object> y = new ArrayList<>();
        List<Map<String, Object>> list = chartService.costsByPie(qo);
        for (Map<String, Object> map : list) {
            x.add(map.get("groupType"));
            Map<String, Object> obj = new HashMap<>();
            obj.put("name", map.get("groupType"));
            obj.put("value", map.get("totalAmount"));
            y.add(obj);
        }
        model.addAttribute("groupType", MyDictionary.SALE_MAP.get("e.name"));
        model.addAttribute("x", JSONUtil.toJSONString(x));
        model.addAttribute("y", JSONUtil.toJSONString(y));
        return "/chart/costByPie";
    }
}
