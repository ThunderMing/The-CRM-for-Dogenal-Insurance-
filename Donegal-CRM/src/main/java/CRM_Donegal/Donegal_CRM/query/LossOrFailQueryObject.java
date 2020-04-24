package CRM_Donegal.Donegal_CRM.query;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter@Getter
public class LossOrFailQueryObject extends QueryObject{

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date biginTime;//开始创建时间

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT-8")
    private Date endTime;//末尾时间

    private String clientName;//客户

    private String dutyEmpl;//负责人

    private Boolean state;//状态

    public String getClientName(){

        return empty2null(clientName);
    }

    public String getDutyEmpl(){

        return empty2null(dutyEmpl);
    }
}
