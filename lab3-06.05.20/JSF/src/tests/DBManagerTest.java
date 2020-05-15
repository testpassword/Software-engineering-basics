package tests;

import controllers.DBManager;
import models.Dot;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Тесты для класса {@link DBManager}.
 * @author Кульбако Артемий.
 * @version 1.0
 */
class DBManagerTest {

    private final DBManager manager = new DBManager();
    private final static String className = DBManager.class.getName();
    private final EntityManager entityManager = Persistence.createEntityManagerFactory("dots").createEntityManager();

    @BeforeAll
    static void init() { System.out.println("Тестирование " + className + " запущено"); }

    @AfterAll
    static void done() { System.out.println("Тестирование " + className + " завершено"); }

    @Test @Order(1)
    void emptyConstructor() throws NoSuchFieldException {
        assertNotNull(manager.getClass().getDeclaredField("em"), "Объект не был создан");
    }

    @Test @Order(2)
    void deleteAll() {
        manager.deleteAll();
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        List<Dot> dots = this.entityManager.createQuery("SELECT dot FROM Dot dot", Dot.class).getResultList();
        tx.commit();
        assertEquals(0, dots.size());
    }

    @Test
    void addDot() {
        manager.deleteAll();
        manager.addDot(1, 1, 1, "test");
        EntityTransaction tx = this.entityManager.getTransaction();
        tx.begin();
        List<Dot> dots = this.entityManager.createQuery("SELECT dot FROM Dot dot", Dot.class).getResultList();
        tx.commit();
        assertEquals(1, dots.size());
    }

    @Test
    void getAll() {
        manager.deleteAll();
        manager.addDot(1, 1, 1, "test1");
        manager.addDot(0, 0, 0, "test2");
        String expectedIfTableTrue = "<table class=\"res-table\" id=\"table\">\n" +
                "<caption>Табличка</caption>\n" +
                "<tr><th>X</th><th>Y</th><th>R</th><th>RESULT</th></tr>\n" +
                "<tr><td>1.0</td><td>1.0</td><td>1.0</td><td>test1</td></tr>\n" +
                "<tr><td>0.0</td><td>0.0</td><td>0.0</td><td>test2</td></tr>\n" +
                "</table>";
        String realIfTableTrue = manager.getAll(true);
        String expectedIfTableFalse = "<circle r=\"3\" cx=\"270\" cy=\"30\" class=\"1.0\" stroke=\"red\" fill=\"red\"></circle>"
                + "\n" + "<circle r=\"3\" cx=\"0\" cy=\"0\" class=\"0.0\" stroke=\"red\" fill=\"red\"></circle>";
        String realIfTableFalse = manager.getAll(false);
        assertAll(
                () -> assertEquals(expectedIfTableTrue, realIfTableTrue, "html-представления не совпадают"),
                () -> assertEquals(expectedIfTableFalse, realIfTableFalse, "строки не совпадают")
        );
    }
}