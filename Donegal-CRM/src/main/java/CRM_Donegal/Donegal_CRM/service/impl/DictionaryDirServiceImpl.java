package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.DictionaryDir;
import CRM_Donegal.Donegal_CRM.domain.DictionaryDirItem;
import CRM_Donegal.Donegal_CRM.mapper.DictionaryDirMapper;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.IDictionaryDirItemService;
import CRM_Donegal.Donegal_CRM.service.IDictionaryDirService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryDirServiceImpl implements IDictionaryDirService {
    @Autowired
    DictionaryDirMapper dirMapper;

    @Override
    public void saveOrUpdate(DictionaryDir entity) {
        if (entity.getId() == null) {
            
            DictionaryDir dir = dirMapper.selectBySn(entity.getSn());
            if(dir == null){
                dirMapper.insert(entity);
            } else {
                throw new RuntimeException("Cannot save the same catalog number repeatedly");
            }
        } else {
            dirMapper.updateByPrimaryKey(entity);
        }
    }

    @Override
    public void delete(Long id) {
     
        dirMapper.deleteByItemRelation(id);
        dirMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DictionaryDir get(Long id) {
        return dirMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DictionaryDir> selectAll() {
        return dirMapper.selectAll();
    }

    @Override
    public PageResult query(QueryObject qo) {
        Integer total = dirMapper.queryForCount(qo);
        if (total > 0) {
            return new PageResult(dirMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }
}
