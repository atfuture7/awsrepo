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
class PageController {
	private final PageRepository repository;
	
	PageController(PageRepository repository) {
		this.repository = repository;
	}
	
	// Aggregate root
	@GetMapping("/pageurl")
	List<Page> all() {
		return repository.findAll();
	}

	// Add new Page
	@PostMapping( value = "/pageurl")
	@ResponseBody
	Page newPage(@RequestBody Page nPage) {
		return repository.save(nPage);
	}
	
	// read one Page from id
	@RequestMapping(
		value = "/pageurl/{id}",
		method = RequestMethod.GET)
	@ResponseBody
	Page getPage(@PathVariable String id) {
		return repository.findById(id)
				.orElseThrow( ()-> new PageNotFoundException(id));
	}
	
	// update page 
	@PutMapping( value = "/pageurl/{id}")
	@ResponseBody
	Page replacePage(@RequestBody Page nPage, @PathVariable String id) {
		return repository.findById(id).map(
				page->{
					page.setTitle(nPage.getTitle());
					page.setBrief(nPage.getBrief());
					page.setPageUrl(nPage.getPageUrl());
					return repository.save(page);
				}).orElseGet( ()->{
					nPage.setId(id);
					return repository.save(nPage);
				});
			
	}
	
	// delete a page 
	@DeleteMapping(	value = "/pageurl/{id}") 
	@ResponseBody
	void deletePage(@PathVariable String id) {
			repository.deleteById(id);
	}
	
	
	@RequestMapping(
		value = "/pageurl/getFromTitle",
		params = "title",
		method = RequestMethod.GET,
		produces = "application/json" )
	@ResponseBody
	List<Page> getListViaTitle(@RequestParam("title") String title) {
		return repository.findByTitleLike(title);
	}
	
	// Add/remove item in list is what the custom interface for
	// Append Url 
	@GetMapping(
		value = "/pageurl/appendUrl/{id}",
		params = "sUrl")
	@ResponseBody
	Page appendUrl(@PathVariable("id") String id, 
			@RequestParam("sUrl") String sUrl) {
		return repository.appendUrl(id, sUrl);
	}

	// Remove Url
	@GetMapping(
		value = "/pageurl/removeUrl/{id}",
		params = "idx")
	@ResponseBody
	Page appendUrl(@PathVariable("id") String id, 
			@RequestParam("idx") int idx) {
		return repository.removeUrl( id, idx);
	}

	// Get Page, called from unity
	@GetMapping(
		value = "/pageurl/getpage",
		params = "idx")
	@ResponseBody
	Page appendUrl(@RequestParam("idx") int idx) {
		List<Page> lstPage = repository.findAll();
		int total = lstPage.size();
		idx = idx % total;
		
		return lstPage.get(idx);
	}
	
}
