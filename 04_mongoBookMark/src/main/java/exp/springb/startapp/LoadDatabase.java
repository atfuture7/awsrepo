package exp.springb.startapp;

import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.ArrayList;

@Configuration
@Slf4j
class LoadDatabase {
	@Bean
	CommandLineRunner initDatabase(PageRepository repository) {
		return args->{};
		/*
		//create simple page
		Page oPage = new Page("PreTitle1", "created by preload", null);
		
		// create new page with list
		List<String> lstUrl = new ArrayList<String>();
		lstUrl.add("https://spring.io/guides/tutorials/rest/");
		lstUrl.add("https://spring.io/guides");
		Page oPage2 = new Page("PreTitle2", "with list", lstUrl);

		return args-> {
			log.info("Preloading " + repository.save(oPage));
			log.info("Preloading " + repository.save(oPage2));
		};
		*/
	}
}
