package com.library.library;

import com.library.library.model.Book;

import java.util.*;

public class library {

    private List<Book> books;
    private Map<Book, Date> loanTimes;
    private Map<String, Boolean> studyRooms;

    public library() {
        this.books = new ArrayList<>();
        this.loanTimes = new HashMap<>();
        this.studyRooms = new HashMap<>();
        initializeStudyRooms();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean isAvailable(Book book) {
        return books.contains(book);
    }

    public int getCopiesCount(Book book) {
        int count = 0;
        for (Book b : books) {
            if (b.equals(book)) {
                count++;
            }
        }
        return count;
    }

    public void loanBook(Book book, Date loanDate) {
        if (isAvailable(book)) {
            books.remove(book);
            loanTimes.put(book, loanDate);
        }
    }

    public void returnBook(Book book) {
        if (loanTimes.containsKey(book)) {
            loanTimes.remove(book);
            books.add(book);
        }
    }

    public boolean isStudyRoomAvailable(String roomName) {
        return studyRooms.getOrDefault(roomName, false);
    }

    public void reserveStudyRoom(String roomName) {
        if (studyRooms.containsKey(roomName) && studyRooms.get(roomName)) {
            studyRooms.put(roomName, false);
        }
    }

    public void releaseStudyRoom(String roomName) {
        if (studyRooms.containsKey(roomName)) {
            studyRooms.put(roomName, true);
        }
    }

    private void initializeStudyRooms() {
        studyRooms.put("Room A", true);
        studyRooms.put("Room B", true);
        studyRooms.put("Room C", true);
    }
}