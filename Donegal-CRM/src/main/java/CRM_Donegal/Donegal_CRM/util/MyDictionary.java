package CRM_Donegal.Donegal_CRM.util;
import java.util.HashMap;
import java.util.Map;

public abstract class MyDictionary {
    public static final Map<String, Object> SALE_MAP = new HashMap<String, Object>();

    static {
        SALE_MAP.put("e.name", "salesman");
        SALE_MAP.put("p.organizationName", "Insurance Institution");
        SALE_MAP.put("p.organizationName", "Insurance Product");
        SALE_MAP.put("DATE_FORMAT(i.starttime,'%Y-%m')", "Month of Sale");
        SALE_MAP.put("DATE_FORMAT(i.starttime,'%Y-%m-%d')", "Date of Sale");
    }
}
