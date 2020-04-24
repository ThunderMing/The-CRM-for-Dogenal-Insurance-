package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.ProductInformation;
import CRM_Donegal.Donegal_CRM.query.ProductInformationQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

/**
 *Object: The Information of Institution Product
 * Author: Thunder Lei
 */
public interface IProductInformationService {

    void saveOrUpdate(ProductInformation entity);
    
    void delete(Long id);

    ProductInformation get(Long id);

    List<ProductInformation> selectAll();

    PageResult query(ProductInformationQueryObject qo);

    List<ProductInformation> selectByOranication(Long id);
}
