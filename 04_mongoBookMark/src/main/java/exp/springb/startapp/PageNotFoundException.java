package exp.springb.startapp;

class PageNotFoundException extends RuntimeException {
	PageNotFoundException(String id) {
		super("Could not find page " + id);
	}
}