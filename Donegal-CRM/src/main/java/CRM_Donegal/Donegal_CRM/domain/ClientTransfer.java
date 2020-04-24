package CRM_Donegal.Donegal_CRM.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class ClientTransfer {
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date transferTime;

    private String operationEmpl;//the name of operation employee

    private String clientName;//the name of customer 

    private String originallyEmpl;//employee for marketing 

    private Employee newEmpl;//new employee for marketing 

    private String reason;//the reason for transferring 

	public void setNewEmpl(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	public void setTransferTime(Date date) {
		// TODO Auto-generated method stub
		
	}

	public void setOperationEmpl(byte[] username) {
		// TODO Auto-generated method stub
		
	}


}