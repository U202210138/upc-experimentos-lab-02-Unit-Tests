import com.library.library.library;
import com.library.library.model.Book;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {

    private library library;

    @Before
    public void setUp() {
        library = new library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("La ciudad y los perros", "Mario Vargas Llosa");
        library.addBook(book);
        assertTrue(library.isAvailable(book));
    }

    @Test
    public void testBookNotAvailable() {
        Book book = new Book("Don Quijote de la Mancha", "Miguel de Cervantes");
        assertFalse(library.isAvailable(book));
    }

    @Test
    public void testAddMultipleCopies() {
        Book book = new Book("Un mundo para Julius", "Alfredo Bryce Echenique");
        library.addBook(book);
        library.addBook(book);
        assertEquals(2, library.getCopiesCount(book));
    }

    @Test
    public void testGetCopiesCount() {
        Book book1 = new Book("Un mundo para Julius", "Alfredo Bryce Echenique");
        Book book2 = new Book("Don Quijote de la Mancha", "Miguel de Cervantes");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book1);
        assertEquals(2, library.getCopiesCount(book1));
        assertEquals(1, library.getCopiesCount(book2));
    }
}
