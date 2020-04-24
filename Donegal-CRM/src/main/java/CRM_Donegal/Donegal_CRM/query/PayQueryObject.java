package CRM_Donegal.Donegal_CRM.query;


import CRM_Donegal.Donegal_CRM.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *Advanced Payment Inquiry
 */
@Getter
@Setter
public class PayQueryObject extends QueryObject {
    private String keyword;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    private Date applytime;
    private Long payState = 4l;

    public String getKeyword() {
        return empty2null(keyword);
    }

    public Date getApplytime() {
        return DateUtil.getEndDate(applytime);
    }

}
