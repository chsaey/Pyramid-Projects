package com.company.rebound;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ReboundPanel extends JPanel {
    private final int WIDTH = 300, HEIGHT = 100;
    private final int DELAY = 20, IMAGE_SIZE = 35;
    private ImageIcon image, image2;
    private Timer timer;
    private int x, y, x2, y2, moveX, moveY, moveX2, moveY2;

    public ReboundPanel() {
        timer = new Timer(DELAY, new ReboundListener());
        image = new ImageIcon("C:\\Users\\chsae\\Documents\\_Code\\_Pyramid-Projects\\2_OOPSInheritance\\src\\image.png");
        image2 = new ImageIcon("C:\\Users\\chsae\\Documents\\_Code\\_Pyramid-Projects\\2_OOPSInheritance\\src\\untitled.jpg");
        x = 0;
        y = 40;
        x2 = 20;
        y2 = 20;
        moveX = moveY = 3;
        moveX2 = 4;
        moveY2 = 8;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
        timer.start();
    }

    public void paintComponent(Graphics page) {
        super.paintComponent(page);
        image.paintIcon(this, page, x, y);
        image2.paintIcon(this, page, x2, y2);
    }

    private class ReboundListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            x += moveX;
            y += moveY;
            if (x <= 0 || x >= WIDTH - IMAGE_SIZE)
                moveX = moveX * -1;
            if (y <= 0 || y >= HEIGHT - IMAGE_SIZE)
                moveY = moveY * -1;
            repaint();


            x2 += moveX2;
            y2 += moveY2;
            if (x2 <= 0 || x2 >= WIDTH - IMAGE_SIZE)
                moveX2 = moveX2 * -1;
            if (y2 <= 0 || y2 >= HEIGHT - IMAGE_SIZE)
                moveY2 = moveY2 * -1;
            repaint();
        }
    }
}


