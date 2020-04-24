package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.Signed;
import CRM_Donegal.Donegal_CRM.query.SignedQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * Attendance Management Mapper
 * Thunder Lei
 * Jan, 2020
 */

public interface SignedMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Signed record);

    Signed selectByPrimaryKey(Long id);

    List<Signed> selectAll();

    int updateOffWork(Signed record);
    /**
     *
     * @param qo 
     * @return
     */
    Integer queryForCount(SignedQueryObject qo);

    List<?> queryForList(SignedQueryObject qo);

    /**
     * Judge the status of today's punch card by employee id and punch time
     * @param empId 
     * @param checkTime 
     * @return
     */
    Signed selectStartwork(@Param("empId") Long empId,
                           @Param("checkTime") Date checkTime);

    /**
     * Judge the number of late arrivals this month 
     * based on the employee ’s real name punch time and punch status
     * @param checkTime 
     * @param empRealname 
     * @return
     */
    int selectAllLateCount(@Param("checkTime")Date checkTime,
                           @Param("empRealname")String empRealname);
}