package controllers.data;

import clientserverdata.User;
import javafx.beans.property.*;
import productdata.UnitOfMeasure;

import java.time.LocalDateTime;

public class FxProduct {

    private SimpleStringProperty key;
    private SimpleLongProperty id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private SimpleStringProperty name; //Поле не может быть null, Строка не может быть пустой
    private SimpleObjectProperty<FxCoordinates> coordinates; //Поле не может быть null
    private SimpleObjectProperty<LocalDateTime> creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private SimpleFloatProperty price; //Поле может быть null, Значение поля должно быть больше 0
    private SimpleObjectProperty<UnitOfMeasure> unitOfMeasure; //Поле не может быть null
    private SimpleObjectProperty<FxOrganization> manufacturer; //Поле может быть null
    private SimpleObjectProperty<User> owner;

    public FxProduct(SimpleStringProperty key, SimpleLongProperty id, SimpleStringProperty name, SimpleObjectProperty<FxCoordinates> coordinates, SimpleObjectProperty<LocalDateTime> creationDate, SimpleFloatProperty price, SimpleObjectProperty<UnitOfMeasure> unitOfMeasure, SimpleObjectProperty<FxOrganization> manufacturer, SimpleObjectProperty<User> owner) {
        this.key = key;
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.price = price;
        this.unitOfMeasure = unitOfMeasure;
        this.manufacturer = manufacturer;
        this.owner = owner;
    }

    public long getId() {
        return id.get();
    }

    public SimpleLongProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public FxCoordinates getCoordinates() {
        return coordinates.get();
    }

    public SimpleObjectProperty<FxCoordinates> coordinatesProperty() {
        return coordinates;
    }

    public void setCoordinates(FxCoordinates coordinates) {
        this.coordinates.set(coordinates);
    }

    public LocalDateTime getCreationDate() {
        return creationDate.get();
    }

    public SimpleObjectProperty<LocalDateTime> creationDateProperty() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate.set(creationDate);
    }

    public float getPrice() {
        return price.get();
    }

    public SimpleFloatProperty priceProperty() {
        return price;
    }

    public void setPrice(float price) {
        this.price.set(price);
    }

    public UnitOfMeasure getUnitOfMeasure() {
        return unitOfMeasure.get();
    }

    public SimpleObjectProperty<UnitOfMeasure> unitOfMeasureProperty() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure) {
        this.unitOfMeasure.set(unitOfMeasure);
    }

    public FxOrganization getManufacturer() {
        return manufacturer.get();
    }

    public SimpleObjectProperty<FxOrganization> manufacturerProperty() {
        return manufacturer;
    }

    public void setManufacturer(FxOrganization manufacturer) {
        this.manufacturer.set(manufacturer);
    }

    public User getOwner() {
        return owner.get();
    }

    public SimpleObjectProperty<User> ownerProperty() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner.set(owner);
    }

    public String getKey() {
        return key.get();
    }

    public SimpleStringProperty keyProperty() {
        return key;
    }

    public void setKey(String key) {
        this.key.set(key);
    }

    public void setId(long id) {
        this.id.set(id);
    }
}
