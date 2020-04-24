package CRM_Donegal.Donegal_CRM.query;


import CRM_Donegal.Donegal_CRM.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Pending Insurance Documents to be honored
 * Author: Thunder Lei
 */
@Setter
@Getter
public class ReviewQueryObject extends QueryObject{

    private Integer proId = -1;
    private Integer billstatus = -1;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxDate;  

  
    private Integer paystatus;

    
    public Date getMaxDate() {
        return DateUtil.getEndDate(maxDate);
    }

    /*
        When the sales status is empty, it will return -1 or the value passed in
     */
    public Integer getProId() {
        return empty2num(proId);
    }
}
