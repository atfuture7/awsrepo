package exp.springb.startapp;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class PageRepositoryImpl implements PageRepositoryCustom {
	
	@Autowired
	private PageRepository repository;
	
	@Override
	public Page appendUrl(String id, String sUrl) {
		Optional<Page> op = repository.findById(id);
		Page oPage = op.get();
		List<String> lst = oPage.getPageUrl();
		if (lst == null) {
			lst  = new ArrayList<String>();
		}
		lst.add(sUrl);		
		oPage.setPageUrl(lst);
		repository.save(oPage);
		return oPage;
	}
	
	public Page removeUrl(String id, int idx) {
		Optional<Page> op = repository.findById(id);
		Page oPage = op.get();
		List<String> lst = oPage.getPageUrl();
		if ((lst != null) && (idx >=0) 
			&& !lst.isEmpty()
			&& (lst.size() >= (idx-1)))  {
			lst.remove(idx);		
			oPage.setPageUrl(lst);
			repository.save(oPage);
		}
		return oPage;
	}
	
}
