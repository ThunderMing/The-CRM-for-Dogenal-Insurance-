package CRM_Donegal.Donegal_CRM.mapper;


import CRM_Donegal.Donegal_CRM.query.CostsChartQueryObject;

import java.util.List;
import java.util.Map;

public interface CostsChartMapper {

    List<Map<String, Object>> costsChartQuery(CostsChartQueryObject qo);
}
