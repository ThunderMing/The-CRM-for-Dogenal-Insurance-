package CRM_Donegal.Donegal_CRM.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter
public class DictionaryDir {
    private Long id;

    private String name;

    private String sn;

    private String intro;

    List<DictionaryDirItem> items = new ArrayList<DictionaryDirItem>();

	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSn() {
		// TODO Auto-generated method stub
		return null;
	}
}