package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.DictionaryDir;
import CRM_Donegal.Donegal_CRM.domain.DictionaryDirItem;
import CRM_Donegal.Donegal_CRM.query.QueryObject;

import java.util.List;

public interface DictionaryDirItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DictionaryDirItem record);

    DictionaryDirItem selectByPrimaryKey(Long id);

    List<DictionaryDirItem> selectAll();

    int updateByPrimaryKey(DictionaryDirItem record);
    /**
     * pagination and advanced query
     * @param qo
     * @return
     */
    Integer queryForCount(QueryObject qo);
    List<?> queryForList(QueryObject qo);

    /**
     * query all the items of according to the sn of contents 
     * @param sn
     * @return
     */
    List<DictionaryDirItem> selectByDirSn(String sn);
}