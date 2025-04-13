package com.library.library;
import com.library.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class library {

    private List<Book> books;

    // Constructor
    public library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to check if a book is available in the library
    public boolean isAvailable(Book book) {
        return books.contains(book);
    }

    // Method to get the number of copies of a specific book
    public int getCopiesCount(Book book) {
        int count = 0;
        for (Book b : books) {
            if (b.equals(book)) {
                count++;
            }
        }
        return count;
    }
}

