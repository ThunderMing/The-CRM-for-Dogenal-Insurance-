package CRM_Donegal.Donegal_CRM.mapper;
import CRM_Donegal.Donegal_CRM.query.SalesChartQueryObject;

import java.util.List;
import java.util.Map;

/**
 * unfinished 
 */
public interface SalesChartMapper {

    List<Map<String, Object>> salesChartQuery(SalesChartQueryObject qo);
}
