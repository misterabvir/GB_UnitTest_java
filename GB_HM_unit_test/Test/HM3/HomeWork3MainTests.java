package HM3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork3MainTests {

    MainHW service;

    @BeforeEach
    void setUp() {
        service = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void checkValueIsOdd(int input) {
        boolean actual = service.evenOddNumber(input);
        assertTrue(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 2, 6})
    void checkValueIsEven(int input) {
        boolean actual = service.evenOddNumber(input);
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 0, 0})
    void checkZeroReturnFalse(int input) {
        boolean actual = service.evenOddNumber(input);
        assertFalse(actual);
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 50, 100})
    void checkValueInIntervalPositiveResult(int input) {
        boolean actual = service.numberInInterval(input);
        assertTrue(actual);
    }
}
