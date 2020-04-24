package CRM_Donegal.Donegal_CRM.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * Salary Management 
 * Thunder Lei
 * Jan, 2020
 */


@Getter
@Setter
public class Salary {
    private Long id;
    
    private Long salary;
    
    private Long bouns;
    
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date balancedate;
 
    private Long totalsalary;
   
    private Integer latecount;
    
    private Long empId;
    
    private Long deptId;
    
    private String empName;
    
    private String empTel;
    
    private String empEmail;
    
    private String deptName;

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getEmpName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Date getBalancedate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEmpId(Object object) {
		// TODO Auto-generated method stub
		
	}

	public void setLatecount(int count) {
		// TODO Auto-generated method stub
		
	}

	public void setTotalsalary(long l) {
		// TODO Auto-generated method stub
		
	}

	

	public Object getBouns() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setEmpEmail(Object email) {
		// TODO Auto-generated method stub
		
	}

	public int getSalary() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setDeptId(Object id2) {
		// TODO Auto-generated method stub
		
	}

	public void setDeptName(Object name) {
		// TODO Auto-generated method stub
		
	}
}