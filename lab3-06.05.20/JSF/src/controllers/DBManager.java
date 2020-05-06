package controllers;

import models.Dot;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class DBManager {
    private EntityManager em;

    public DBManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dots");
        em = emf.createEntityManager();
    }

    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        dbManager.deleteAll();
        dbManager.addDot(1, 1, 1, "ERROR");
        System.out.println(dbManager.getAll(true));
        dbManager.deleteAll();
        dbManager.addDot(2, 2, 1, "ERROR");
        dbManager.addDot(3, 3, 2, "ERROR");
        System.out.println(dbManager.getAll(true));
        dbManager.deleteAll();
    }

    public String getAll(boolean isTable) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Dot> dots = em.createQuery("SELECT dot FROM Dot dot", Dot.class).getResultList();
        tx.commit();
        StringBuilder result = new StringBuilder();
        if (isTable) result.append("<table class=\"res-table\" id=\"table\">\n" +
                "<caption>Табличка</caption>\n" + "<tr><th>X</th><th>Y</th><th>R</th><th>RESULT</th></tr>\n");
        for (Dot dot : dots) {
            String res = dot.getResult();
            if (!isTable) {
                if (res.toLowerCase().equals("true") || res.toLowerCase().equals("false")) result.append(dot.toDotString()).append("\n");
            } else result.append(dot.toTrString()).append("\n");
        }
        if (isTable) result.append("</table>");
        return result.toString();
    }

    public void deleteAll() {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.createQuery("DELETE FROM Dot dot").executeUpdate();
        tx.commit();
    }

    public void addDot(double x, double y, double r, String result) {
        Dot dot = new Dot(x, y, r, result);
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(dot);
        tx.commit();
    }
}
