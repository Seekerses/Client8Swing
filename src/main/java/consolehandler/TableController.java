package consolehandler;

import controllers.data.FxProduct;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.util.Hashtable;

/**
 * Controls all created TableManagers(Tables),
 * Define one of them as a Current table which all commands will work with
 */
public class TableController {
    /**
     * Keeps the Current table
     */
    private static TableManager currentTable;
    private static ObservableList<FxProduct> fxproducts;

    /**
     * Contains all existed tablesz
     */
    private static Hashtable<String,TableManager> tables = new Hashtable<>();

    /**
     * Sets Current Table
     * @param table new Current Table
     */
    public static void setCurrentTable(TableManager table){
        currentTable = table;
    }

    /**
     * Returns Current table
     * @return Current table
     */
    public static TableManager getCurrentTable() {
        return currentTable;
    }

    /**
     * Adds a Table Manager into table
     * @param key Table Manager name
     * @param table Table Manager
     */
    public static void put(String key, TableManager table){
        tables.put(key,table);
    }

    /**
     * Returns a Table Manager from table
     * @param key name
     * @return Table Manager
     */
    public static TableManager get(String key){
        return tables.get(key);
    }

    public static ObservableList<FxProduct> getFxProducts() {
        return fxproducts;
    }

    public static void setFxProducts(ObservableList<FxProduct> fxproducts) {
        TableController.fxproducts = fxproducts;
    }
}
