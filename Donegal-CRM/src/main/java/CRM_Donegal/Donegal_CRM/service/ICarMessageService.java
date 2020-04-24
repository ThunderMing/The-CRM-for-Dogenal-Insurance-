package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.CarMessage;
import CRM_Donegal.Donegal_CRM.query.CarMessageQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

/**
 * Object: the formation of cars
 * Author: Thunder Lei
 */
public interface ICarMessageService {

    void saveOrUpdate(CarMessage entity);
    
    void delete(Long id);

    CarMessage get(Long id);

    List<CarMessage> selectAll();

    PageResult query(CarMessageQueryObject qo);

}
