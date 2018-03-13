package com.kodilla.patterns.prototype.library;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class LibraryTestSuite {
    @Test
    public void testGetBooks(){
        //Given

        Library library = new Library("My Library number 1");

        Book book1 = new Book("First Book", "Noname", LocalDate.of(2010,10,10));
        Book book2 = new Book("Second Book", "Anonymous", LocalDate.of(2010,10,10));
        Book book3 = new Book("Third Book", "I don`t Know", LocalDate.of(2010,10,10));

        //When
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        //shallowCopy
        Library clonedLibrary = null;
        try {
            clonedLibrary = library.shallowCopy();
            clonedLibrary.setName("My Library number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        //deepCopy
        Library deepClonedLibrary = null;
        try {
            deepClonedLibrary = library.deepCopy();
            deepClonedLibrary.setName("My Library number 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        library.getBooks().remove(book3);

        System.out.println(library.getBooks());
        System.out.println(clonedLibrary.getBooks());
        System.out.println(deepClonedLibrary.getBooks());

        //Then
        Assert.assertEquals(2, library.getBooks().size());
        Assert.assertEquals(2, clonedLibrary.getBooks().size());
        Assert.assertEquals(3, deepClonedLibrary.getBooks().size());

        Assert.assertEquals(library.getBooks().size(), clonedLibrary.getBooks().size());
        Assert.assertNotEquals(library.getBooks().size(), deepClonedLibrary.getBooks().size());
    }
}
