package CRM_Donegal.Donegal_CRM.query;


import CRM_Donegal.Donegal_CRM.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Setter
@Getter
public class WaitAndEditQueryObject extends QueryObject {

    private Integer proId = -1;
    private Integer state = -1; 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxDate;  

   
    public Date getMaxDate() {
        return DateUtil.getEndDate(maxDate);
    }

   
    public Integer getProId() {
        return empty2num(proId);
    }
}
