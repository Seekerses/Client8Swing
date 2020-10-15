package controllers.data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;

public class FxLocation {

    private SimpleLongProperty x; //Поле не может быть null
    private SimpleIntegerProperty y;
    private SimpleLongProperty z; //Поле не может быть null

    public FxLocation(SimpleLongProperty x, SimpleIntegerProperty y, SimpleLongProperty z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public long getX() {
        return x.get();
    }

    public SimpleLongProperty xProperty() {
        return x;
    }

    public void setX(long x) {
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

    public long getZ() {
        return z.get();
    }

    public SimpleLongProperty zProperty() {
        return z;
    }

    public void setZ(long z) {
        this.z.set(z);
    }
}
