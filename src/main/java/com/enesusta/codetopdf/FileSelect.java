package com.enesusta.codetopdf;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;


final public class FileSelect {

    static {

        Platform.setImplicitExit(false);

    }

    final public static boolean isJavaFXStillUsable() {

        try {

            final JFXPanel dummyForToolkitInitialization = new JFXPanel();

        } catch (IllegalStateException ise) {
            return false;
        }
        return true;
    }

    final private static Object LOCK = new Object();

    final public static File chooseFile() {

        if (!isJavaFXStillUsable())
            return null;


        synchronized (LOCK) {
            final File[] chosenFile = new File[1];
            final boolean[] keepWaiting = new boolean[1]; // same
            keepWaiting[0] = true;

            Platform.runLater(() -> {

                synchronized (LOCK) {
                    final FileChooser fileChooser = new FileChooser();
                    chosenFile[0] = fileChooser.showOpenDialog(null);
                    keepWaiting[0] = false;
                    LOCK.notifyAll();
                }
            });

            do {
                try {
                    LOCK.wait();
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            } while (keepWaiting[0]);

            return chosenFile[0];
        }

    }


}
