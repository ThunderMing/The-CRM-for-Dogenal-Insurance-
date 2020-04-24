package CRM_Donegal.Donegal_CRM.query;


import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.util.StringUtils;

@Setter@Getter
public class QueryObject {
   
    private int page = 1;
    
    private int rows = 10;
    
    private String sort;
   
    private String order;

    
    public int getStart() {
        return (page - 1) * rows;
    }

    protected String empty2null(String s){
        return StringUtils.hasLength(s) ? s : null;
    }

    protected Integer empty2num(Integer i){
        return i != null ? i : -1;
    }


}
