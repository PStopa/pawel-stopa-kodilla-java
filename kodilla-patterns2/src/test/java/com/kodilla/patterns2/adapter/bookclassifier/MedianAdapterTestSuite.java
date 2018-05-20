package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> books = new HashSet<>();
        books.add(new Book("author1", "title1", 1992, "123141212"));
        books.add(new Book("author2", "title2", 1990, "131134134"));
        books.add(new Book("author3", "title3", 1991, "123345234"));
        books.add(new Book("author4", "title4", 1998, "127456745"));
        books.add(new Book("author5", "title5", 1997, "141231233"));
        books.add(new Book("author6", "title6", 1996, "564564564"));
        books.add(new Book("author7", "title7", 1999, "534534554"));
        //When
        int result = medianAdapter.publicationYearMedian(books);
        //Then
        assertEquals(1996, result);
    }
}