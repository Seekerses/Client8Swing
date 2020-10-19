package gui;

import clientserverdata.User;
import consolehandler.Outputer;
import consolehandler.TableController;
import productdata.OrganizationType;
import productdata.Product;
import productdata.UnitOfMeasure;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.time.LocalDateTime;
import java.util.*;

public class ProductModel implements TableModel {

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();

    private Hashtable<String, Product> table;
    private ArrayList<Product> list;

    public ProductModel(Hashtable<String, Product> table) {
        this.table = table;
        list = new ArrayList<Product>(table.values());
    }

    @Override
    public int getRowCount() {
        return table.size();
    }

    @Override
    public int getColumnCount() {
        return 17;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex){
            case 0 :
                return "ID";
            case 1:
                return "Key";
            case 2:
                return "Name";
            case 3 :
                return "Coordinate x";
            case 4:
                return "Coordinate y";
            case 5:
                return "Creation date";
            case 6:
                return "Price";
            case 7:
                return "Unit of measure";
            case 8:
                return "Owner";
            case 9:
                return "Organization ID";
            case 10:
                return "Manufacturer";
            case 11:
                return "Organization's full name";
            case 12:
                return "Organization type";
            case 13:
                return "Organization street";
            case 14:
                return "Organization X coordinate";
            case 15:
                return "Organization Y coordinate";
            case 16:
                return "Organization Z coordinate";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex){
            case 16 :
            case 14:
            case 0:
                return Long.class;
            case 13:
            case 11:
            case 10:
            case 2:
            case 1:
                return String.class;
            case 3 :
                return Double.class;
            case 15:
            case 4:
            case 9:
                return Integer.class;
            case 5:
                return LocalDateTime.class;
            case 6:
                return Float.class;
            case 7:
                return UnitOfMeasure.class;
            case 8:
                return User.class;
            case 12:
                return OrganizationType.class;
        }
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = list.get(rowIndex);
        switch (columnIndex){
            case 0:
                return product.getId();
            case 1:
                return TableController.getCurrentTable().getKeyByValue(product);
            case 2:
                return product.getName();
            case 3:
                return Outputer.getNumber(product.getCoordinates().getX());
            case 4:
                return Outputer.getNumber(product.getCoordinates().getY());
            case 5:
                return Outputer.getDate(product.getCreationDate());
            case 6:
                return Outputer.getNumber(product.getPrice());
            case 8:
                return product.getOwner().getUsername();
            case 7:
                return product.getUnitOfMeasure().toString();
            case 9:
                return (product.getManufacturer() == null ? null : product.getManufacturer().getId());
            case 10:
                return (product.getManufacturer() == null ? null : product.getManufacturer().getName());
            case 11:
                return (product.getManufacturer() == null ? null : product.getManufacturer().getFullName());
            case 12:
                return (product.getManufacturer() == null || product.getManufacturer().getType() == null ? null : product.getManufacturer().getType().toString());
            case 13:
                return (product.getManufacturer() == null || product.getManufacturer().getPostalAddress() == null ?
                        null : product.getManufacturer().getPostalAddress().getStreet());
            case 14:
                return (product.getManufacturer() == null || product.getManufacturer().getPostalAddress() == null ||
                        product.getManufacturer().getPostalAddress().getTown() == null ?
                        null : Outputer.getNumber(product.getManufacturer().getPostalAddress().getTown().getX()));
            case 15:
                return (product.getManufacturer() == null || product.getManufacturer().getPostalAddress() == null ||
                        product.getManufacturer().getPostalAddress().getTown() == null ?
                        null : Outputer.getNumber(product.getManufacturer().getPostalAddress().getTown().getY()));
            case 16:
                return (product.getManufacturer() == null || product.getManufacturer().getPostalAddress() == null ||
                        product.getManufacturer().getPostalAddress().getTown() == null ?
                        null : Outputer.getNumber(product.getManufacturer().getPostalAddress().getTown().getZ()));
        }
        return "";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    }

    public Product getSelectedValue(JTable table){
        String key = (String) table.getValueAt(table.getSelectedRow(),1);
        return this.table.get(key);
    }
}
