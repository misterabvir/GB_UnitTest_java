package HM4;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class InMemoryBookRepositoryTests {

    InMemoryBookRepository repository;

    @BeforeEach
    void setUp(){
        repository = new InMemoryBookRepository();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void testFindByIdPositive(String expected){
        Book actual = repository.findById(expected);
        assertThat(actual.getId()).isEqualTo(expected);
        assertThat(actual.getTitle()).isEqualTo("Book" + expected);
        assertThat(actual.getAuthor()).isEqualTo("Author" + expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "3"})
    void testFindByIdNegative(String expected){
        Book actual = repository.findById(expected);
        assertThat(actual).isNull();
    }

    @Test
    void testFindAll(){
        int expectedSize = 2;
        List<Book> actual = repository.findAll();
        assertThat(actual).isNotNull();
        assertThat(actual).hasSize(expectedSize);
        assertThat(actual).extracting(Book::getTitle)
                .containsExactly("Book1", "Book2");
        assertThat(actual).extracting(Book::getAuthor)
                .containsExactly("Author1", "Author2");
        assertThat(actual).extracting(Book::getId)
                .containsExactly("1", "2");
    }
}
