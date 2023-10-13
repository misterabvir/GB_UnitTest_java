package HM2.tests;

import HM2.src.Motorcycle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;


public class MotorcycleTests {
    Motorcycle motorcycle;

    @BeforeEach
    void setUp(){
        motorcycle = new Motorcycle("Yamaha Motor Company Limited", "FZ6 FAZER", 2010);
    }

    /**
     * <p>Проверить, что объект Motorcycle создается с 2-мя колесами.</p>
     */
    @ParameterizedTest
    @ValueSource(ints = {2})
    void testMotorcycleHas2Wheels(int wheels){
        assertThat(motorcycle.getNumWheels()).isEqualTo(wheels);
    }

    /**
     * <p>Проверить, что объект Motorcycle развивает скорость 75 в режиме тестового вождения
     * (используя метод testDrive())</p>
     */
    @ParameterizedTest
    @ValueSource(ints = {75})
    void testMotorcycleSpeedInTestDriveEqual60(int speed){
        motorcycle.testDrive();
        assertThat(motorcycle.getSpeed()).isEqualTo(speed);
    }

    /**
     * <p>Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * мотоцикл останавливается (speed = 0).</p>
     */
    @ParameterizedTest
    @ValueSource(ints = {0})
    void testMotorcycleSpeedInParkModeEqual0(int speed){
        motorcycle.testDrive();
        motorcycle.park();
        assertThat(motorcycle.getSpeed()).isEqualTo(speed);
    }
}
