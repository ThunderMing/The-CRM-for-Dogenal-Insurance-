package CRM_Donegal.Donegal_CRM.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.weaver.patterns.PerFromSuper;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class DevelClient {

    public static final Boolean FORMAL = true;
    public static final Boolean POTENTIAL = false;

    private Long id;

    private String result;//the result of programme

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date planTime;//the date of plan 

    private Employee foundEmpl;//creator 

    private Client client;//customer 
    
    private String planTheme;//the theme of plan 

    private String mode;//programme 

    private String details;//specific details 

    private String remark;//note

    private Boolean status;//used as external keys 

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date follow_upTime;//the time of follow-up

    private String follow_upTheme;//the theme of follow-up

	public Employee getClient() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setStatus(Boolean formal2) {
		// TODO Auto-generated method stub
		
	}

	public void setFoundEmpl(Employee currentUser) {
		// TODO Auto-generated method stub
		
	}

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}


}