package HM4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookTests {
    @ParameterizedTest
    @CsvSource({
            "1, book1, author1",
            "2, book2, author2",
            "3, book3, author3"})
    void testGettersBook(
            String id,
            String title,
            String author) {
        int callings = 1;
        Book book = mock(Book.class);
        when(book.getId()).thenReturn(id);
        when(book.getTitle()).thenReturn(title);
        when(book.getAuthor()).thenReturn(author);

        String actualId = book.getId();
        String actualTitle = book.getTitle();
        String actualAuthor = book.getAuthor();

        assertThat(actualId).isEqualTo(id);
        assertThat(actualTitle).isEqualTo(title);
        assertThat(actualAuthor).isEqualTo(author);
        verify(book, times(callings)).getId();
        verify(book, times(callings)).getTitle();
        verify(book, times(callings)).getAuthor();
    }

    @ParameterizedTest
    @CsvSource({
            "1, book1, author1",
            "2, book2, author2",
            "3, book3, author3"})
    void testSettersBook(
            String id,
            String title,
            String author) {
        int callings = 1;
        Book book = mock(Book.class);
        when(book.getId()).thenCallRealMethod();
        when(book.getTitle()).thenCallRealMethod();
        when(book.getAuthor()).thenCallRealMethod();
        doCallRealMethod().when(book).setId(id);
        doCallRealMethod().when(book).setTitle(title);
        doCallRealMethod().when(book).setAuthor(author);

        book.setId(id);
        book.setTitle(title);
        book.setAuthor(author);

        String actualId = book.getId();
        String actualTitle = book.getTitle();
        String actualAuthor = book.getAuthor();

        assertThat(actualId).isEqualTo(id);
        assertThat(actualTitle).isEqualTo(title);
        assertThat(actualAuthor).isEqualTo(author);

        verify(book, times(callings)).setId(id);
        verify(book, times(callings)).setTitle(title);
        verify(book, times(callings)).setAuthor(author);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
    void testConstructorId(String id){
        Book book = new Book(id);
        assertThat(book).isNotNull();
        assertThat(book.getId()).isEqualTo(id);
        assertThat(book.getTitle()).isNull();
        assertThat(book.getAuthor()).isNull();
    }

    @ParameterizedTest
    @CsvSource({
            "1, book1, author1",
            "2, book2, author2",
            "3, book3, author3"})
    void testConstructorFull(String id,
                           String title,
                           String author){
        Book book = new Book(id, title, author);
        assertThat(book).isNotNull();
        assertThat(book.getId()).isEqualTo(id);
        assertThat(book.getTitle()).isEqualTo(title);
        assertThat(book.getAuthor()).isEqualTo(author);
    }
}
