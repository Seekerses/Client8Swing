package controllers.data;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class FxAddress {

    private SimpleStringProperty street; //Поле не может быть null
    private SimpleObjectProperty<FxLocation> town; //Поле может быть null

    public FxAddress(SimpleStringProperty street, SimpleObjectProperty<FxLocation> town) {
        this.street = street;
        this.town = town;
    }

    public String getStreet() {
        return street.get();
    }

    public SimpleStringProperty streetProperty() {
        return street;
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public FxLocation getTown() {
        return town.get();
    }

    public SimpleObjectProperty<FxLocation> townProperty() {
        return town;
    }

    public void setTown(FxLocation town) {
        this.town.set(town);
    }
}
