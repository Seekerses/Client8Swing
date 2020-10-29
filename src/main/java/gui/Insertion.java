/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import client.RequestManager;
import cmd.CommandAdd;
import consolehandler.Outputer;
import exceptions.NegativePrice;
import exceptions.NotUniqueFullName;
import exceptions.TooLargeFullName;
import productdata.*;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author seeke
 */
public class Insertion extends javax.swing.JFrame {

    /**
     * Creates new form Insertion
     */
    public Insertion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        key = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        priceButton = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        unit = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        xCoord = new javax.swing.JTextField();
        yCoord = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        manufacturer = new javax.swing.JTextField();
        addOrg = new javax.swing.JCheckBox();
        jLabel9 = new javax.swing.JLabel();
        fullName = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        postalAddress = new javax.swing.JTextField();
        addressButton = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        loc = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        xLoc = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        yLoc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        zLoc = new javax.swing.JTextField();
        insertButton = new javax.swing.JButton();
        orgType = new javax.swing.JCheckBox();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText(Outputer.getString("name") + ":");

        jLabel2.setText(Outputer.getString("key")  + ":");

        jLabel3.setText(Outputer.getString("price") + ":");

        price.setEditable(false);
        price.setEnabled(false);

        priceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceButtonActionPerformed(evt);
            }
        });

        jLabel5.setText(Outputer.getString("UnitOfMeasure")+ ":");

        unit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "KILOGRAMS", "CENTIMETERS", "PCS", "LITERS", "MILLILITERS" }));

        jLabel6.setText(Outputer.getString("CoordinateX")+ ":");

        jLabel7.setText(Outputer.getString("CoordinateY")+ ":");

        jLabel8.setText(Outputer.getString("Manufacturer")+ ":");

        manufacturer.setEditable(false);
        manufacturer.setEnabled(false);

        addOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addOrgActionPerformed(evt);
            }
        });

        jLabel9.setText(Outputer.getString("OrgFullName")+ ":");

        fullName.setEditable(false);
        fullName.setEnabled(false);

        jLabel10.setText(Outputer.getString("OrgType")+ ":");

        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PUBLIC", "TRUST", "PRIVATE_LIMITED_COMPANY" }));
        type.setSelectedItem("");
        type.setEnabled(false);

        jLabel11.setText(Outputer.getString("OrgAddress")+ ":");

        postalAddress.setEditable(false);
        postalAddress.setEnabled(false);

        addressButton.setEnabled(false);
        addressButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressButtonActionPerformed(evt);
            }
        });

        jLabel12.setText(Outputer.getString("Location")+ ":");

        loc.setEnabled(false);
        loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locActionPerformed(evt);
            }
        });

        jLabel13.setText(Outputer.getString("OrgX")+ ":");

        xLoc.setEnabled(false);

        jLabel14.setText(Outputer.getString("OrgY")+ ":");

        yLoc.setEnabled(false);

        jLabel15.setText(Outputer.getString("OrgZ")+ ":");

        zLoc.setEnabled(false);

        insertButton.setText(Outputer.getString("Send"));
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        orgType.setEnabled(false);
        orgType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orgTypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 6, Short.MAX_VALUE))
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(xCoord, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(yCoord, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(unit, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(manufacturer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(priceButton)
                                                                        .addComponent(addOrg)
                                                                        .addComponent(orgType)))
                                                        .addComponent(xLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(zLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addComponent(loc))
                                                                        .addComponent(postalAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(yLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addComponent(addressButton)))
                                .addGap(43, 43, 43)
                                .addComponent(insertButton)
                                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(priceButton)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(xCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(yCoord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(unit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(manufacturer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel8))
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel9))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(orgType)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(jLabel10))))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(postalAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabel11)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(addressButton)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(loc)
                                                        .addComponent(jLabel12))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(xLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel13))
                                                .addGap(11, 11, 11)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(yLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel14))
                                                .addGap(14, 14, 14)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(zLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel15))
                                                .addContainerGap(160, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(addOrg)
                                                .addGap(17, 17, 17)
                                                .addComponent(insertButton)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>

    private void addOrgActionPerformed(java.awt.event.ActionEvent evt) {
        if (addOrg.isSelected()){
            manufacturer.setEnabled(true);
            manufacturer.setEditable(true);
            fullName.setEnabled(true);
            fullName.setEditable(true);
            orgType.setEnabled(true);
            addressButton.setEnabled(true);
        }
        else {
            manufacturer.setEnabled(false);
            manufacturer.setEditable(false);
            fullName.setEnabled(false);
            fullName.setEditable(false);
            orgType.setEnabled(false);
            addressButton.setEnabled(false);
        }
    }

    private void locActionPerformed(java.awt.event.ActionEvent evt) {
        if(loc.isSelected()){
            xLoc.setEnabled(true);
            yLoc.setEnabled(true);
            zLoc.setEnabled(true);
            xLoc.setEditable(true);
            yLoc.setEditable(true);
            zLoc.setEditable(true);
        }
        else {
            xLoc.setEnabled(false);
            yLoc.setEnabled(false);
            zLoc.setEnabled(false);
            xLoc.setEditable(false);
            yLoc.setEditable(false);
            zLoc.setEditable(false);
        }
    }

    private void orgTypeActionPerformed(java.awt.event.ActionEvent evt) {
        if (orgType.isSelected()){
            type.setEnabled(true);
        }
        else {
            type.setEnabled(false);
        }
    }

    void setIncorrect(JComponent field){
        field.setBorder(BorderFactory.createLineBorder(Color.RED));
        throw new IllegalStateException();
    }

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
            if (addressButton.isSelected()) {
                if ("".equals(postalAddress.getText())) setIncorrect(postalAddress);
                address = new Address(postalAddress.getText(),town);
            }
            if (addOrg.isSelected()){
                OrganizationType organizationType = null;
                try {
                    organizationType = OrganizationType.valueOf(type.getSelectedItem().toString());
                }
                catch (Exception e) {
                    organizationType = null;
                }
                if ("".equals(manufacturer.getText())) setIncorrect(manufacturer);
                if ("".equals(fullName.getText())) setIncorrect(fullName);
                try {
                    organization = new Organization(null,manufacturer.getText(),fullName.getText(),organizationType,address);
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
                unit = UnitOfMeasure.valueOf(this.unit.getSelectedItem().toString());
            }catch (Exception e){
                setIncorrect(this.unit);
            }
            try {
                if ("".equals(name.getText())) setIncorrect(name);
                product = new Product(null,name.getText(),coordinates,price,unit,organization,null);
            } catch (NegativePrice negativePrice) {
                setIncorrect(this.price);
            }
            CommandAdd cmd = new CommandAdd(product, key.getText());
            RequestManager.makePreparedRequest(cmd);
            this.setVisible(false);
            this.dispose();
        }
        catch (IllegalStateException ex){
            return;
        }
    }

    private void addressButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if(addressButton.isSelected()){
            postalAddress.setEnabled(true);
            postalAddress.setEditable(true);
            loc.setEnabled(true);
        }
        else {
            postalAddress.setEnabled(false);
            postalAddress.setEditable(false);
            loc.setEnabled(false);
        }
    }

    private void priceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        if (priceButton.isSelected()){
            price.setEnabled(true);
            price.setEditable(true);
        }
        else {
            price.setEnabled(false);
            price.setEditable(false);
        }
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
            java.util.logging.Logger.getLogger(Insertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Insertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Insertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Insertion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Insertion().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JCheckBox addOrg;
    private javax.swing.JCheckBox addressButton;
    private javax.swing.JTextField fullName;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField key;
    private javax.swing.JCheckBox loc;
    private javax.swing.JTextField manufacturer;
    private javax.swing.JTextField name;
    private javax.swing.JCheckBox orgType;
    private javax.swing.JTextField postalAddress;
    private javax.swing.JTextField price;
    private javax.swing.JCheckBox priceButton;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JComboBox<String> unit;
    private javax.swing.JTextField xCoord;
    private javax.swing.JTextField xLoc;
    private javax.swing.JTextField yCoord;
    private javax.swing.JTextField yLoc;
    private javax.swing.JTextField zLoc;
    // End of variables declaration
}
