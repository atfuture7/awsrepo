package exp.springb.startapp;

import lombok.Data;
import java.util.List;
import org.springframework.data.annotation.Id;

@Data
public class Bookmk {
	
	@Id private String id;
	
	private String bookmark;
	private String description;
	private List<Page> lstPage;
	
	public Bookmk() {}
	public Bookmk( String str1, String str2, List<Page> lst) {
		this.bookmark=str1;
		this.description=str2;
		this.lstPage=lst;
	}
}

