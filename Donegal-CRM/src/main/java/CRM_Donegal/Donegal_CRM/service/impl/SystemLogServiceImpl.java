package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.SystemLog;
import CRM_Donegal.Donegal_CRM.mapper.SystemLogMapper;
import CRM_Donegal.Donegal_CRM.service.ISystemLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemLogServiceImpl implements ISystemLogService {
    @Autowired
    SystemLogMapper systemLogMapper;

    @Override
    public void insert(SystemLog systemLog) {
        systemLogMapper.insert(systemLog);
    }
}
