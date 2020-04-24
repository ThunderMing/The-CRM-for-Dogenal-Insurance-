package CRM_Donegal.Donegal_CRM.service.impl;
import CRM_Donegal.Donegal_CRM.domain.Employee;
import CRM_Donegal.Donegal_CRM.domain.Organization;
import CRM_Donegal.Donegal_CRM.domain.ProductInformation;
import CRM_Donegal.Donegal_CRM.domain.Role;
import CRM_Donegal.Donegal_CRM.mapper.OrganizationMapper;
import CRM_Donegal.Donegal_CRM.mapper.ProductInformationMapper;
import CRM_Donegal.Donegal_CRM.query.ProductInformationQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.IOrganizationService;
import CRM_Donegal.Donegal_CRM.service.IProductInformationService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Object: The Product Information of Institution 
 * Author: Thunder Lei
 */
@Service
public class ProductInformationServiceImpl implements IProductInformationService {
    @Autowired
    ProductInformationMapper productInformationMapper;
    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public void saveOrUpdate(ProductInformation entity) {
        if(entity.getOrganizationId() != null){
            Organization organization = organizationMapper.selectByPrimaryKey(entity.getOrganizationId());
            entity.setOrganizationName(organization.getName());
        }
        if (entity.getId() == null) {
            productInformationMapper.insert(entity);
        } else {
            productInformationMapper.updateByPrimaryKey(entity);
        }
    }

    @Override
    public void delete(Long id) {
        productInformationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public ProductInformation get(Long id) {
        return productInformationMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(ProductInformationQueryObject qo) {
        Integer total = productInformationMapper.queryForCount(qo);
        if (total > 0) {
            return new PageResult(productInformationMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }

    @Override
    public List<ProductInformation> selectAll() {
        return productInformationMapper.selectAll();
    }

    @Override
    public List<ProductInformation> selectByOranication(Long id) {
        return productInformationMapper.selectByOranication(id);
    }

}
