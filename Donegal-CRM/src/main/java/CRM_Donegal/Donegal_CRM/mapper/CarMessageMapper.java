package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.CarMessage;
import CRM_Donegal.Donegal_CRM.query.CarMessageQueryObject;

import java.util.List;

public interface CarMessageMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CarMessage record);

    CarMessage selectByPrimaryKey(Long id);

    List<CarMessage> selectAll();

    int updateByPrimaryKey(CarMessage record);

    Integer queryForCount(CarMessageQueryObject qo);

    List<?> queryForList(CarMessageQueryObject qo);

	CarMessage selectByPrimaryKey(Object id);
}