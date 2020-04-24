package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Organization;
import CRM_Donegal.Donegal_CRM.query.OrganizationQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

/**
 * Object: Institution Information
 * Author: Thunder Lei
 */
public interface IOrganizationService {

    void saveOrUpdate(Organization entity);
    
    void delete(Long id);

    List<Organization> selectAll();

    Organization get(Long id);

    PageResult query(OrganizationQueryObject qo);

}
