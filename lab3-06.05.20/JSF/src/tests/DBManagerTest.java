package tests;

import controllers.DBManager;
import models.Dot;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса {@link DBManager}.
 * @author Кульбако Артемий.
 * @version 1.0
 */
class DBManagerTest {

    private static final DBManager manager = new DBManager();
    private final static String className = DBManager.class.getName();

    @BeforeAll
    static void init() { System.out.println("Тестирование " + className + " запущено"); }

    @AfterAll
    static void done() { System.out.println("Тестирование " + className + " завершено"); }

    @Test
    void emptyConstructor() throws NoSuchFieldException {
        assertNotNull(manager.getClass().getDeclaredField("em"), "Объект не был создан");
    }

    @Test
    void getAll() {
        manager.deleteAll();
        Dot testDot = new Dot(1, 1, 1, "test");
        String expected = testDot.getResult() + testDot.toTrString() +"\n";
        assertEquals(expected, manager.getAll(false), "ожидаемая строка не совпадает с полученной");
    }

    @Test
    void deleteAll() {
        int expectedSize = 1; //в пустой таблице всё-равно будет присутствовать шапка
        int realSize = getDotsTableSize();
        assertEquals(expectedSize, realSize, "размер таблицы не совпадает с ожидаемым после удаления всех точек");
    }

    private int getDotsTableSize() { return manager.getAll(true).split(System.getProperty("line.separator")).length; }

    @Test
    void addDot() {
        int expectedSize = getDotsTableSize() + 1;
        manager.addDot(1, 1, 1, "test");
        int realSize = getDotsTableSize();
        assertEquals(expectedSize, realSize, "размер таблицы не совпадает с ожидаемым после добавления точки");
    }
}