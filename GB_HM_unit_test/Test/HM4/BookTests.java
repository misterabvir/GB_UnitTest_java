package HM4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class BookTests {
    @ParameterizedTest
    @CsvSource({
            "1, book1, author1",
            "2, book2, author2",
            "3, book3, author3"})
    void testCreateBookWithFullConstructor(
            String id,
            String title,
            String author) {
        Book actual = new Book(id, title, author);
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(title);
        assertThat(actual.getAuthor()).isEqualTo(author);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1","2","3"})
    void testCreateBookWithIdConstructor(String id) {
        Book actual = new Book(id);
        assertThat(actual).isNotNull();
        assertThat(actual.getId()).isEqualTo(id);
        assertThat(actual.getTitle()).isNullOrEmpty();
        assertThat(actual.getAuthor()).isNullOrEmpty();
    }

    @ParameterizedTest
    @CsvSource({
            "1, book1, author1, 11, book11, author11",
            "2, book2, author2, 22, book22, author22",
            "3, book3, author3, 33, book33, author33"})
    void testChangeStateBook(
            String id,
            String title,
            String author,
            String newId,
            String newTitle,
            String newAuthor) {
        Book actual = new Book(id, title, author);

        actual.setId(newId);
        actual.setTitle(newTitle);
        actual.setAuthor(newAuthor);

        assertThat(actual.getId()).isEqualTo(newId).isNotEqualTo(id);
        assertThat(actual.getTitle()).isEqualTo(newTitle).isNotEqualTo(title);
        assertThat(actual.getAuthor()).isEqualTo(newAuthor).isNotEqualTo(author);
    }
}
