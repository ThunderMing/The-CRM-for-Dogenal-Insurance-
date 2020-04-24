package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.Mission;
import CRM_Donegal.Donegal_CRM.query.MissionQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;

import java.util.List;

/**
 * TASK MANAGEMENT - Mapper
 * Thunder Lei
 * 5.7
 */
public interface MissionMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Mission record);

    Mission selectByPrimaryKey(Long id);

    List<Mission> selectAll();

    int updateByPrimaryKey(Mission record);

    /**
     * change the status of task into done
     * @param id
     */
    void changeState(Long id);

    /**
     * advanced query 
     * @param qo 
     * @return
     */
    Integer queryForCount(MissionQueryObject qo);

    List<?> queryForList(MissionQueryObject qo);
}