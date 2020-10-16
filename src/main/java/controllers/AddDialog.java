package controllers;

import client.RequestManager;
import cmd.CommandAdd;
import exceptions.NegativePrice;
import exceptions.NotUniqueFullName;
import exceptions.TooLargeFullName;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import productdata.*;

public class AddDialog {

    @FXML
    private TextField key;

    @FXML
    private TextField name;

    @FXML
    private TextField price;

    @FXML
    private TextField xCoord;

    @FXML
    private TextField yCoord;

    @FXML
    private CheckBox priceButton;

    @FXML
    private ComboBox<String> units;

    @FXML
    private TextField orgName;

    @FXML
    private CheckBox addOrg;

    @FXML
    private TextField fullName;

    @FXML
    private ComboBox<String> type;

    @FXML
    private CheckBox adressButton;

    @FXML
    private TextField postalAddress;

    @FXML
    private TextField xLoc;

    @FXML
    private TextField yLoc;

    @FXML
    private TextField zLoc;

    @FXML
    private CheckBox loc;

    @FXML
    private Button insertButton;

    @FXML
    public void initialize(){
        units.getItems().addAll("KILOGRAMS",
                "CENTIMETERS",
                "PCS",
                "LITERS",
                "MILLILITERS");
        type.getItems().addAll("PUBLIC","TRUST","PRIVATE_LIMITED_COMPANY");
    }

    @FXML
    void addAddress(ActionEvent event) {
            if(adressButton.isSelected()){
                postalAddress.setDisable(false);
                loc.setDisable(false);
            }
            else {
                postalAddress.setDisable(true);
                loc.setDisable(true);
            }
    }

    @FXML
    void addOrg(ActionEvent event) {
        if (addOrg.isSelected()){
            fullName.setDisable(false);
            type.setDisable(false);
            adressButton.setDisable(false);
        }
        else {
            fullName.setDisable(true);
            type.setDisable(true);
            adressButton.setDisable(true);
        }
    }

    @FXML
    void addLocatin(ActionEvent event) {
        if(loc.isSelected()){
            xLoc.setDisable(false);
            yLoc.setDisable(false);
            zLoc.setDisable(false);
        }
        else {
            xLoc.setDisable(true);
            yLoc.setDisable(true);
            zLoc.setDisable(true);
        }
    }

    @FXML
    void addPrice(ActionEvent event) {
        if (priceButton.isSelected()){
            price.setDisable(false);
        }
        else price.setDisable(true);
    }

    void setIncorrect(Control field){
        field.setStyle("-fx-border-color: red");
        throw new IllegalStateException();
    }

    @FXML
    void insert(ActionEvent event) {
        try {
            if ("".equals(key.getText())) setIncorrect(key);
            Location town = null;
            Address address = null;
            Organization organization = null;
            Float price = null;
            Coordinates coordinates = null;
            Product product = null;
            UnitOfMeasure unit = null;
            if (loc.isSelected()) {
                try {
                    Long.parseLong(xLoc.getText());
                    try {
                        Integer.parseInt(yLoc.getText());
                        try {
                            Long.parseLong(zLoc.getText());
                            town = new Location(Long.parseLong(xLoc.getText()), Integer.parseInt(yLoc.getText()), Long.parseLong(zLoc.getText()));
                        } catch (Exception e) {
                            setIncorrect(zLoc);
                        }
                    } catch (Exception e) {
                        setIncorrect(yLoc);
                    }
                } catch (Exception e) {
                    setIncorrect(xLoc);
                }
            }
            if (adressButton.isSelected()) {
                if ("".equals(postalAddress.getText())) setIncorrect(postalAddress);
                address = new Address(postalAddress.getText(),town);
            }
            if (addOrg.isSelected()){
                OrganizationType organizationType = null;
                try {
                    organizationType = OrganizationType.valueOf(type.getValue().toString());
                }
                catch (Exception e) {
                    organizationType = null;
                }
                if ("".equals(orgName.getText())) setIncorrect(orgName);
                if ("".equals(fullName.getText())) setIncorrect(fullName);
                try {
                    organization = new Organization(null,orgName.getText(),fullName.getText(),organizationType,address);
                } catch (TooLargeFullName | NotUniqueFullName tooLargeFullName) {
                    setIncorrect(fullName);
                }
            }
            if(priceButton.isSelected()){
                try {
                    price = Float.parseFloat(this.price.getText());
                }catch (Exception e){
                    setIncorrect(this.price);
                }
            }
            try {
                Double.parseDouble(xCoord.getText());
                try{
                    Integer.parseInt(yCoord.getText());
                    coordinates = new Coordinates(Double.parseDouble(xCoord.getText()), Integer.parseInt(yCoord.getText()));
                }catch (Exception e){
                    setIncorrect(yCoord);
                }
            }catch (Exception e){
                setIncorrect(xCoord);
            }
            try{
                unit = UnitOfMeasure.valueOf(units.getValue().toString());
            }catch (Exception e){
                setIncorrect(units);
            }
            try {
                if ("".equals(name.getText())) setIncorrect(name);
                product = new Product(null,name.getText(),coordinates,price,unit,organization,null);
            } catch (NegativePrice negativePrice) {
                setIncorrect(this.price);
            }
            CommandAdd cmd = new CommandAdd(product, key.getText());
            RequestManager.makePreparedRequest(cmd);
            insertButton.getScene().getWindow().hide();
        }
        catch (IllegalStateException ex){
            return;
        }
    }


}
