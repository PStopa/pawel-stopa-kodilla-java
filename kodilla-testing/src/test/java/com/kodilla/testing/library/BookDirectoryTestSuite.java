package com.kodilla.testing.library;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<Book>();
        for(int n = 1; n <= booksQuantity; n++){
            Book theBook = new Book("Title " + n, "Author " + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Test
    public void testListBooksWithConditionsReturnList() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOfBooks = new ArrayList<Book>();
        Book book1 = new Book("Secrets of Alamo", "John Smith", 2008);
        Book book2 = new Book("Secretaries and Directors", "Dilbert Michigan", 2012);
        Book book3 = new Book("Secret life of programmers", "Steve Wolkowitz", 2016);
        Book book4 = new Book("Secrets of Java", "Ian Tenewitch", 2010);
        resultListOfBooks.add(book1);
        resultListOfBooks.add(book2);
        resultListOfBooks.add(book3);
        resultListOfBooks.add(book4);
        when(libraryDatabaseMock.listBooksWithCondition("Secret"))
                .thenReturn(resultListOfBooks);

        // When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        // Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf0Books = new ArrayList<Book>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);
        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FourtyBooks")).thenReturn(resultListOf40Books);

        // When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FourtyBooks");
        // Then

        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());
    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {
        // Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> resultListOf10Books = generateListOfNBooks(10);
        when(libraryDatabaseMock.listBooksWithCondition(anyString()))
                .thenReturn(resultListOf10Books);

        // When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        // Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void testListOfZeroBookInHandsOf(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listOfBooks = new ArrayList<>();
        when(libraryDatabaseMock.listBooksInHandsOf(anyObject())).thenReturn(listOfBooks);
        LibraryUser user = new LibraryUser("Karol", "Nowak", "123123");

        //When
        List<Book> resultListOfBooks = bookLibrary.listBooksInHandsOf(user);

        //Then
        assertEquals(0, resultListOfBooks.size());
        assertEquals(listOfBooks, resultListOfBooks);
    }
    @Test
    public void testListTheOneBooksInHandsOf(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listOfBooks = generateListOfNBooks(1);
        when(libraryDatabaseMock.listBooksInHandsOf(anyObject())).thenReturn(listOfBooks);
        LibraryUser user = new LibraryUser("Karol", "Nowak", "123123");

        //When
        List<Book> resultListOfBooks = bookLibrary.listBooksInHandsOf(user);

        //Then
        assertEquals(1, resultListOfBooks.size());
        assertEquals(listOfBooks, resultListOfBooks);
    }
    @Test
    public void testListTheFiveBooksInHandsOf(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        List<Book> listOfBooks = generateListOfNBooks(5);
        when(libraryDatabaseMock.listBooksInHandsOf(anyObject())).thenReturn(listOfBooks);
        LibraryUser user = new LibraryUser("Karol", "Nowak", "123123");

        //When
        List<Book> resultListOfBooks = bookLibrary.listBooksInHandsOf(user);

        //Then
        assertEquals(5, resultListOfBooks.size());
        assertEquals(listOfBooks, resultListOfBooks);
    }

    @Test
    public void testRentABook(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("Karol", "Nowak", "123123");
        Book book = new Book("Nazwa", "Author", 1900);
        when(libraryDatabaseMock.rentABook(anyObject(), anyObject())).thenReturn(false);
        when(libraryDatabaseMock.rentABook(user, book)).thenReturn(true);

        //When
        boolean resultFalse, resultTrue;
        resultFalse = libraryDatabaseMock.rentABook(anyObject(),anyObject());
        resultTrue = libraryDatabaseMock.rentABook(user, book);

        //Then
        assertFalse(resultFalse);
        assertTrue(resultTrue);
    }

    @Test
    public void testReturnBooks(){
        //Given
        LibraryDatabase libraryDatabaseMock = mock(LibraryDatabase.class);
        BookLibrary bookLibrary = new BookLibrary(libraryDatabaseMock);
        LibraryUser user = new LibraryUser("Karol", "Nowak", "123123");
        when(libraryDatabaseMock.returnBooks(anyObject())).thenReturn(0);
        when(libraryDatabaseMock.returnBooks(user)).thenReturn(1);

        //When
        int result = libraryDatabaseMock.returnBooks(user);
        int result1 = libraryDatabaseMock.returnBooks(anyObject());

        //Then
        assertEquals(0, result1);
        assertEquals(1, result);
    }



}
