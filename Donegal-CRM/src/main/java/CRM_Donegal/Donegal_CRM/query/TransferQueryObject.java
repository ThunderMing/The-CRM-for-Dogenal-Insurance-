package CRM_Donegal.Donegal_CRM.query;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class TransferQueryObject extends QueryObject{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date biginTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date endTime;

    private String operationEmpl;

    private String clientName;

    private String originallyEmpl;

    private String newEmpl;

    public String getOperationEmpl(){

        return empty2null(operationEmpl);
    }

    public String getClientName(){

        return empty2null(clientName);
    }

    public String getOriginallyEmpl(){

        return empty2null(originallyEmpl);
    }

    public String getNewEmpl(){

        return empty2null(newEmpl);
    }


}
