package CRM_Donegal.Donegal_CRM.query;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Claim
 */
@Getter
@Setter
public class CostsChartQueryObject extends QueryObject {
    private Long safetymechanismId;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String groupType="e.realname";


}
