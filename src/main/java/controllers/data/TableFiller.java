package controllers.data;

import consolehandler.TableController;
import controllers.MainWindow;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TableFiller {

    public synchronized static void fill(){
        Platform.runLater(() ->{
            ArrayList<FxProduct> temp = new ArrayList<>();
            TableController.getCurrentTable().getTable().forEach((k,v) -> {
                temp.add(v.getFxProduct());

            });
            TableController.getFxProducts().setAll(temp);
        });
    }
}
