package exp.springb.startapp;

import java.util.Optional;

public interface BookmkRepositoryCustom {
	Bookmk appendPage(String id, String pid);
	Bookmk removePage(String id, String pid);
	Bookmk removePage(String id, int idx);
}

