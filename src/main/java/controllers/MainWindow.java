package controllers;

import client.ClientController;
import client.RequestManager;
import clientserverdata.User;
import cmd.CommandUpdate;
import com.sun.org.apache.xpath.internal.operations.Or;
import consolehandler.ClientInterpreter;
import consolehandler.TableController;
import controllers.data.FxOrganization;
import controllers.data.FxProduct;
import controllers.data.TableFiller;
import exceptions.NotUniqueFullName;
import exceptions.TooLargeFullName;
import javafx.application.Platform;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.LongStringConverter;
import productdata.*;

import java.time.LocalDateTime;

public class MainWindow {

    boolean editingMode  = false;

    @FXML
    private TableView<FxProduct> table;

    @FXML
    private TableColumn<FxProduct, Long> idCol;

    @FXML
    private TableColumn<FxProduct, String> keyCol;

    @FXML
    private TableColumn<FxProduct, String> nameCol;

    @FXML
    private TableColumn<FxProduct, Double> xCol;

    @FXML
    private TableColumn<FxProduct, Integer> yCol;

    @FXML
    private TableColumn<FxProduct, LocalDateTime> creationCol;

    @FXML
    private TableColumn<FxProduct, Float> priceCol;

    @FXML
    private TableColumn<FxProduct, String> unitCol;

    @FXML
    private TableColumn<FxProduct, String> manufacturerCol;

    @FXML
    private TableColumn<FxProduct, String> ownerCol;

    @FXML
    private TableColumn<FxProduct, String> fullName;

    @FXML
    private TableColumn<FxProduct, String> orgType;

    @FXML
    private TableColumn<FxProduct, String> orgStreet;

    @FXML
    private TableColumn<FxProduct, Long> orgX;

    @FXML
    private TableColumn<FxProduct, Integer> orgY;

    @FXML
    private TableColumn<FxProduct, Long> orgZ;

    @FXML
    private TableColumn<FxProduct, Integer> orhID;


