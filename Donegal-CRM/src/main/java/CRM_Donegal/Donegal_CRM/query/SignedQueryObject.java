package CRM_Donegal.Donegal_CRM.query;


import CRM_Donegal.Donegal_CRM.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
/**
 * Advanced Inquiry for Attendance Management 
 * Thunder Lei
 *Jan, 2020
 */
@Setter
@Getter
public class SignedQueryObject extends QueryObject{
    private String keyword;
    private String dept;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxDate;

    public String getKeyword() {
        return empty2null(keyword);
    }
    public String getDept() {
        return empty2null(dept);
    }

    
    public Date getMaxDate() {
        return DateUtil.getEndDate(maxDate);
    }
}
