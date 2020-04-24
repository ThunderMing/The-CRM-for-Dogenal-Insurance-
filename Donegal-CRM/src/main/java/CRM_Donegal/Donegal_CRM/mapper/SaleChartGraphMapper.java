package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.query.SalesChartQueryObject;

import java.util.List;
import java.util.Map;

/**
 *
	Sales report graphics
 * mapper unfinished 
 */
public interface SaleChartGraphMapper {
    List<Map<String, Object>> saleByBar(SalesChartQueryObject qo);
    List<Map<String, Object>> saleByPie(SalesChartQueryObject qo);
}
