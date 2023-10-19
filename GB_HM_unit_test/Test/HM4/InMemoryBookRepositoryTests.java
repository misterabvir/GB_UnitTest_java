package HM4;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepositoryTests {

    private static List<Book> expectedData;
    private static Book getBook(String id){
        for (Book book: expectedData)
            if(book.getId().equals(id))
                return book;
        return null;
    }

    private static String[] getAuthors(){
        String[] authors = new String[expectedData.size()];
        for (int i = 0; i < expectedData.size(); i++) {
            authors[i] = expectedData.get(i).getAuthor();
        }
        return authors;
    }
    private static String[] getIds(){
        String[] ids = new String[expectedData.size()];
        for (int i = 0; i < expectedData.size(); i++) {
            ids[i] = expectedData.get(i).getId();
        }
        return ids;
    }

    private static String[] getTitles(){
        String[] titles = new String[expectedData.size()];
        for (int i = 0; i < expectedData.size(); i++) {
            titles[i] = expectedData.get(i).getTitle();
        }
        return titles;
    }
    @Mock
    InMemoryBookRepository repository;

    @BeforeEach
    void setUp(){
        expectedData = new ArrayList<>();
        expectedData.add(new Book("1", "Book1", "Author1"));
        expectedData.add(new Book("2", "Book2", "Author2"));
        expectedData.add(new Book("3", "Book3", "Author3"));
        expectedData.add(new Book("4", "Book4", "Author4"));
        repository = mock(InMemoryBookRepository.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void testFindById(String expected){
        int callings = 1;
        when(repository.findById(expected)).thenReturn(getBook(expected));

        Book actual = repository.findById(expected);

        assertThat(actual.getId()).isEqualTo(expected);
        assertThat(actual.getTitle()).isEqualTo("Book" + expected);
        assertThat(actual.getAuthor()).isEqualTo("Author" + expected);

        verify(repository, times(callings)).findById(expected);
    }

    @Test
    void testFindAll(){
        int callings = 1;
        int expectedSize = 4;
        when(repository.findAll()).thenReturn(expectedData);

        List<Book> actual = repository.findAll();
        assertThat(actual).isNotNull();
        assertThat(actual).hasSize(expectedSize);
        assertThat(actual).extracting(Book::getTitle).containsExactly(getTitles());
        assertThat(actual).extracting(Book::getAuthor).containsExactly(getAuthors());
        assertThat(actual).extracting(Book::getId).containsExactly(getIds());

        verify(repository, times(callings)).findAll();
    }

    @Test
    void testFindAllWithoutMock(){
        int expectedSize = 2;
        InMemoryBookRepository bookRepository = new InMemoryBookRepository();

        List<Book> actual = bookRepository.findAll();

        assertThat(actual).isNotNull();
        assertThat(actual).hasSize(expectedSize);
        assertThat(actual).extracting(Book::getTitle).containsExactly("Book1", "Book2");
        assertThat(actual).extracting(Book::getAuthor).containsExactly("Author1", "Author2");
        assertThat(actual).extracting(Book::getId).containsExactly("1", "2");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void testFindByIdWithoutMock(String expected){
        InMemoryBookRepository bookRepository = new InMemoryBookRepository();

        Book actual = bookRepository.findById(expected);

        assertThat(actual.getId()).isEqualTo(expected);
        assertThat(actual.getTitle()).isEqualTo("Book" + expected);
        assertThat(actual.getAuthor()).isEqualTo("Author" + expected);
    }
}
