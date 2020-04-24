package CRM_Donegal.Donegal_CRM.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class ClientQueryObejct extends QueryObject{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date biginTime;// begin to create time

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date endTime;//

    private String clientId;

    private String phone;

    private Integer state;

   

    private String  dutyEmplName;//According to the name of the person in charge

    private String keyword;//  ID card, mailbox, customer name


    public String getClientId(){

        return empty2null(clientId);
    }

    public String getPhone(){

        return empty2null(phone);
    }

    public String getKeyword(){

        return empty2null(keyword);
    }

    public String getDutyEmplName(){

        return empty2null(dutyEmplName);
    }


}
