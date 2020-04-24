package CRM_Donegal.Donegal_CRM.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Attendance Management 
 * Thunder Lei
 * Jan,2020
 */
@Getter
@Setter
public class Signed {
    private Long id;
    
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date checkTime;
    
    private String empRealname;
    
    private String deptName;
    
    @JsonFormat(pattern="HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern="HH:mm:ss")
    private Date startWork;
    
    @JsonFormat(pattern="HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern="HH:mm:ss")
    private Date offWork;
    
    private Boolean state;
    
    private Long empId;

	public Date getCheckTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getStartWork() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}

	public void setCheckTime(Date checkTime2) {
		// TODO Auto-generated method stub
		
	}

	public void setEmpRealname(String realname) {
		// TODO Auto-generated method stub
		
	}

	public void setDeptName(String deptName2) {
		// TODO Auto-generated method stub
		
	}

	public void setStartWork(Date startWork2) {
		// TODO Auto-generated method stub
		
	}

	public void setState(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setEmpId(Long empId2) {
		// TODO Auto-generated method stub
		
	}

	public void setOffWork(Date date) {
		// TODO Auto-generated method stub
		
	}
}