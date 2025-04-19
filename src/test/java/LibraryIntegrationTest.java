import com.library.library.library;
import com.library.library.model.Book;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class LibraryIntegrationTest {

    private library library;

    @Before
    public void setUp() {
        library = new library();
    }

    @Test
    public void testLoanAndReturnBook() {
        Book book = new Book("Cien años de soledad", "Gabriel García Márquez");
        library.addBook(book);

        Date loanDate = new Date();
        library.loanBook(book, loanDate);

        assertFalse(library.isAvailable(book));
        library.returnBook(book);
        assertTrue(library.isAvailable(book));
    }

    @Test
    public void testStudyRoomAvailability() {
        assertTrue(library.isStudyRoomAvailable("Room A"));
        library.reserveStudyRoom("Room A");
        assertFalse(library.isStudyRoomAvailable("Room A"));
        library.releaseStudyRoom("Room A");
        assertTrue(library.isStudyRoomAvailable("Room A"));
    }
}