    @FXML
    public void initialize(){
        table.setEditable(true);
        table.setItems(TableController.getFxProducts());

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        keyCol.setCellValueFactory(new PropertyValueFactory<>("key"));

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameCol.setCellFactory(TextFieldTableCell.<FxProduct>forTableColumn());
        nameCol.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, String> event) -> {
            TablePosition<FxProduct, String> pos = event.getTablePosition();

            int row = pos.getRow();
            Product product = event.getTableView().getItems().get(row).getOriginal();
            product.setName(event.getNewValue());

            CommandUpdate cmd = new CommandUpdate(product);
            RequestManager.makePreparedRequest(cmd);

        });

        xCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue<Double> call(TableColumn.CellDataFeatures<FxProduct, Double> param) {
                return param.getValue().getCoordinates().xProperty().asObject();
            }
        });
        xCol.setCellFactory(new Callback<TableColumn<FxProduct, Double>, TableCell<FxProduct, Double>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TextFieldTableCell(new StringConverter() {
                    @Override
                    public String toString(Object object) {
                        return object.toString();
                    }

                    @Override
                    public Object fromString(String string) {
                        Double number = 0D;
                        try {
                            number = Double.valueOf(string);
                        }
                        catch (Exception e){

                        }
                        return number;
                    }
                });
            }
        });
        xCol.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, Double> event) -> {
            TablePosition<FxProduct, Double> pos = event.getTablePosition();

            int row = pos.getRow();
            Product product = event.getTableView().getItems().get(row).getOriginal();
            product.getCoordinates().setX(event.getNewValue());

            CommandUpdate cmd = new CommandUpdate(product);
            RequestManager.makePreparedRequest(cmd);

        });


        yCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<FxProduct, Integer> param) {
                return param.getValue().getCoordinates().yProperty().asObject();
            }
        });
        yCol.setCellFactory(new Callback<TableColumn<FxProduct, Integer>, TableCell<FxProduct, Integer>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TextFieldTableCell(new StringConverter() {
                    @Override
                    public String toString(Object object) {
                        return object.toString();
                    }

                    @Override
                    public Object fromString(String string) {
                        Integer number = 0;
                        try {
                            number = Integer.valueOf(string);
                        }
                        catch (Exception e){

                        }
                        return number;
                    }
                });
            }
        });
        yCol.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, Integer> event) -> {
            TablePosition<FxProduct, Integer> pos = event.getTablePosition();

            int row = pos.getRow();
            Product product = event.getTableView().getItems().get(row).getOriginal();
            product.getCoordinates().setY(event.getNewValue());

            CommandUpdate cmd = new CommandUpdate(product);
            RequestManager.makePreparedRequest(cmd);

        });

        creationCol.setCellValueFactory(new PropertyValueFactory<>("creationDate"));

        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setCellFactory(new Callback<TableColumn<FxProduct, Float>, TableCell<FxProduct, Float>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TextFieldTableCell(new StringConverter() {
                    @Override
                    public String toString(Object object) {
                        return object.toString();
                    }

                    @Override
                    public Object fromString(String string) {
                        Float number = 0F;
                        try {
                            number = Float.valueOf(string);
                        }
                        catch (Exception e){

                        }
                        return number;
                    }
                });
            }
        });
        priceCol.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, Float> event) -> {
            TablePosition<FxProduct, Float> pos = event.getTablePosition();

            int row = pos.getRow();
            Product product = event.getTableView().getItems().get(row).getOriginal();
            product.setPrice(event.getNewValue());

            CommandUpdate cmd = new CommandUpdate(product);
            RequestManager.makePreparedRequest(cmd);

        });

        unitCol.setCellValueFactory(new PropertyValueFactory<>("unitOfMeasure"));
        unitCol.setCellFactory(ComboBoxTableCell.forTableColumn("KILOGRAMS",
                "CENTIMETERS",
                "PCS",
                "LITERS",
                "MILLILITERS"));
        unitCol.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, String> event) -> {
            TablePosition<FxProduct, String> pos = event.getTablePosition();

            int row = pos.getRow();
            Product product = event.getTableView().getItems().get(row).getOriginal();
            product.setUnitOfMeasure(UnitOfMeasure.valueOf(event.getNewValue()));

            CommandUpdate cmd = new CommandUpdate(product);
            RequestManager.makePreparedRequest(cmd);

        });

        manufacturerCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, String>, ObservableValue<String>>() {
                    @Override
                    public ObservableValue<String> call(TableColumn.CellDataFeatures<FxProduct, String> param) {
                        if (param.getValue().getManufacturer() != null) {
                            return param.getValue().getManufacturer().nameProperty();
                        }
                        else {
                            return new SimpleStringProperty("<undefined>");
                        }
                    }
                });
        manufacturerCol.setCellFactory(TextFieldTableCell.forTableColumn());
        manufacturerCol.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, String> event) -> {

            TablePosition<FxProduct, String> pos = event.getTablePosition();

            int row = pos.getRow();
            Product product = event.getTableView().getItems().get(row).getOriginal();
            if (product.getManufacturer() != null){
                product.getManufacturer().setName(event.getNewValue());
                CommandUpdate cmd = new CommandUpdate(product);
                RequestManager.makePreparedRequest(cmd);
            }
            else {
                if(organizationFullName == null) {
                    table.applyCss();
                    table.layout();
                    Platform.runLater(() -> table.edit(event.getTablePosition().getRow(), fullName));
                    createOrganization(event.getNewValue(), null,product);

                }
                else {
                    createOrganization(event.getNewValue(), organizationFullName,product);
                }
            }
        });

        manufacturerCol.setOnEditCancel((TableColumn.CellEditEvent<FxProduct, String> event) ->{
            nully();
        });


        ownerCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<FxProduct, String> param) {
                if (param.getValue().getOwner().getUsername() != null) {
                    return new SimpleStringProperty(param.getValue().getOwner().getUsername());
                } else return new SimpleStringProperty("<undefined>");
            }
        });
        fullName.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<FxProduct, String> param) {
                if (param.getValue().getManufacturer() != null) {
                    return param.getValue().getManufacturer().fullNameProperty();
                }
                else {
                    return new SimpleStringProperty("<undefined>");
                }
            }
        });
        fullName.setCellFactory(TextFieldTableCell.forTableColumn());
        fullName.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, String> event) -> {


            TablePosition<FxProduct, String> pos = event.getTablePosition();

            int row = pos.getRow();
            Product product = event.getTableView().getItems().get(row).getOriginal();
            if (product.getManufacturer() != null){
                product.getManufacturer().setFullName(event.getNewValue());
                CommandUpdate cmd = new CommandUpdate(product);
                RequestManager.makePreparedRequest(cmd);
            }
            else {

                if(organizationName == null) {
                    createOrganization(null, event.getNewValue(),product);
                    table.layout();
                    table.edit(event.getTablePosition().getRow(), manufacturerCol);
                }
                else {
                    createOrganization(organizationName, event.getNewValue(),product);
                }
            }
        });
        fullName.setOnEditCancel((TableColumn.CellEditEvent<FxProduct, String> event) ->{
            nully();
        });

        orgType.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<FxProduct, String> param) {
                if (param.getValue().getManufacturer() != null) {
                    return param.getValue().getManufacturer().typeProperty().asString();
                }
                else {
                    return new SimpleObjectProperty<OrganizationType>().asString();
                }
            }
        });
        orgType.setCellFactory(ComboBoxTableCell.forTableColumn("PUBLIC","TRUST","PRIVATE_LIMITED_COMPANY"));

        orgType.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, String> event) -> {

            if (event.getRowValue().getOriginal().getManufacturer() == null){
                organizationType = OrganizationType.valueOf(event.getNewValue());
                Platform.runLater(() -> {
                    table.edit(event.getTablePosition().getRow(), manufacturerCol);
                });
            }
            else {
                event.getRowValue().getOriginal().getManufacturer().setFullName(event.getNewValue());
                CommandUpdate cmd = new CommandUpdate(event.getRowValue().getOriginal());
                RequestManager.makePreparedRequest(cmd);
            }
        });
        orgType.setOnEditCancel((TableColumn.CellEditEvent<FxProduct, String> event) ->{
            nully();
        });

        orgStreet.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<FxProduct, String> param) {
                if (param.getValue().getManufacturer() != null && param.getValue().getManufacturer().getPostalAddress() != null) {
                    return param.getValue().getManufacturer().getPostalAddress().streetProperty();
                } else {
                    return new SimpleStringProperty("undefined");
                }
            }
        });
        orgStreet.setCellFactory(TextFieldTableCell.forTableColumn());
        orgStreet.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, String> event) -> {
            if (event.getRowValue().getOriginal().getManufacturer() == null){
                createAddress(event.getNewValue(),event.getRowValue().getOriginal());
                Platform.runLater(() -> {
                    table.edit(event.getTablePosition().getRow(), manufacturerCol);
                });
            }
            else {
                event.getRowValue().getOriginal().getManufacturer().setPostalAddress(new Address(event.getNewValue(),
                        event.getRowValue().getOriginal().getManufacturer().getPostalAddress() == null ? null :
                                event.getRowValue().getOriginal().getManufacturer().getPostalAddress().getTown()));
                CommandUpdate cmd = new CommandUpdate(event.getRowValue().getOriginal());
                RequestManager.makePreparedRequest(cmd);
            }
        });
        orgStreet.setOnEditCancel((TableColumn.CellEditEvent<FxProduct, String> event) ->{
            nully();
        });

        orgX.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<FxProduct, Long> param) {
                if (param.getValue().getManufacturer() != null
                        && param.getValue().getManufacturer().getPostalAddress() != null
                        && param.getValue().getManufacturer().getPostalAddress().getTown() != null){
                    return param.getValue().getManufacturer().getPostalAddress().getTown().xProperty().asObject();
                }
                else {
                    return new SimpleLongProperty().asObject();
                }
            }
        });
        orgX.setCellFactory(new Callback<TableColumn<FxProduct, Long>, TableCell<FxProduct, Long>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TextFieldTableCell(new StringConverter() {
                    @Override
                    public String toString(Object object) {
                        return object.toString();
                    }

                    @Override
                    public Object fromString(String string) {
                        Long number = 0L;
                        try {
                            number = Long.valueOf(string);
                        }
                        catch (Exception e){

                        }
                        return number;
                    }
                });
            }
        });
        orgX.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, Long> event) -> {
            if (event.getRowValue().getOriginal().getManufacturer() == null
                    || event.getRowValue().getOriginal().getManufacturer().getPostalAddress() == null
                    || event.getRowValue().getOriginal().getManufacturer().getPostalAddress().getTown() == null){
                createLocation(event.getNewValue(),ycoordintate,zcoordinate,event.getRowValue().getOriginal());
                if (zcoordinate != null){
                    Platform.runLater(() -> {
                        table.edit(event.getTablePosition().getRow(), orgStreet);
                    });
                }
                else {
                    Platform.runLater(() -> {
                        table.edit(event.getTablePosition().getRow(), orgZ);
                    });
                }
            }
            else {
                event.getRowValue().getOriginal().getManufacturer().getPostalAddress().getTown().setX(event.getNewValue());
                CommandUpdate cmd = new CommandUpdate(event.getRowValue().getOriginal());
                RequestManager.makePreparedRequest(cmd);
            }
        });
        orgX.setOnEditCancel((TableColumn.CellEditEvent<FxProduct, Long> event) ->{
            nully();
        });

        orgY.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<FxProduct, Integer> param) {
                if (param.getValue().getManufacturer() != null
                        && param.getValue().getManufacturer().getPostalAddress() != null
                        && param.getValue().getManufacturer().getPostalAddress().getTown() != null){
                    return param.getValue().getManufacturer().getPostalAddress().getTown().yProperty().asObject();
                }
                else {
                    return new SimpleIntegerProperty().asObject();
                }
            }
        });
        orgY.setCellFactory(new Callback<TableColumn<FxProduct, Integer>, TableCell<FxProduct, Integer>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TextFieldTableCell(new StringConverter() {
                    @Override
                    public String toString(Object object) {
                        return object.toString();
                    }

                    @Override
                    public Object fromString(String string) {
                        Integer number = 0;
                        try {
                            number = Integer.valueOf(string);
                        }
                        catch (Exception e){

                        }
                        return number;
                    }
                });
            }
        });
        orgY.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, Integer> event) -> {
            if (event.getRowValue().getOriginal().getManufacturer() == null
                    || event.getRowValue().getOriginal().getManufacturer().getPostalAddress() == null
                    || event.getRowValue().getOriginal().getManufacturer().getPostalAddress().getTown() == null){
                createLocation(xcoordinate,event.getNewValue(),zcoordinate,event.getRowValue().getOriginal());
                Platform.runLater(() -> {
                    table.edit(event.getTablePosition().getRow(), orgStreet);
                });
            }
            else {
                event.getRowValue().getOriginal().getManufacturer().getPostalAddress().getTown().setY(event.getNewValue());
                CommandUpdate cmd = new CommandUpdate(event.getRowValue().getOriginal());
                RequestManager.makePreparedRequest(cmd);
            }
        });
        orgY.setOnEditCancel((TableColumn.CellEditEvent<FxProduct, Integer> event) ->{
            nully();
        });

        orgZ.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, Long>, ObservableValue<Long>>() {
            @Override
            public ObservableValue<Long> call(TableColumn.CellDataFeatures<FxProduct, Long> param) {
                if (param.getValue().getManufacturer() != null
                        && param.getValue().getManufacturer().getPostalAddress() != null
                        && param.getValue().getManufacturer().getPostalAddress().getTown() != null){
                    return param.getValue().getManufacturer().getPostalAddress().getTown().zProperty().asObject();
                }
                else {
                    return new SimpleLongProperty().asObject();
                }
            }
        });
        orgZ.setCellFactory(new Callback<TableColumn<FxProduct, Long>, TableCell<FxProduct, Long>>() {
            @Override
            public TableCell call(TableColumn param) {
                return new TextFieldTableCell(new StringConverter() {
                    @Override
                    public String toString(Object object) {
                        return object.toString();
                    }

                    @Override
                    public Object fromString(String string) {
                        Long number = 0L;
                        try {
                            number = Long.valueOf(string);
                        }
                        catch (Exception e){

                        }
                        return number;
                    }
                });
            }
        });
        orgZ.setOnEditCommit((TableColumn.CellEditEvent<FxProduct, Long> event) -> {
            if (event.getRowValue().getOriginal().getManufacturer() == null
                    || event.getRowValue().getOriginal().getManufacturer().getPostalAddress() == null
                    || event.getRowValue().getOriginal().getManufacturer().getPostalAddress().getTown() == null){
                createLocation(xcoordinate,ycoordintate,event.getNewValue(),event.getRowValue().getOriginal());
                if (xcoordinate != null){
                    Platform.runLater(() -> {
                        table.edit(event.getTablePosition().getRow(), orgStreet);
                    });
                }
                else {
                    Platform.runLater(() -> {
                        table.edit(event.getTablePosition().getRow(), orgX);
                    });
                }
            }
            else {
                event.getRowValue().getOriginal().getManufacturer().getPostalAddress().getTown().setZ(event.getNewValue());
                CommandUpdate cmd = new CommandUpdate(event.getRowValue().getOriginal());
                RequestManager.makePreparedRequest(cmd);
            }
        });
        orgZ.setOnEditCancel((TableColumn.CellEditEvent<FxProduct, Long> event) ->{
            nully();
        });

        orhID.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<FxProduct, Integer> param) {
                if (param.getValue().getManufacturer() != null){
                    return param.getValue().getManufacturer().idProperty().asObject();
                }
                else {
                    return new SimpleIntegerProperty().asObject();
                }
            }
        });

        TableFiller.fill();
    }

    private String organizationName = null;
    private String organizationFullName = null;
    private OrganizationType organizationType = null;
    private Address address = null;
    private String street = null;
    private Location town = null;
    private Long xcoordinate = null;
    private Integer ycoordintate = null;
    private Long zcoordinate = null;

    void nully(){
        organizationFullName = null;
        organizationName = null;
        organizationType = null;
        address = null;
        street = null;
        town = null;
        xcoordinate = null;
        ycoordintate = null;
        zcoordinate = null;
        TableFiller.fill();
    }

    void createOrganization(String name, String fullName, Product product){
        if (organizationName == null || organizationFullName == null){
            organizationName = name;
            organizationFullName = fullName;
            System.out.println( organizationFullName + " " + organizationName);
        }
        if (organizationName != null && organizationFullName != null){
            try {
                Organization org = new Organization(null,organizationName,organizationFullName,organizationType,address);
                product.setManufacturer(org);
                CommandUpdate cmd = new CommandUpdate(product);
                RequestManager.makePreparedRequest(cmd);
            } catch (TooLargeFullName tooLargeFullName) {
                tooLargeFullName.printStackTrace();
            } catch (NotUniqueFullName notUniqueFullName) {
                notUniqueFullName.printStackTrace();
            }

        }
    }

    void createAddress(String street, Product product){
        this.street = street;
        this.address = new Address(street, town);
        if (product.getManufacturer() != null){
            product.getManufacturer().setPostalAddress(address);
            CommandUpdate cmd = new CommandUpdate(product);
            RequestManager.makePreparedRequest(cmd);
        }
    }

    void createLocation(Long x, Integer y, Long z, Product product){
        if ( x == null || z == null){
            xcoordinate = x;
            zcoordinate = z;
            ycoordintate = y;
        }
        if (xcoordinate != null && zcoordinate != null){

            town = new Location(xcoordinate,ycoordintate == null ? 0: ycoordintate,zcoordinate);
            if (product.getManufacturer() != null && product.getManufacturer().getPostalAddress() != null){
                product.getManufacturer().getPostalAddress().setTown(town);
                CommandUpdate cmd = new CommandUpdate(product);
                RequestManager.makePreparedRequest(cmd);
            }
        }
    }
}
