package com.enesusta.codetopdf;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;


public class DirectorySelect extends Application {

    private Stage stage;
    private DirectoryChooser directoryChooser;

    public DirectorySelect() {

        stage = new Stage();
        directoryChooser = new DirectoryChooser();

//        directoryChooser.setInitialDirectory(new File("src"));
    }

    @Override
    public void start(Stage stage) throws Exception {

        this.stage = stage;
        stage.setTitle("Select your destination directory");

        File selectedDirectory = directoryChooser.showDialog(stage);

        TexFactory texFactory = new TexFactory(selectedDirectory.getAbsolutePath());
        texFactory.createPDF();


        VBox vBox = new VBox();
        Scene scene = new Scene(vBox, 960, 600);
        stage.setScene(scene);
        //primaryStage.show();
    }


}
