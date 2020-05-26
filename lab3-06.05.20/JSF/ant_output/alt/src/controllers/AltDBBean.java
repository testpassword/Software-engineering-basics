package controllers;

import controllers.AltDBManager;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "db", eager = true)
@ApplicationScoped
public class AltDBBean {

    private AltDBManager manager = null;
    private String resultAllDot;
    private String resultAllTable;

    public AltDBBean() {
        manager = new AltDBManager();
    }

    public String getResultAllDot() {
        return manager.getAll(false);
    }

    public String getResultAllTable() {
        return manager.getAll(true);
    }

    public void setResultAllDot(String resultAllDot) {
        this.resultAllDot = resultAllDot;
    }

    public void setResultAllTable(String resultAllTable) {
        this.resultAllTable = resultAllTable;
    }

    public void deleteAll() {
        if (manager != null)
            manager.deleteAll();
    }
}
