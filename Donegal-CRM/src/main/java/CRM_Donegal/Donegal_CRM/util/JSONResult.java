package CRM_Donegal.Donegal_CRM.util;

import lombok.Getter;

@Getter
public class JSONResult {
    private boolean success = true;
    private String msg;


    public JSONResult mark(String msg){
        success = false;
        this.msg = msg;
        return this;
    }
}
