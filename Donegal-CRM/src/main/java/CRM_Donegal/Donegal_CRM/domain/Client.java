package CRM_Donegal.Donegal_CRM.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;


@Getter@Setter
public class Client {

    public static final Integer ZERO = 0;
    public static final Integer ONE = 1;
    public static final Integer TWO = 2;


    private Long id;

    private String name;//name 

    private Integer age;//age

    private Boolean sex;//gender

    private String salaryLevel;//salary

    private String email;//email

    private Integer phone;//phone number 

    private String address;//address

    private String source;//source 

    private String qq;// Tecent 

    private String weChat;//Wechat 

    private String clientId;//ID 

    private String job;//Occupies of customer 

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date biginDate;//the date of creating customer 

    private Integer state = ZERO;//the status of customers(potential customer by default)

    private Employee foundEmpl;//the creator for customer 

    private Employee dutyEmpl;//managers for the customers - employee

	public void setFoundEmpl1(Employee currentUser) {
		// TODO Auto-generated method stub
		
	}

	public void setBiginDate(Integer two2) {
		// TODO Auto-generated method stub
		
	}

	public void setFoundEmpl(Employee currentUser) {
		// TODO Auto-generated method stub
		
	}

	

	public void setBiginDate1(Integer one2) {
		// TODO Auto-generated method stub
		
	}

	public void setBiginDate1Date(Integer one2) {
		// TODO Auto-generated method stub
		
	}

	public void setBiginDate(Date date) {
		// TODO Auto-generated method stub
		
	}

	public Integer getState1() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getState() {
		// TODO Auto-generated method stub
		return null;
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}


}