package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.Organization;
import CRM_Donegal.Donegal_CRM.mapper.OrganizationMapper;
import CRM_Donegal.Donegal_CRM.query.OrganizationQueryObject;
import CRM_Donegal.Donegal_CRM.service.IOrganizationService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Object: Institution Information
 */
@Service
public class OrganizationServiceImpl implements IOrganizationService {
    @Autowired
    OrganizationMapper organizationMapper;

    @Override
    public List<Organization> selectAll() {
        return organizationMapper.selectAll();
    }

    @Override
    public void saveOrUpdate(Organization entity) {
        if (entity.getId() == null) {
            organizationMapper.insert(entity);
        } else {
            organizationMapper.updateByPrimaryKey(entity);
        }
    }

    @Override
    public void delete(Long id) {
        organizationMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Organization get(Long id) {
        return organizationMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult query(OrganizationQueryObject qo) {
        Integer total = organizationMapper.queryForCount(qo);
        if (total > 0) {
            List<?> objects = organizationMapper.queryForList(qo);
            return new PageResult(organizationMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }

}
