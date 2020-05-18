package exp.springb.startapp;

import java.util.Optional;

public interface PageRepositoryCustom {
	Page appendUrl(String id, String sUrl);
	Page removeUrl(String id, int idx);
}

