package com.enesusta.codetopdf;

import net.miginfocom.swing.MigLayout;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Menu extends JPanel implements MouseListener,UIProtocol{

    public Menu() {

        setLayout(new MigLayout());
        setColor(this);
        add(new MenuPanel(), "span");
        

        JButton button =new JButton("Click me");
        button.addMouseListener(this);

        add(button);

    }



    @Override
    public void mouseClicked(MouseEvent e) {
        DirectorySelect.launch(DirectorySelect.class);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }



}
