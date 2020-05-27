package logic.utils;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Позволяет отслеживать площадь последней фигуры каждого пользователя в рамках сессии.
 * @author Артемий Кульбако
 * @version 1.0
 */
@ManagedResource @Component
public class SquareMBean implements Serializable {

    private final static long SerialVersionUID = 4L;
    private final Map<String, Double> squares = new HashMap<>();

    public void addSquare(String userID, double r) { squares.put(userID, r); }

    @ManagedAttribute public Map<String, Double> getSquares() { return this.squares; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SquareMBean)) return false;
        SquareMBean that = (SquareMBean) o;
        return Objects.equals(squares, that.squares);
    }

    @Override
    public int hashCode() { return Objects.hash(squares); }

    @Override
    public String toString() { return "SquareMBean{" + "squares=" + squares + '}'; }
}