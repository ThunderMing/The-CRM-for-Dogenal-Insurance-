package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.Department;
import CRM_Donegal.Donegal_CRM.domain.DevelClient;
import CRM_Donegal.Donegal_CRM.query.DevelClientQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DevelClientMapper {

    int deleteByPrimaryKey(Long id);

    int insert(DevelClient record);

    DevelClient selectByPrimaryKey(Long id);

    List<DevelClient> selectAll();

    /**
     * mark the result
     * @param id
     * @param result
     */
    void updateResult(@Param("id")Long id,@Param("result") String result);

    int updateByPrimaryKey(DevelClient record);

    /**
     * check the amount
     * @param qo
     * @return
     */
    Integer queryForCount(DevelClientQueryObject qo);

    /**
     * pagination and query
     * @param qo
     * @return
     */
    List<?> queryForList(DevelClientQueryObject qo);
}
