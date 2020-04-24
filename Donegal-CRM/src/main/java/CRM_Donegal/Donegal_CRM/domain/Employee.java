package CRM_Donegal.Donegal_CRM.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Employee {
    private Long id;

    private String username;

    private String realname;

    private String password;

    private String tel;

    private String email;

    private Department dept;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date hireDate;

   
    //if no pass parameters and use boolean, use package. 
    private Boolean state;

    private Boolean admin;

    List<Role> roles = new ArrayList<Role>();

	public boolean getAdmin() {
		// TODO Auto-generated method stub
		return false;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setState(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setPassword(String string) {
		// TODO Auto-generated method stub
		
	}

	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public String getRealname() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	public Department getDept() {
		// TODO Auto-generated method stub
		return null;
	}

	

	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getTel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
}