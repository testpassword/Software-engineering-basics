package tests;

import controllers.AreaValidator;
import controllers.ControllerBean;
import models.Dot;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса {@link ControllerBean}.
 * @author Кульбако Артемий.
 * @version 1.0
 */
public class ControllerBeanTest {

    private final ControllerBean controller = new ControllerBean();
    private final static String className = Dot.class.getName();

    @BeforeAll
    static void init() { System.out.println("тестирование " + className + " запущено"); }

    @AfterAll
    static void done() { System.out.println("тестирование " + className + " завершено"); }

    @Test
    void areaAndPlotAreaCheck() {
        assertThrows(NumberFormatException.class, () -> {
            String x = "qw";
            String y = "er";
            String r = "ty";
            AreaValidator.validateX(x);
            AreaValidator.validateY(y);
            AreaValidator.validateR(r);
            AreaValidator.checkArea(x, y , r);
        });
    }

    @Test
    void resetBean() {
        assertAll(
                () -> assertEquals(0.0f, controller.getX()),
                () -> assertEquals("0", controller.getY()),
                () -> assertEquals("1", controller.getR()),
                () -> assertEquals("", controller.getResult())
        );
    }
}