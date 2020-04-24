package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.DictionaryDir;
import CRM_Donegal.Donegal_CRM.query.QueryObject;

import java.util.List;

public interface DictionaryDirMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DictionaryDir record);

    DictionaryDir selectByPrimaryKey(Long id);

    List<DictionaryDir> selectAll();

    int updateByPrimaryKey(DictionaryDir record);

    /**
     * pagination and advanced query
     * @param qo
     * @return
     */
    Integer queryForCount(QueryObject qo);
    List<?> queryForList(QueryObject qo);

    /**
     * 
     * @param id
     */
    void deleteByItemRelation(Long dirId);

    /**
     * 
     * @param sn
     * @return
     */
    DictionaryDir selectBySn(String sn);
}