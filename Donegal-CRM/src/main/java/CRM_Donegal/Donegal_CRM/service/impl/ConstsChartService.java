package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.mapper.CostsChartMapper;
import CRM_Donegal.Donegal_CRM.query.CostsChartQueryObject;
import CRM_Donegal.Donegal_CRM.service.ICostsChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConstsChartService implements ICostsChartService {
    @Autowired
    private CostsChartMapper chartMapper;

    @Override
    public List<Map<String, Object>> costsChartQuery(CostsChartQueryObject qo) {
        return chartMapper.costsChartQuery(qo);
    }

    @Override
    public List<Map<String, Object>> costsByBar(CostsChartQueryObject qo) {
        return chartMapper.costsChartQuery(qo);
    }

    @Override
    public List<Map<String, Object>> costsByPie(CostsChartQueryObject qo) {
        return chartMapper.costsChartQuery(qo);
    }
}
