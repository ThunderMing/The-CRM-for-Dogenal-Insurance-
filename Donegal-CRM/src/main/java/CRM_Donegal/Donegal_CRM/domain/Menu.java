package CRM_Donegal.Donegal_CRM.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Setter@Getter
public class Menu {
    private Long id;

    private String text;

    private String url;
    //up-level menu
    private Menu parent;
    //all the child menu
    private List<Menu> children = new ArrayList<Menu>();
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Menu> getChildren() {
		// TODO Auto-generated method stub
		return null;
	}
}
