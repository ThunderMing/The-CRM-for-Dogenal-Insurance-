package CRM_Donegal.Donegal_CRM.domain;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Task Management 
 * Thunder Lei
 * Jan, 2020
 */

@Getter
@Setter
public class Mission {
    private Long id;
    
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;
    
    private String name;
    
    private String dept;
    
    private Long missionId;
    
    private Boolean state;
    
    private String place;
    
    private String info;

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDept(String dept2) {
		// TODO Auto-generated method stub
		
	}

	public void setState(boolean b) {
		// TODO Auto-generated method stub
		
	}
}