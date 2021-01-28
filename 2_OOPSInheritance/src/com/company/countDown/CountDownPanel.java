package com.company.countDown;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CountDownPanel extends JPanel
{
    private final int WIDTH = 600;
    private final int HEIGHT = 400;
    private final int DISPLAY_WIDTH = 150;
    private final int DISPLAY_HEIGHT = 100;
    private final int DELAY = 200;
    private final int COUNT_START = 10;
    private DigitalDisplay clock;
    private Timer timer;

    public CountDownPanel (Timer countdown)
    {
        // Set up the timer
        setBackground (Color.blue);
        setPreferredSize (new Dimension (WIDTH, HEIGHT));

        CountListener listen = new CountListener();
        clock = new DigitalDisplay(COUNT_START, WIDTH/2 - DISPLAY_WIDTH,   HEIGHT/2 - DISPLAY_HEIGHT,   DISPLAY_WIDTH, DISPLAY_HEIGHT);   }

    public void paintComponent (Graphics page)
    {
        super.paintComponent (page);
        clock.draw(page);
    }
    private class CountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clock.decrement();


        }
    }

}

