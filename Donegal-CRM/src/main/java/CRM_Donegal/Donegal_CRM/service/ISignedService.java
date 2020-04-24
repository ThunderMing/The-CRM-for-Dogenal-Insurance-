package CRM_Donegal.Donegal_CRM.service;

import CRM_Donegal.Donegal_CRM.domain.Signed;
import CRM_Donegal.Donegal_CRM.query.SignedQueryObject;
import CRM_Donegal.Donegal_CRM.util.PageResult;

import java.text.ParseException;

/**
 * The Interface of Attendance Management
 * Thudner Lei
 * Jan, 2020
 */
public interface ISignedService {
    /**
     * The function of going to work and getting off work
     * @throws ParseException The parameter passed is abnormal
     */
    void startwork() throws ParseException;

    void offwork() throws ParseException;

    void delete(Long id);

    Signed get(Long id);

    /**
     * Advanced Query
     * @param qo
     * @return
     */
    PageResult query(SignedQueryObject qo);
}
