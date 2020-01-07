import java.util.ArrayList;

public class Library {
    private ArrayList<Book> catalog;


    public Library() {
        this.catalog = new ArrayList<Book>();
    }

    public void addBook(Book newBook) {
        this.catalog.add(newBook);
    }

    public void printBooks() {
        for (Book book : catalog) {
            System.out.println(book);
        }
    }

    public ArrayList<Book> searchByTitle(String title) {
        ArrayList<Book> found = new ArrayList<Book>();
        for (Book book : catalog) {
            if (StringUtils.included(book.getTitle(), title)) {
                found.add(book);
            }
        }
        return found;
    }

    public ArrayList<Book> searchByPublisher(String publisher) {
        ArrayList<Book> found = new ArrayList<Book>();
        for (Book book : catalog) {
            if (StringUtils.included(book.getPublisher(), publisher)) {
                found.add(book);
            }
        }
        return found;
    }

    public ArrayList<Book> searchByYear(int year) {
        ArrayList<Book> found = new ArrayList<Book>();
        for (Book book : catalog) {
            if (book.getYear() == year) {
                found.add(book);
            }
        }
        return found;
    }


}
