package com.enesusta.codetopdf;

import java.awt.Dimension;
import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //DirectorySelect.launch(DirectorySelect.class);

        Frame frame = new Frame("Code To PDF");

        frame.setSize(new Dimension(600,600));
        frame.add(new Menu());
        frame.init();



    }
}
