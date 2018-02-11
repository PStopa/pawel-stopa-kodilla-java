package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    private LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<Book>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase.listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {
        List<Book> bookList = new ArrayList<Book>();
        if (libraryDatabase.listBooksInHandsOf(libraryUser).size() > 0 ){
            bookList = libraryDatabase.listBooksInHandsOf(libraryUser);
        }
        return bookList;
    }

    public boolean rentABook(LibraryUser libraryUser, Book book){
        boolean result;
        result = libraryDatabase.rentABook(libraryUser, book);
        return result;
    }

    public int returnBooks(LibraryUser libraryUser){
        int result;
        result = libraryDatabase.returnBooks(libraryUser);
        return result;
    }
}