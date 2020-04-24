package CRM_Donegal.Donegal_CRM.query;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter@Setter
public class DevelClientQueryObject extends QueryObject{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date biginTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date endTime;

    private String queryClientName;//client/customer

    private String foundEmpl;//creator 

    private String planTheme;//Project theme

    private Boolean status;

    /**
     * This field has not been written yet, because there is no the table yet
     */
    private String mode;//project 

    public String getqueryClientName(){

        return empty2null(queryClientName);
    }

    public String getFoundEmpl(){

        return empty2null(foundEmpl);
    }

    public String getPlanTheme(){

        return empty2null(planTheme);
    }

}
