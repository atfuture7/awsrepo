package exp.springb.startapp;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

public class BookmkRepositoryImpl implements BookmkRepositoryCustom {

	@Autowired	
	private BookmkRepository repository;
	@Autowired	
	private PageRepository pgRepository;
	
	// append Page
	@Override
	public Bookmk appendPage(String id, String pid) {
		// mark out first for easy debugging 
		//return null;
		
		Optional<Bookmk> op = repository.findById(id);
		if (!op.isPresent()) return null;
		Bookmk oBookmk = op.get();

		Optional<Page> op1 = pgRepository.findById(pid);
		if (!op1.isPresent()) return null;
		Page oPage = op1.get();
		
		List<Page> lst = oBookmk.getLstPage();
		if (lst == null) {
			lst  = new ArrayList<Page>();
		}
		lst.add(oPage);		
		oBookmk.setLstPage(lst);
		repository.save(oBookmk);
		return oBookmk;
	
	}
	
	//remove page by id
	public Bookmk removePage(String id, String pid) {
		// mark out first for easy debugging 
		//return null;
		
		Optional<Bookmk> op = repository.findById(id);
		if (!op.isPresent()) return null;
		Bookmk oBookmk = op.get();
		List<Page> lst = oBookmk.getLstPage();
		
		System.out.println("start-----");
		String itrId = "";
		for (Page oPage : lst) {
			System.out.println("in loop-----");
			itrId = oPage.getId();
			if (id.equals(pid)) {
				lst.remove(oPage);
				break;
			}
		}
		oBookmk.setLstPage(lst);
		repository.save(oBookmk);
		return oBookmk;
	}
	
	
	//remove page by index
	public Bookmk removePage(String id, int idx) {
		// mark out first for easy debugging 
		//return null;
		
		Optional<Bookmk> op = repository.findById(id);
		if (!op.isPresent()) return null;
		Bookmk oBookmk = op.get();
		List<Page> lst = oBookmk.getLstPage();
		
		if ((lst != null) && (idx >= 0) 
			&& !lst.isEmpty()
			&& (lst.size() >= (idx-1))) {
			lst.remove(idx);		
			oBookmk.setLstPage(lst);
			repository.save(oBookmk);
		}
		return oBookmk;
	}
	
}
