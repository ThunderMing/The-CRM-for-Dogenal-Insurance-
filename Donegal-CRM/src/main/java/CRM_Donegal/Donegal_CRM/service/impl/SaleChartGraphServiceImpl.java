package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.mapper.SalesChartMapper;
import CRM_Donegal.Donegal_CRM.query.SalesChartQueryObject;
import CRM_Donegal.Donegal_CRM.service.ISaleChartGraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 
Sales report graphical interface
 */
@Service
public class SaleChartGraphServiceImpl implements ISaleChartGraphService {
    @Autowired
    private SalesChartMapper chartMapper;

    @Override
    public List<Map<String, Object>> saleByBar(SalesChartQueryObject qo) {
            return chartMapper.salesChartQuery(qo);
    }

    @Override
    public List<Map<String, Object>> saleByPie(SalesChartQueryObject qo) {
        return chartMapper.salesChartQuery(qo);
    }
}
