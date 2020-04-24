package CRM_Donegal.Donegal_CRM.query;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class ProductInformationQueryObject extends QueryObject{
  
    private String keyword;
   
    private Integer saleStatus = -1;
    
    private Integer deductionStatus = -1;
    public String getKeyword() {
        return empty2null(keyword);
    }

    public Integer getSaleStatus() {
        return empty2num(saleStatus);
    }
    
    public Integer getDeductionStatus() {
        return empty2num(deductionStatus);
    }
}
