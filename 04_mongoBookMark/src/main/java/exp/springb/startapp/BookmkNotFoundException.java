package exp.springb.startapp;

class BookmkNotFoundException extends RuntimeException {
	BookmkNotFoundException(String id) {
		super("Could not find Bookmk " + id);
	}
}