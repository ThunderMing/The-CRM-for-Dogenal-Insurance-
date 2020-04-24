package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Department;
import CRM_Donegal.Donegal_CRM.domain.DevelClient;
import CRM_Donegal.Donegal_CRM.query.DevelClientQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDevelClientService {
    int deleteByPrimaryKey(Long id);

    int insert(DevelClient record);

    DevelClient selectByPrimaryKey(Long id);

    List<DevelClient> selectAll();

    /**
     * @param id
     * @param result
     */
    void updateResult(Long id, String result);


    int updateByPrimaryKey(DevelClient record);

    /**
     * @param qo
     * @return
     */
    PageResult query(DevelClientQueryObject qo);

}
