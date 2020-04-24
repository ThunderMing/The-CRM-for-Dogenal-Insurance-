package CRM_Donegal.Donegal_CRM.service.impl;

import CRM_Donegal.Donegal_CRM.domain.DictionaryDirItem;
import CRM_Donegal.Donegal_CRM.mapper.DictionaryDirItemMapper;
import CRM_Donegal.Donegal_CRM.mapper.DictionaryDirMapper;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.service.IDictionaryDirItemService;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DictionaryDirItemServiceImpl implements IDictionaryDirItemService {
    @Autowired
    DictionaryDirItemMapper itemMapper;

    @Override
    public void saveOrUpdate(DictionaryDirItem entity) {
        if (entity.getId() == null) {
            itemMapper.insert(entity);
        } else {
            itemMapper.updateByPrimaryKey(entity);
        }
    }

    @Override
    public void delete(Long id) {
        itemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public DictionaryDirItem get(Long id) {
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DictionaryDirItem> selectAll() {
        return itemMapper.selectAll();
    }

    @Override
    public PageResult query(QueryObject qo) {
        Integer total = itemMapper.queryForCount(qo);
        if (total > 0) {
            return new PageResult(itemMapper.queryForList(qo), total);
        }
        return PageResult.EMPTY_PAGE;
    }

    @Override
    public List<DictionaryDirItem> selectByDirSn(String sn) {
        /*
          
		If sn has a value, the list found from the database has a value, 
		but the detected only encapsulates the dir object in the item
        The attributes in the item have no value, so the processing is as follow:
         */
        List<DictionaryDirItem> items = itemMapper.selectByDirSn(sn);
        if (items.size() > 0 && items.get(0).getId() != null) {
            return items;
        }
        return new ArrayList<>();
    }
}
