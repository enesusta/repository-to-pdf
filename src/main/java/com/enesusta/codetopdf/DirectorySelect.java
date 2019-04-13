package com.enesusta.codetopdf;

import com.enesusta.codetopdf.components.Viewer;
import com.enesusta.codetopdf.itext.MergeDocument;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

import javax.swing.*;
import java.awt.*;
import java.io.File;


public class DirectorySelect extends Application {

    private Stage stage;
    private DirectoryChooser directoryChooser;
    private MergeDocument mergeDocument;

    public DirectorySelect() {

        stage = new Stage();
        directoryChooser = new DirectoryChooser();

//        directoryChooser.setInitialDirectory(new File("src"));
        mergeDocument = new MergeDocument();
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;
        stage.setTitle("Select your destination directory");

        File selectedDirectory = directoryChooser.showDialog(stage);


        VBox vBox = new VBox();
        Scene scene = new Scene(vBox, 960, 600);
        stage.setScene(scene);

        TexFactory texFactory = new TexFactory(selectedDirectory.getAbsolutePath());
        texFactory.isDone();

        stage.close();

        Viewer viewer = new Viewer(texFactory.getBigString());

        JFrame frame = new JFrame();
        frame.setLayout(new BorderLayout());

        JScrollPane scroll = new JScrollPane(viewer);

        frame.add(scroll);

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);



        //primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
