package controllers;

import clientserverdata.User;
import com.sun.org.apache.xpath.internal.operations.Or;
import consolehandler.TableController;
import controllers.data.FxOrganization;
import controllers.data.FxProduct;
import controllers.data.TableFiller;
import javafx.beans.property.*;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import productdata.OrganizationType;
import productdata.UnitOfMeasure;

import java.time.LocalDateTime;

public class MainWindow {

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
    private TableColumn<FxProduct, UnitOfMeasure> unitCol;

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
        table.setItems(TableController.getFxProducts());

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        keyCol.setCellValueFactory(new PropertyValueFactory<>("key"));

        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        xCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, Double>, ObservableValue<Double>>() {
            @Override
            public ObservableValue<Double> call(TableColumn.CellDataFeatures<FxProduct, Double> param) {
                return param.getValue().getCoordinates().xProperty().asObject();
            }
        });

        yCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<FxProduct, Integer>, ObservableValue<Integer>>() {
            @Override
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<FxProduct, Integer> param) {
                return param.getValue().getCoordinates().yProperty().asObject();
            }
        });

        creationCol.setCellValueFactory(new PropertyValueFactory<>("creationDate"));

        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));

        unitCol.setCellValueFactory(new PropertyValueFactory<>("unitOfMeasure"));

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


}
