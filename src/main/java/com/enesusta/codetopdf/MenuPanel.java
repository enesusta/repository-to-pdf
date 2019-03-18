package com.enesusta.codetopdf;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swt.MigLayout;

public class MenuPanel extends JPanel {

    public MenuPanel() {

        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(getInstance("Main"));
        add(getInstance("Main2"));

    }

    public JLabel getInstance(String text) {

        JLabel label = new JLabel(text);
        
        return label;
    }

}