package exp.springb.startapp;

import lombok.Data;
import java.util.List;
import org.springframework.data.annotation.Id;

@Data
public class Page {
	
	@Id private String id;
	
	private String title;
	private String brief;
	private List<String> pageUrl;
	
	public Page() {}
	public Page( String str1, String str2, List<String> lst) {
		this.title=str1;
		this.brief=str2;
		this.pageUrl=lst;
	}
	
/*	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBrief() {
		return brief;
	}
	
	public void setBrief(String brief) {
		this.brief = brief;
	}

	public List<String> getPageUrl() {
		return pageUrl;
	}
	
	public void setPageUrl(List<String> pageUrl) {
		this.pageUrl = pageUrl;
	}
*/
	
}

