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
public class AreaValidatorTest {

    private final static String className = AreaValidator.class.getName();
    private final String errMessage = "метод пропустил некорректные данные";

    @BeforeAll
    public static void init() { System.out.println("тестирование " + className + " запущено"); }

    @AfterAll
    public static void done() { System.out.println("тестирование " + className + " завершено"); }

    @Test
    public void checkArea() {
        assertAll(
                () -> assertEquals("TRUE", AreaValidator.checkArea("1", "-2", "3")),
                () -> assertEquals("FALSE", AreaValidator.checkArea("-1", "-1", "-1"))
        );
    }

    @Test
    public void validateX() {
        assertAll(
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateX("-3.001"), this.errMessage),
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateX("3.001"), this.errMessage)
        );
    }

    @Test
    public void validateY() {
        assertAll(
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateY("-5.001"), this.errMessage),
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateY("3.001"), this.errMessage)
        );
    }

    @Test
    public void validateR() {
        assertAll(
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateR("0.999"), this.errMessage),
                () -> assertThrows(NumberFormatException.class, () -> AreaValidator.validateR("4.001"), this.errMessage)
        );
    }
}