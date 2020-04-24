package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.query.SalesChartQueryObject;

import java.util.List;
import java.util.Map;

public interface ISaleChartGraphService {
    List<Map<String, Object>> saleByBar(SalesChartQueryObject qo);

    List<Map<String, Object>> saleByPie(SalesChartQueryObject qo);
}
