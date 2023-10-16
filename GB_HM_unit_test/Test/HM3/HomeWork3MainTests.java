package HM3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork3MainTests {

    MainHW service;
    @BeforeEach
    void setUp(){
        service = new MainHW();
    }

    @ParameterizedTest
    @ValueSource(ints = { 1,2,3 })
    void checkValueIsOdd(int input){
        boolean actual = service.evenOddNumber(input);
        assertTrue(actual);
    }
}
