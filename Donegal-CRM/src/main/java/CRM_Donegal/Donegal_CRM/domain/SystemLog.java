package CRM_Donegal.Donegal_CRM.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter@Getter
public class SystemLog {
    private Long id;

    private Employee opUser;

    private Date opTime;

    private String opIp;

    private String function;

    private String params;

	public void setOpTime(Date date) {
		// TODO Auto-generated method stub
		
	}

	public void setOpUser(Employee currentUser) {
		// TODO Auto-generated method stub
		
	}

	public void setOpIp1(String remoteAddr) {
		// TODO Auto-generated method stub
		
	}

	public void setFunction(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setOpIp(String remoteAddr) {
		// TODO Auto-generated method stub
		
	}

	public void setParams(String writeValueAsString) {
		// TODO Auto-generated method stub
		
	}

}