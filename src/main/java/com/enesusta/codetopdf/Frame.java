package com.enesusta.codetopdf;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    public Frame(String name) {

        super(name);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
            }
        });

        add(new Menu());
    }

    public void init() {
        this.pack();
        this.setVisible(true);
    }

    public void setSize(int x, int y) {
        this.setPreferredSize(new Dimension(x, y));
    }


}
