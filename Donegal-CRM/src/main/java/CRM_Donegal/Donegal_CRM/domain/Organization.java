package CRM_Donegal.Donegal_CRM.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


/**
 * Object:the information of insurance institution 
 * Author: Thunder Lei
 */
@Getter
@Setter
public class Organization {
    private Long id;
    
    private String sn;
   
    private String name;
    
    private String legalPerson;
    
    private String idcar;
   
    private String tel;
    
    private String location;
    
    private Boolean saleStatus;
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

}