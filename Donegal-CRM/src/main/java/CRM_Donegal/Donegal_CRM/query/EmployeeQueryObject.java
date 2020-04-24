package CRM_Donegal.Donegal_CRM.query;


import CRM_Donegal.Donegal_CRM.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class EmployeeQueryObject extends QueryObject{
    private String keyword; 
    private Long deptId = -1L; 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date minHireDate; 
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date maxHireDate;

    public String getKeyword() {

        return empty2null(keyword);
    }

    /*
        Change the time at the end of enquiry onboarding 
        from 0 o'clock to 23 o'clock
     */
    public Date getMaxHireDate() {
        return DateUtil.getEndDate(maxHireDate);
    }
}
