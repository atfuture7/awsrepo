package exp.springb.startapp;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookmkRepository extends MongoRepository<Bookmk, String>
		, BookmkRepositoryCustom {
	
	Bookmk save(Bookmk nBookmk);
	Optional<Bookmk> findById(String id);
	List<Bookmk> findByBookmark( String Bookmk);
	void deleteById( String id);
	
	
	List<Bookmk> findByBookmarkLike(String name);

	//custom method
	Bookmk appendPage(String id, String pid);
	Bookmk removePage(String id, String pid);
	Bookmk removePage(String id, int idx);
}

