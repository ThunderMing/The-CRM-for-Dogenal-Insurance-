package CRM_Donegal.Donegal_CRM.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * the form of reporting 
 * Author: Thunder Lei
 * The function: settlement of claims
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Case {
    //
    public static final Boolean IS_BLAME = true;//it is responsible party
    public static final Boolean NOT_BLAME = false;//not responsible party 
   
    public static final Integer HAS_APPLY = 1;
    public static final Integer HAS_CHECK = 2;
    public static final Integer HAS_AUDIT = 3;
    public static final Integer INVALID = 5;
    public static final Integer WITHOUT_PAY = 6;

    private Long id;

    private Long insuranceId;//relevant insurance ID 

    private Insurance insurance;//object for the relevant insurance: check the insurance 

    private String reporter;// the person for reporting 

    private String phone;// contact phone

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date caseTime;//case time 

    private String location;//accident place

    private String carNumber;//car plate number 

    private Integer status = HAS_APPLY;//the process of the reporting 

    private Boolean blame;//blame or not 

    private BigDecimal lossamount;//the amount of loss 

    private String remark;//the description of the accident

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}


}