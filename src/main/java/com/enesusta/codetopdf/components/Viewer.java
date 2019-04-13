package com.enesusta.codetopdf.components;

import com.enesusta.codetopdf.JavaSourceReader;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

public class Viewer extends JPanel {

    private JavaSourceReader javaSourceReader;
    private String string;

    public Viewer(String string) {

        setBorder(new LineBorder(Color.RED));
        setPreferredSize(new Dimension(1000, 10000));
        this.string = string;
    }


    private void drawString(Graphics g, String text, int x, int y) {
        for (String line : text.split(System.lineSeparator())) {
            if (line.contains("import")) {
                g.setColor(Color.RED);
                g.drawString(line, x, y += g.getFontMetrics().getHeight());
            } else if (line.contains("class")) {
                g.setColor(Color.RED);
                g.drawString(line, x, y += g.getFontMetrics().getHeight());
            } else {
                g.setColor(Color.BLACK);
                g.drawString(line, x, y += g.getFontMetrics().getHeight());
            }

        }
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        FontMetrics fm = g.getFontMetrics();

        Dimension size = getPreferredSize();
//        String text = "Pref: " + size.width + "x" + size.height;
        //      g.drawString(text, 0, fm.getAscent());


        //g.drawString(text, 0, fm.getHeight() + fm.getAscent());
        drawString(g,string, 600, 50);
    }


}
