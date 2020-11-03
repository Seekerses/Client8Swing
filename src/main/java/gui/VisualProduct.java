package gui;

import cmd.Local;
import productdata.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VisualProduct extends JComponent {

    private Product product;
    private int x = 0;
    private int y = 0;
    private Timer timer;

    public VisualProduct(Product product){
        this.product = product;
    }

    @Override
    protected void paintComponent(Graphics g){


        Graphics2D g2 = (Graphics2D) g;
        g2.setBackground(Color.WHITE);

        Rectangle r = new Rectangle(100,100);

        g2.clearRect(0,0, r.width, r.height);

        byte code = 0;
        for (byte a : product.getOwner().getUsername().getBytes()){
            if ((int)code + (int)a > 127 ){
                code = (byte) ((int)code + (int)a - 127);
            }else code +=  a;
        }

        g2.setColor(new Color(code*2,127-code,code/2));
        g2.fillRect((int)product.getCoordinates().getX() % 100, product.getCoordinates().getY() % 100,
                y, x);
        if (timer == null) timer = new Timer(10, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (x != product.getCoordinates().getX()) x++;
                if (y != product.getCoordinates().getY()) y++;
                VisualProduct.this.repaint();
            }
        });
        if (x == 0  && y == 0) timer.start();
        if ((x == product.getCoordinates().getX() && y == product.getCoordinates().getY()) || (x > 100 && y>100)) timer.stop();
    }

    public Product getProduct() {
        return product;
    }
}
