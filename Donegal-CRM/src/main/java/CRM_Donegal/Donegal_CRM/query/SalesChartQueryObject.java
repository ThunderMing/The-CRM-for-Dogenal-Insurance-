package CRM_Donegal.Donegal_CRM.query;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Report
 */
@Getter
@Setter
public class SalesChartQueryObject extends QueryObject {
    private Long safetymechanismId;
    private Long productId;
    //@JsonFormat Used when processing the Json format from the background to the foreground
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")//pattern reset format,timezoner reset timezone
    //@DateTimeFormat Used when processing the foreground form to transfer parameters to the background
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    //@JsonFormat Used when processing the Json format from the background to the foreground
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GTM+8")//pattern reset format,timezone reset time zone
    //@DateTimeFormat Used when processing the foreground form to transfer parameters to the background
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    private String groupType="e.realname";
    private Long paystatus = 0l;
	public Object getGroupType() {
		// TODO Auto-generated method stub
		return null;
	}


}
