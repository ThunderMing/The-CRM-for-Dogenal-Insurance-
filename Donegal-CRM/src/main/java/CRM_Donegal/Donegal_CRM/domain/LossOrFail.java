package CRM_Donegal.Donegal_CRM.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.patterns.PerFromSuper;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class LossOrFail {

    public static final Boolean LOSS = false;//the loss of customer/client
    public static final Boolean FAIL = true;//fail to development 

    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lossOrFailTime;//the reason of loss or failure of plan

    private String clientName;//Customer/client name

    private String dutyEmpl;//person in charge 

    private String reason;//reason

    private Boolean state;//loss or the failure of plan 

    private String phone;//the phone number of client/customer 

	public void setLossOrFailTime(Date date) {
		// TODO Auto-generated method stub
		
	}

	public void setState(Boolean fail2) {
		// TODO Auto-generated method stub
		
	}

}