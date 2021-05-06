package Lesson4;

import ch.qos.logback.classic.Logger;
import org.junit.jupiter.api.*;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TriangleTest {
    private static Logger logger = (Logger) LoggerFactory.getLogger(TriangleTest.class);

    @BeforeAll
    static void beforeAll() {
        logger.info("Старт тестов на функцию вычисления площади треугольника по его сторонам");
    }

    @Test
    void positiveResultTest() throws NotNegativeOrNullException {
        logger.info("Проверка, что площадь находится верно");
        double area = Triangle.triangleArea(2, 3, 4);
        Assertions.assertEquals(area, 2.9047375096555625);
    }

    @Test
    void testNullException() {
        logger.info("Проверка нулеывых значений");
        assertThatExceptionOfType (NotNegativeOrNullException.class).isThrownBy(()
                -> Triangle.triangleArea(0, 0, 0));
    }

    @Test
    void testNegativeException() {
        logger.info("Проверка отрицательных значений");
        assertThatExceptionOfType (NotNegativeOrNullException.class).isThrownBy(()
                -> Triangle.triangleArea(-1, -1, -1));
    }

    @AfterAll
    static void AfterAll() {
        logger.info("Тесты завершены");
    }
}
