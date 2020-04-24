package CRM_Donegal.Donegal_CRM.query;

import CRM_Donegal.Donegal_CRM.util.DateUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
public class CarMessageQueryObject extends QueryObject{
    private String keyword; 
    public String getKeyword() {
        return empty2null(keyword);
    }

}
