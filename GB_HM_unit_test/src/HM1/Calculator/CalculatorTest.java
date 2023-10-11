package HM1.Calculator;

import HM1.Calculator.Calculator;
import org.assertj.core.data.Offset;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    public static void main(String[] args) {
        // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
        // необходимые проверки для него используя граничные случаи
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Calculator.squareRootExtraction(-1));

        assertThat(Calculator.squareRootExtraction(1))
                .isEqualTo(1, offset(0.001));

        assertThat(Calculator.squareRootExtraction(0))
                .isEqualTo(0, offset(0.001));

        assertThat(Calculator.squareRootExtraction(36.0))
                .isEqualTo(6.0, offset(0.001));

        assertThat(Calculator.squareRootExtraction(0.0121))
                .isEqualTo(0.11, offset(0.001));

        // HW1.2: Для случая деления на ноль? (с использованием AssertJ)
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Calculator.calculation(5, 0, '/'));


        // HW1.3: Сравните одну и ту же проверку с использованием условий, ассертов, AssertJ
        // в каком случае стандартное сообщение об ошибке будет более информативным?
        //if (0 != Calculator.calculation(2, 6, '+')) {
        //     throw new AssertionError("Ошибка в методе");
        //}
        /*
         * Exception in thread "main" java.lang.AssertionError:
         * Ошибка в методе at HM1.Calculator.CalculatorTest.main(CalculatorTest.java:35)
         */

        //assert 0 == Calculator.calculation(2, 6, '+');
        /*
         *  Exception in thread "main" java.lang.AssertionError
         *  at HM1.Calculator.CalculatorTest.main(CalculatorTest.java:42)
         */

        //assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(0);
        /*
         * Exception in thread "main" java.lang.AssertionError:
         *     expected: 0
         *     but was: 8
         *    at HM1.Calculator.CalculatorTest.main(CalculatorTest.java:48)
         */

        // Задание 1. ** В классе Calculator создайте метод calculateDiscount,
        // который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
        // Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
        // Если метод calculateDiscount получает недопустимые аргументы,
        // он должен выбрасывать исключение ArithmeticException.
        // Не забудьте написать тесты для проверки этого поведения.
        assertThat(Calculator.calculatingDiscount(100, 5))
                .isEqualTo(95, offset(0.001));
        assertThat(Calculator.calculatingDiscount(200, 10))
                .isEqualTo(180, offset(0.001));

        // negative purchase
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Calculator.calculatingDiscount(-200, 10));

        // negative discount
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Calculator.calculatingDiscount(200, -10));

        // impossible discount
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> Calculator.calculatingDiscount(200, 101));
    }
}