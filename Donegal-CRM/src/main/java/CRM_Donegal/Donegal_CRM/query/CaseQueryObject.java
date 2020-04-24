package CRM_Donegal.Donegal_CRM.query;

import CRM_Donegal.Donegal_CRM.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class CaseQueryObject extends QueryObject{
    private String keyword; 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minDate; 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxDate;

    public String getKeyword() {

        return empty2null(keyword);
    }

    /*
        Change the time at the end of the inquiry report 
        from 0 o'clock to 23 o'clock
     */
    public Date getMaxHireDate() {
        return DateUtil.getEndDate(maxDate);
    }
}

