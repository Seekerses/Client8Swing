package controllers.data;

import consolehandler.TableController;

import java.util.ArrayList;

public class TableFiller {

    public static void fill(){
        ArrayList<FxProduct> temp = new ArrayList<>();
        TableController.getCurrentTable().getTable().forEach((k,v) -> {
            temp.add(v.getFxProduct());

        });
        TableController.getFxProducts().setAll(temp);
    }
}
