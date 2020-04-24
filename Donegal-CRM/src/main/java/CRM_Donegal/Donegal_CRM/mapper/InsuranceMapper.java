package CRM_Donegal.Donegal_CRM.mapper;

import CRM_Donegal.Donegal_CRM.domain.Insurance;
import CRM_Donegal.Donegal_CRM.query.CostQueryObject;
import CRM_Donegal.Donegal_CRM.query.PayQueryObject;
import CRM_Donegal.Donegal_CRM.query.QueryObject;
import CRM_Donegal.Donegal_CRM.query.ReviewQueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InsuranceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Insurance record);

    Insurance selectByPrimaryKey(Long id);

    List<Insurance> selectAll();

    int updateByPrimaryKey(Insurance record);

    /**
     * 
     *
     * @param qo
     * @return
     */
    Integer queryForCount(QueryObject qo);

    List<?> queryForList(QueryObject qo);

    /**
     * 
     * @param insuranceId
     * @param productId
     */
    void insertProductRelation(@Param("insuranceId") Long insuranceId,
                               @Param("productId")Long productId);
    void deleteProductRelation(Long insuranceId);

    /**
     * 
     *
     * @return
     */
    List<Insurance> selectByInsuranceAutit(ReviewQueryObject qo);

    /**
     * 
     *
     * @param insurecId  
     * @param billStatus 
     */
    void rollbackOrPass(@Param("billStatus") Integer billStatus,
                        @Param("insurecId") Long insurecId);

    /**
     * 
     *
     * @param massager 
     * @param insId    
     */
    void updateByMessager(@Param("massager") String massager,
                          @Param("ingId") Long insId);


    /**
     * 
     * 
     *
     * @return
     */
    List<Insurance> selectPayInfo();

    /**
     * 
     *
     * @param id
     */
    void changeState(Long id);

    /**
     * 
     *
     * @param qo
     * @return
     */
    Integer queryPayForCount(PayQueryObject qo);

    List<Insurance> queryPayForList(PayQueryObject qo);


    /**
     * 
     * 
     *
     * @return
     */
    List<Insurance> selectCostInfo();

    /**   
     * @param qo
     * @return
     */
    Integer queryCostForCount(CostQueryObject qo);

    List<Insurance> queryCostForList(CostQueryObject qo);

    /**
     * @param qo
     * @return
     */
    Integer queryWaitAndEditForCount(QueryObject qo);
    List<?> queryWaitAndEditForList(QueryObject qo);
    /**
     * 
     * 
     * @param billSn
     * @return
     */
    Insurance selectByPrimaryKeyForCase(Long billSn);

    /**
     * 
     * @param qo
     * @return
     */
    List<Insurance> selectPayInfoState(ReviewQueryObject qo);

    /**
     * @param id
     */
    void changeAsRollback(Long id);

    /**
     * @param id
     */
    void changeAsAudit(Long id);

    /**
     * @param record
     */
    void updateBillStatus(Insurance record);
}