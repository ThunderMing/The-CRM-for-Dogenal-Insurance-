package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.mapper.SalesChartMapper;
import CRM_Donegal.Donegal_CRM.query.SalesChartQueryObject;
import CRM_Donegal.Donegal_CRM.service.ISalesChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SalesChartService implements ISalesChartService {
    @Autowired
    private SalesChartMapper chartMapper;

    @Override
    public List<Map<String, Object>> SalesChartQuery(SalesChartQueryObject qo) {
        return chartMapper.salesChartQuery(qo);
    }
}
