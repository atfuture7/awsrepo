package exp.springb.startapp;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.query.Param;


public interface PageRepository extends MongoRepository<Page, String>
		, PageRepositoryCustom {
	
	Page save(Page nPage);
	Optional<Page> findById(String id);
	List<Page> findByTitle( String title);
	void deleteById( String title);
	
	
	List<Page> findByTitleLike(String name);

	//custom method
	Page appendUrl(String id, String sUrl);
	Page removeUrl(String id, int idx);
}

