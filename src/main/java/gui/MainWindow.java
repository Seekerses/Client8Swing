/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import client.RequestManager;
import client.UserSession;
import clientserverdata.Reply;
import cmd.Command;
import cmd.Registerable;
import consolehandler.TableController;
import consolehandler.cmdLists.StdCommandList;
import productdata.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.text.TableView;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author seeke
 */
public class MainWindow extends javax.swing.JFrame {

    /**
     * Creates new form ainWindow
     */
    public MainWindow() {
        initComponents();
        visualize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        command = new javax.swing.JComboBox<>();
        argumnets = new javax.swing.JTextField();
        completeButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextArea();
        userLogin = new javax.swing.JLabel();
        addProduct = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        table.setAutoCreateRowSorter(true);
        table.setModel(new ProductModel(TableController.getCurrentTable().getTable()));
        jScrollPane2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setColumnSelectionAllowed(false);
        table.setUpdateSelectionOnSort(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        jLabel1.setText("User:");

        jLabel2.setText("Command");

        command.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "help","insert", "remove_key",
                "clear", "execute_script", "exit", "filter_less_than_manufacturer", "replace_if_greater",
                "info", "group_counting_by_coordinates", "show", "history","min_by_name","remove_lower", "login", "register" }));
        command.setSelectedItem("");
        command.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commandActionPerformed(evt);
            }
        });

        argumnets.setText("");

        completeButton.setText("Complete");
        completeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButtonActionPerformed(evt);
            }
        });

        result.setColumns(20);
        result.setRows(5);
        jScrollPane3.setViewportView(result);

        userLogin.setText(UserSession.getLogin());

        addProduct.setText("Add");
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });

        panel.setLayout(new java.awt.GridLayout(1, 3));
        jScrollPane2.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addComponent(jLabel2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(85, 85, 85)
                                                .addComponent(completeButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(command, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(argumnets, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(73, 73, 73)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(26, 26, 26)
                                                                .addComponent(userLogin))
                                                        .addComponent(addProduct))
                                                .addContainerGap(136, Short.MAX_VALUE))
                                        .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(userLogin))
                                                .addGap(81, 81, 81)
                                                .addComponent(addProduct))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 314, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(command, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(argumnets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(completeButton)
                                .addGap(37, 37, 37)
                                .addComponent(jScrollPane3)
                                .addContainerGap())
        );
        pack();
    }// </editor-fold>

    private void commandActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {
        Insertion.main(null);
    }

    private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (command.getSelectedItem() == null || command.getSelectedItem().toString() == null
                || "".equals(command.getSelectedItem().toString())) return;
        Command cmd = StdCommandList.getCommand(command.getSelectedItem().toString());
        String[] args = argumnets.getText().split(" ");
        Reply result = null;
        if ("".equals(argumnets.getText())) args = null;
        try {
            result = RequestManager.makeRequest(cmd,args);
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        this.result.setText(result != null ? result.getAnswer() : null);

        if(cmd instanceof Registerable){
            if ("Approved".equals((result != null ? result.getAnswer().split(",") : new String[0])[0])){
                userLogin.setText(UserSession.getLogin());
            }
        }
    }

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {
        if (evt.getClickCount() == 2){
            Product product = ((ProductModel) table.getModel()).getSelectedValue(table);

            if (product.getOwner().getUsername().equals(UserSession.getLogin())) {
                new Update(((ProductModel) table.getModel()).getSelectedValue(table));
            }
        }
    }

    private void visualMouseClicked(MouseEvent evt){
        if (evt.getClickCount() == 2){
            Product product = ((VisualProduct) evt.getSource()).getProduct();
            if (product.getOwner().getUsername().equals(UserSession.getLogin())) {
                new Update(((VisualProduct) evt.getSource()).getProduct());
            }
        }
    }

    private void visualize(){
        panel.setLayout(new WrapLayout());
        panel.setSize(new Dimension(400,1));
        for (Product product : TableController.getCurrentTable().getTable().values()){
            VisualProduct v = new VisualProduct(product);
            v.setPreferredSize(new Dimension(100,100));
            v.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            v.setToolTipText(product.toString());
            v.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    visualMouseClicked(evt);
                }
            });
            panel.add(v);
        }
        this.pack();
        panel.repaint();
        panel.revalidate();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserSession.setMainWindow(new MainWindow());
                UserSession.getMainWindow().setVisible(true);
            }
        });
    }


    public void reDraw(){
        table.repaint();
        table.revalidate();
        visualize();
    }

    // Variables declaration - do not modify
    private javax.swing.JButton addProduct;
    private javax.swing.JTextField argumnets;
    private javax.swing.JComboBox<String> command;
    private javax.swing.JButton completeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea result;
    private javax.swing.JTable table;
    private javax.swing.JLabel userLogin;
    private JPanel panel;
    // End of variables declaration
}
