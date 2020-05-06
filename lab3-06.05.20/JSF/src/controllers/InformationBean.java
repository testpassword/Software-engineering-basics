package controllers;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "info", eager = true)
@ApplicationScoped
public class InformationBean {
    private String name = "Анатолий Анищенко и Владимир Земнухов";
    private String groupName = "P3212";
    private String var = "Вариант 13334";

    public InformationBean() { }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
