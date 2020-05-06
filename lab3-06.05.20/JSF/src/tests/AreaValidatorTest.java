package tests;

import controllers.AreaValidator;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса {@link AreaValidator}.
 * @author Кульбако Артемий.
 * @version 1.0
 */
class AreaValidatorTest {

    private final static String className = AreaValidator.class.getName();
    private static final String errMessage = "метод пропустил некорректные данные";

    @BeforeAll
    static void init() { System.out.println("тестирование " + className + " запущено"); }

    @AfterAll
    static void done() { System.out.println("тестирование " + className + " завершено"); }

    @Test
    void checkArea() {
        assertAll(
                () -> assertEquals("TRUE", AreaValidator.checkArea("1", "-2", "3")),
                () -> assertEquals("FALSE", AreaValidator.checkArea("-1", "-1", "-1"))
        );
    }

    @Test
    void validateX() {
        assertAll(
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateX("-3.001"), errMessage),
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateX("3.001"), errMessage)
        );
    }

    @Test
    void validateY() {
        assertAll(
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateY("-5.001"), errMessage),
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateY("3.001"), errMessage)
        );
    }

    @Test
    void validateR() {
        assertAll(
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateR("0.999"), errMessage),
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateR("4.001"), errMessage)
        );
    }
}