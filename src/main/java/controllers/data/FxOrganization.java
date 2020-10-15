package controllers.data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import productdata.Address;
import productdata.OrganizationType;

public class FxOrganization {

    private SimpleIntegerProperty id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private SimpleStringProperty name; //Поле не может быть null, Строка не может быть пустой
    private SimpleStringProperty fullName; //Длина строки не должна быть больше 1404, Значение этого поля должно быть уникальным, Поле не может быть null
    private SimpleObjectProperty<OrganizationType> type; //Поле может быть null
    private SimpleObjectProperty<FxAddress> postalAddress; //Поле может быть null

    public FxOrganization(SimpleIntegerProperty id, SimpleStringProperty name, SimpleStringProperty fullName, SimpleObjectProperty<OrganizationType> type, SimpleObjectProperty<FxAddress> postalAddress) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.type = type;
        this.postalAddress = postalAddress;
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
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

    public String getFullName() {
        return fullName.get();
    }

    public SimpleStringProperty fullNameProperty() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public OrganizationType getType() {
        return type.get();
    }

    public SimpleObjectProperty<OrganizationType> typeProperty() {
        return type;
    }

    public void setType(OrganizationType type) {
        this.type.set(type);
    }

    public FxAddress getPostalAddress() {
        return postalAddress.get();
    }

    public SimpleObjectProperty<FxAddress> postalAddressProperty() {
        return postalAddress;
    }

    public void setPostalAddress(FxAddress postalAddress) {
        this.postalAddress.set(postalAddress);
    }
}
