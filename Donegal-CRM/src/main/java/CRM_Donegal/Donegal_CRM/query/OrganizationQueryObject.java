package CRM_Donegal.Donegal_CRM.query;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class OrganizationQueryObject extends QueryObject{
  
    private String keyword;
   
    private Integer saleStatus = -1;

    public String getKeyword() {
        return empty2null(keyword);
    }
}
