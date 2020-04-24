package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.Organization;
import CRM_Donegal.Donegal_CRM.query.OrganizationQueryObject;
import CRM_Donegal.Donegal_CRM.query.ProductInformationQueryObject;

import java.util.List;
/**
 * Object: insurance institution mapper
 * Author: Thunder Lei
 */
public interface OrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    Organization selectByPrimaryKey(Long id);

    List<Organization> selectAll();

    int updateByPrimaryKey(Organization record);

    /**
     * @param qo
     * @return
     */
    Integer queryForCount(OrganizationQueryObject qo);

    /**
     * @param qo
     * @return
     */
    List<?> queryForList(OrganizationQueryObject qo);
}