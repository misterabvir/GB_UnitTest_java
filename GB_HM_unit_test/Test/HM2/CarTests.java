package HM2.tests;

import HM2.src.Car;
import HM2.src.Vehicle;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
public class CarTests {
    Car car;
    @BeforeEach
    void setUp(){
        car = new Car("Tesla", "Model-S", 2010);
    }

    /**
     * <p>Проверить, что экземпляр объекта Car также является экземпляром
     * транспортного средства (используя оператор instanceof).</p>
     */
    @Test
    void testCarIsInstanceOfVehicle(){
        assertThat(car).isInstanceOf(Vehicle.class);
        assertTrue(car instanceof Vehicle);
    }
    /**
     * <p>Проверить, что объект Car создается с 4-мя колесами.</p>
     */
    @ParameterizedTest
    @ValueSource(ints = {4})
    void testCarHas4Wheels(int wheels){
        assertThat(car.getNumWheels()).isEqualTo(wheels);
    }

    /**
     * <p>Проверить, что объект Car развивает скорость 60 в режиме тестового вождения (используя метод testDrive()).</p>
     */
    @ParameterizedTest
    @ValueSource(ints = {60})
    void testCarSpeedInTestDriveEqual60(int speed){
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(speed);
    }

    /**
     * <p>Проверить, что в режиме парковки (сначала testDrive, потом park, т.е. эмуляция движения транспорта)
     * машина  останавливается (speed = 0).</p>
     */
    @ParameterizedTest
    @ValueSource(ints = {0})
    void testCarSpeedInParkModeEqual0(int speed){
        car.testDrive();
        car.park();
        assertThat(car.getSpeed()).isEqualTo(speed);
    }
}
