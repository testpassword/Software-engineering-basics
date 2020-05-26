package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "dots")
public class AltDot implements Serializable {

    @SequenceGenerator(name = "seqGen", sequenceName = "gen_seq", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqGen")
    private long id;
    private Double r;
    private String result;
    private Double x;
    private Double y;

    public AltDot() {
        setR(1d);
        setX(0d);
        setY(0d);
        setResult("ERROR");
    }

    public AltDot(double x, double y, double r, String result) {
        setX(x);
        setY(y);
        setR(r);
        setResult(result);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AltDot dot = (AltDot) o;
        return id == dot.id &&
                Objects.equals(r, dot.r) &&
                Objects.equals(result, dot.result) &&
                Objects.equals(x, dot.x) &&
                Objects.equals(y, dot.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, r, result, x, y);
    }

    public String toAltDotString() {
        int x_dot = (int) (x * 120 / r + 150);
        int y_dot = (int) (-y * 120 / r + 150);
        return "<circle r=\"3\" cx=\"" + x_dot + "\" cy=\"" + y_dot + "\" class=\"" +  r + "\" "
                + (result.toLowerCase().equals("true") ? "stroke=\"green\" fill=\"green\"" : "stroke=\"red\" fill=\"red\"")
                + "></circle>";
    }

    public String toTrString() {
        return "<tr>" + tdString(x) + tdString(y) + tdString(r) + tdString(result) + "</tr>";
    }

    private String tdString(Object s) {
        return String.format("<td>%s</td>", s.toString());
    }
}

