package CRM_Donegal.Donegal_CRM.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//The tool of JSON
public abstract class JSONUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    public static String toJSONString(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
