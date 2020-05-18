package exp.springb.startapp;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;



@RestController
class BookmkController {
	private final BookmkRepository repository;
	
	BookmkController(BookmkRepository repository) {
		this.repository = repository;
	}
	
	// Aggregate root
	@GetMapping("/bookmk")
	List<Bookmk> all() {
		return repository.findAll();
	}

	// Add new Bookmk
	@PostMapping( value = "/bookmk")
	@ResponseBody
	Bookmk newBookmk(@RequestBody Bookmk nBookmk) {
		return repository.save(nBookmk);
	}
	
	// read one Bookmk from id
	@GetMapping(value = "/bookmk/{id}")
	@ResponseBody
	Bookmk getBookmk(@PathVariable String id) {
		return repository.findById(id)
				.orElseThrow( ()-> new BookmkNotFoundException(id));
	}
	
	// update Bookmk 
	@PutMapping( value = "/bookmk/{id}")
	@ResponseBody
	Bookmk replaceBookmk(@RequestBody Bookmk oBookmk, @PathVariable String id) {
		return repository.findById(id).map(
				bookmk->{
					bookmk.setBookmark(oBookmk.getBookmark());
					bookmk.setDescription(oBookmk.getDescription());
					bookmk.setLstPage(oBookmk.getLstPage());
					return repository.save(bookmk);
				}).orElseGet( ()->{
					oBookmk.setId(id);
					return repository.save(oBookmk);
				});
			
	}
	
	// delete a Bookmk 
	@DeleteMapping(	value = "/bookmk/{id}") 
	@ResponseBody
	void deleteBookmk(@PathVariable String id) {
			repository.deleteById(id);
	}
	
	
	@GetMapping(
		value = "/bookmk/getFromBookmk",
		params = "bookmk",
		produces = "application/json" )
	@ResponseBody
	List<Bookmk> getListbyBk(@RequestParam("bookmk") String bk) {
		return repository.findByBookmarkLike(bk);
	}
	
	// Add/remove item in list is what the custom interface for
	// Append Url 
	@GetMapping(
		value = "/bookmk/append/{id}",
		params = "pid")
	@ResponseBody
	Bookmk appendPage(@PathVariable("id") String id, 
				@RequestParam("pid") String pid) {
		return repository.appendPage(id, pid);
	}

	// Remove page
	@GetMapping(
		value = "/bookmk/removePage/{id}",
		params = "idx")
	@ResponseBody
	Bookmk removePage(@PathVariable("id") String id, 
			@RequestParam("idx") int idx) {
		//int iIdx = Integer.parseInt(idx);
		return repository.removePage( id, idx);
	}

	// Remove page
	@GetMapping(
		value = "/bookmk/removePid/{id}",
		params = "pid")
	@ResponseBody
	Bookmk removePage(@PathVariable("id") String id, 
			@RequestParam("pid") String pid) {
		return repository.removePage( id, pid);
	}

}
