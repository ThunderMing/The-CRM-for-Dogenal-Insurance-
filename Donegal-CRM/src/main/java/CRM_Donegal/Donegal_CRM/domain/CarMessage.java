package CRM_Donegal.Donegal_CRM.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * the information of car
 * Author: Thunder Lei
 */
@Getter
@Setter
public class CarMessage {
    private Long id;

    private String username;
    
    private String name;
    
    private String sn;
    
    private String carNumber;
    
    private Long carExhaust;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd", timezone = "GMT+8")
    private Date buyDate;
   
    private Long marketPrice;
   
    private String classify;
        private String carTyoe;
   
    private String remark;
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

}