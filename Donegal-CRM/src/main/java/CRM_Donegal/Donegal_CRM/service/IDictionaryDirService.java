package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.DictionaryDir;
import CRM_Donegal.Donegal_CRM.domain.DictionaryDirItem;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.util.List;

public interface IDictionaryDirService {

    void saveOrUpdate(DictionaryDir entity);

    void delete(Long id);

    DictionaryDir get(Long id);

    List<DictionaryDir> selectAll();

    PageResult query(QueryObject qo);
}
