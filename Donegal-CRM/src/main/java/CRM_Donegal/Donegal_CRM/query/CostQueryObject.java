package CRM_Donegal.Donegal_CRM.query;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Charge inquiry
 */
@Getter
@Setter
public class CostQueryObject extends QueryObject {
    private String keyword;
    private String applysn;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    private Date begin;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT-8")
    private Date end;
    private Integer paystatus = 0;

    public String getKeyword() {
        return empty2null(keyword);
    }

    public String getApplysn() {
        return empty2null(applysn);
    }


}
