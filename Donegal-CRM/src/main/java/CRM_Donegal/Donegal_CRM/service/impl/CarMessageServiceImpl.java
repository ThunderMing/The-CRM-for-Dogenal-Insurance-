package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.CarMessage;
import CRM_Donegal.Donegal_CRM.mapper.CarMessageMapper;
import CRM_Donegal.Donegal_CRM.query.CarMessageQueryObject;
import CRM_Donegal.Donegal_CRM.service.ICarMessageService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Objedct: The Information of Cars
 * Author: Thunder Lei
 */
@Service
public class CarMessageServiceImpl implements ICarMessageService {
    @Autowired
    CarMessageMapper carMessageMapper;

    @Override
    public void saveOrUpdate(CarMessage entity) {
        if (entity.getId() == null) {
            carMessageMapper.insert(entity);
        } else {
            carMessageMapper.updateByPrimaryKey(entity);
        }
    }

    public void delete(Long id) {
        carMessageMapper.deleteByPrimaryKey(id);
    }

    public CarMessage get(Long id) {
        return carMessageMapper.selectByPrimaryKey(id);
    }

    public List<CarMessage> selectAll() {
        return carMessageMapper.selectAll();
    }

    @Override
    public PageResult query(CarMessageQueryObject qo) {
        Integer total = carMessageMapper.queryForCount(qo);
        if (total > 0) {
            return new PageResult(carMessageMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }

}
