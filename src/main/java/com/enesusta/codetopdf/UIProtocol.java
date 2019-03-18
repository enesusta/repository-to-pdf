
package com.enesusta.codetopdf;

import java.awt.Color;

import javax.swing.JComponent;

public interface UIProtocol {


    default void setColor(JComponent component) {
        component.setBackground(Color.WHITE);
    }


}