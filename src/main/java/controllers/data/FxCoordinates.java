package controllers.data;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class FxCoordinates {

    private SimpleDoubleProperty x;
    private SimpleIntegerProperty y; //Значение поля должно быть больше -150, Поле не может быть null

    public FxCoordinates(SimpleDoubleProperty x, SimpleIntegerProperty y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x.get();
    }

    public SimpleDoubleProperty xProperty() {
        return x;
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public int getY() {
        return y.get();
    }

    public SimpleIntegerProperty yProperty() {
        return y;
    }

    public void setY(int y) {
        this.y.set(y);
    }
}
