package HM4;


import org.junit.jupiter.api.BeforeAll;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
/*
 * У вас есть класс BookService, который использует
 * интерфейс BookRepository для получения
 * информации о книгах из базы данных. Ваша задача
 * написать unit-тесты для BookService, используя
 * Mockito для создания мок-объекта BookRepository.
 * */


class BookServiceTest {
    private static List<Book> expectedData;
    private static Book getBook(String id){
        for (Book book: expectedData)
            if(book.getId().equals(id))
                return book;
        return null;
    }

    @Mock
    private static BookRepository repository;

    @BeforeAll
    static void setUp() {
        expectedData = new ArrayList<>();
        expectedData.add(new Book("1", "Book1", "Author1"));
        expectedData.add(new Book("2", "Book2", "Author2"));
        expectedData.add(new Book("3", "Book3", "Author3"));
        expectedData.add(new Book("4", "Book4", "Author4"));
        repository = mock(InMemoryBookRepository.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4"})
    void testFindBookById(String bookId){
        int callings = 1;

        Book expected = getBook(bookId);
        assert expected != null;

        when(repository.findById(bookId)).thenReturn(expected);

        BookService service = new BookService(repository);
        Book actual = service.findBookById(bookId);

        verify(repository, times(callings)).findById(bookId);

        assertThat(actual).isNotNull();
        assertThat(actual.getAuthor()).isEqualTo(expected.getAuthor());
        assertThat(actual.getId()).isEqualTo(expected.getId());
        assertThat(actual.getTitle()).isEqualTo(expected.getTitle());
    }

    @Test
    void testFindAllBooks(){
        int callings = 1;
        List<Book> expected = expectedData;
        when(repository.findAll()).thenReturn(expected);

        BookService service = new BookService(repository);
        List<Book> actual = service.findAllBooks();

        assertThat(actual.size()).isEqualTo(expected.size());
        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).getAuthor()).isEqualTo(expected.get(i).getAuthor());
            assertThat(actual.get(i).getId()).isEqualTo(expected.get(i).getId());
            assertThat(actual.get(i).getTitle()).isEqualTo(expected.get(i).getTitle());
        }

        verify(repository, times(callings)).findAll();
    }
}