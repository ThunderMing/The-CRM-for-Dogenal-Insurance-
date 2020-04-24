package CRM_Donegal.Donegal_CRM.domain;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DictionaryDirItem {
    private Long id;

    private String name;

    private String intro;

    private DictionaryDir dir;

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
}