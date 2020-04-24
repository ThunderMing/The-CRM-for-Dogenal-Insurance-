package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.DictionaryDir;
import CRM_Donegal.Donegal_CRM.domain.DictionaryDirItem;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

public interface IDictionaryDirItemService {
    void saveOrUpdate(DictionaryDirItem entity);

    void delete(Long id);

    DictionaryDirItem get(Long id);

    List<DictionaryDirItem> selectAll();

    PageResult query(QueryObject qo);

    /**
     * @param sn
     * @return
     */
    List<DictionaryDirItem> selectByDirSn(String sn);
}
