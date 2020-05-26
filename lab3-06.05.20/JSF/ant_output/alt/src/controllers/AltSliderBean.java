package controllers;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ManagedBean(name = "slider", eager = true)
@ApplicationScoped
public class AltSliderBean implements Serializable {
    private String axis;
    private boolean clickableRail;
    private String length;
    private int minValue;
    private int maxValue;
    private float stepPercent;


    public AltSliderBean() {
        initializeInstanceVariables();
    }

    private void initializeInstanceVariables() {
        this.axis = "x";
        this.clickableRail = true;
        this.length = "100";
        this.minValue = -6;
        this.maxValue = 6;
        this.stepPercent = 8.3333333f;
    }

    public String getAxis() {
        return axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public boolean isClickableRail() {
        return clickableRail;
    }

    public void setClickableRail(boolean clickableRail) {
        this.clickableRail = clickableRail;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public float getStepPercent() {
        return stepPercent;
    }

    public void setStepPercent(int stepPercent) {
        this.stepPercent = stepPercent;
    }
}