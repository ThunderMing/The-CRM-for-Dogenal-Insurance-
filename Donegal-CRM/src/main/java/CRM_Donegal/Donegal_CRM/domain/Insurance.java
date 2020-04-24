package CRM_Donegal.Donegal_CRM.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Setter
@Getter
public class Insurance {
    
    public static final Integer BILL_OK = 0;   
    public static final Integer BILL_MOMENT_STORE = 1; 
    public static final Integer BILL_AUDI_WAIT = 2; 
    public static final Integer BILL_AUDI_BACK = 3; 
    public static final Integer BILL_PAY_WAIT = 4; 
    public static final Integer BILL_EDIT_AUDIT_WAIT = 5; 
    public static final Integer BILL_EDIT_AUDIT_BACK = 6; 
    public static final Integer BILL_EDIT_AUDIT_OK = 7; 
  
    public static final String PAY_FOR_POST = "POST MACHINE";
    public static final String PAY_FOR_CHECK = "CHECK";
    
    public static final Integer PAY_NO = 0;
    public static final Integer PAY_OK = 1;

    private Long id;

    private Client client; 

    private CarMessage car;  

    private List<ProductInformation> products; 

    private Organization organization; 

    private String applysn;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date applytime; 

    private BigDecimal amount;  

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date audittime; 

    private String paytype; 

    private Integer paystatus = BILL_PAY_WAIT;   

    private String billsn;  

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date starttime; 

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endtime;   

    private Integer billstatus;  

    private Employee inputer;   

    private Employee auditor;   

    private String message;
	public Object getProducts;

	public Client getClient() {
		// TODO Auto-generated method stub
		return null;
	}

	public CarMessage getCar() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setBillstatus(Integer billMomentStore) {
		// TODO Auto-generated method stub
		
	}

	public void setAmount(BigDecimal amount2) {
		// TODO Auto-generated method stub
		
	}

	public void setApplysn(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setApplytime(Date date) {
		// TODO Auto-generated method stub
		
	}

	public void setInputer(Employee currentUser) {
		// TODO Auto-generated method stub
		
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getBillstatus() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getApplysn() {
		// TODO Auto-generated method stub
		return null;
	}

	

}