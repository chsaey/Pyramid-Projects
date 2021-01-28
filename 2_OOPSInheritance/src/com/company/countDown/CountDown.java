package com.company.countDown;


import com.company.rebound.ReboundPanel;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//use java 8
public class CountDown extends JApplet
{

    private final int DELAY = 200;
    private Timer timer;


    // ---------------------------------------------------------   // Initialize the applet, including the animation.
    public void init()
    {
        timer = new Timer (DELAY, null);
        getContentPane().add (new CountDownPanel(timer));   }
    // ---------------------------------------------------------   // Start the animation when the applet is started.
    public void start()
    {
        timer.start();
    }
    // ---------------------------------------------------------   // Stop the animation when the applet is stopped.
    public void stop()
    {
        timer.stop();
    }




}
