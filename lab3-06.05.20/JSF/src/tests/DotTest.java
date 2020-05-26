package tests;

import models.Dot;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса {@link Dot}.
 * @author Кульбако Артемий.
 * @version 1.0
 */
public class DotTest {

    private final double x = 1;
    private final double y = 1;
    private final double r = 1;
    private final String res = "test";
    private final Dot testDot = new Dot(x, y, r, res);
    private final static String className = Dot.class.getName();

    @BeforeAll
    public static void init() { System.out.println("тестирование " + className + " запущено"); }

    @AfterAll
    public static void done() { System.out.println("тестирование " + className + " завершено"); }

    @Test @Order(1)
    public void emptyConstructor() {
        Dot empty = new Dot();
        assertAll(
                () -> assertNotNull(empty, "Объект не был создан"),
                () -> assertEquals(1d, empty.getR(), 0.001),
                () -> assertEquals(0d, empty.getX(), 0.001),
                () -> assertEquals(0d, empty.getY(), 0.001),
                () -> assertEquals("ERROR", empty.getResult())
        );
    }

    @Test @Order(2)
    public void fullConstructor() {
        assertAll(
                () -> assertNotNull(testDot, "Объект не был создан"),
                () -> assertEquals(r, testDot.getR(), 0.001 ),
                () -> assertEquals(x, testDot.getX(), 0.001),
                () -> assertEquals(y, testDot.getY(), 0.001),
                () -> assertEquals(res, testDot.getResult())
        );
    }

    @Test
    public void toDotString() {
        String expected = "<circle r=\"3\" cx=\"270\" cy=\"30\" class=\"1.0\" stroke=\"red\" fill=\"red\"></circle>";
        assertEquals(expected, testDot.toDotString(), "html-код circle не совпадает с ожидаемым");
    }

    @Test
    public void toTrString() {
        String expected = "<tr><td>1.0</td><td>1.0</td><td>1.0</td><td>test</td></tr>";
        assertEquals(expected, testDot.toTrString(), "табличное html-значение точки формируется неверно");
    }
}