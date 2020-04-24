package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.query.SalesChartQueryObject;

import java.util.List;
import java.util.Map;

public interface ISalesChartService {

    List<Map<String, Object>> SalesChartQuery(SalesChartQueryObject qo);
}
