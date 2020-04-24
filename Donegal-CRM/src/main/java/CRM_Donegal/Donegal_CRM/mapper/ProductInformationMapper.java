package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.ProductInformation;
import CRM_Donegal.Donegal_CRM.query.ProductInformationQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;

import java.util.List;

/**
 * Object: Institution Product mapper
 * Author: Thunder Lei
 */
public interface ProductInformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductInformation record);

    ProductInformation selectByPrimaryKey(Long id);

    List<ProductInformation> selectAll();

    int updateByPrimaryKey(ProductInformation record);

    /**
     * @param qo
     * @return
     */
    Integer queryForCount(ProductInformationQueryObject qo);

    /**
     * @param qo
     * @return
     */
    List<?> queryForList(ProductInformationQueryObject qo);

    /**
     * @param organitionId
     * @return
     */
    List<ProductInformation> selectByOranication(Long organitionId);
}