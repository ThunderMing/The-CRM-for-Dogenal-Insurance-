package CRM_Donegal.Donegal_CRM.util;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class PageResult {
    
    public static final PageResult EMPTY_PAGE = new PageResult(Collections.EMPTY_LIST,0);
        private List<?> rows;
    
    private int total;

    public PageResult(List<?> rows, int total) {
        this.rows = rows;
        this.total = total;
    }
}
