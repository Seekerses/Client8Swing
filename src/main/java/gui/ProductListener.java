package gui;

import client.UserSession;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class ProductListener implements TableModelListener {
    @Override
    public void tableChanged(TableModelEvent e) {
        UserSession.getMainWindow().reDraw();
    }
}
