import client.ClientController;
import consolehandler.*;
import controllers.data.FxProduct;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;

public class Main  extends Application {

    public static void main(String[] args) {

        new Thread(()->{
            launch(args);
        }).start();



        System.out.print("\n");

        TableManager prodTable = new TableManager("products");
        ObservableList<FxProduct> list = FXCollections.observableArrayList();
        TableController.setFxProducts(list);
        TableController.setCurrentTable(prodTable);

        CommandController cmd = new CommandController();
        cmd.start(new ClientInterpreter());
        cmd.stop();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxmls/signUp.fxml"));
        primaryStage.setTitle("Lab 7 Reg");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
