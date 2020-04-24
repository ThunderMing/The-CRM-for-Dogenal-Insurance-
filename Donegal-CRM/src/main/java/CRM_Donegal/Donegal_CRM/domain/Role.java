package CRM_Donegal.Donegal_CRM.domain;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter
public class Role {
    private Long id;

    private String sn;

    private String name;

    List<Permission> permissions = new ArrayList<Permission>();

    List<Menu> menus = new ArrayList<Menu>();

	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Permission> getPermissions() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Menu> getMenus() {
		// TODO Auto-generated method stub
		return null;
	}
}