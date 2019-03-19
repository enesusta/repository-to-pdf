package com.enesusta.codetopdf;

import com.enesusta.codetopdf.itext.MergeDocument;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;

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

        TexFactory texFactory = new TexFactory(selectedDirectory.getAbsolutePath());
        boolean done = texFactory.isDone();

        if(done)
            System.exit(0);


        VBox vBox = new VBox();
        Scene scene = new Scene(vBox, 960, 600);
        stage.setScene(scene);
        //primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
