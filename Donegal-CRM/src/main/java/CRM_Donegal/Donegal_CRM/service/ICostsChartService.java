package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.query.CostsChartQueryObject;

import java.util.List;
import java.util.Map;

public interface ICostsChartService {
    List<Map<String, Object>> costsByBar(CostsChartQueryObject qo);

    List<Map<String, Object>> costsByPie(CostsChartQueryObject qo);

    List<Map<String, Object>> costsChartQuery(CostsChartQueryObject qo);
}
