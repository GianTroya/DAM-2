package iterator;

public class IteratorPatternDemo {
	 public static void main(String[] args) {
	        Library library = new Library();
	        library.addBook(new Book("Design Patterns"));
	        library.addBook(new Book("Clean Code"));
	        library.addBook(new Book("Effective Java"));
	        
	        Iterator<Book> iterator = library.createIterator();
	        
	        System.out.println("Books in the library:");
	        while (iterator.hasNext()) {
	            System.out.println(iterator.next().getTitle());
	        }
	    }
}
