package presentation;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class GUI extends Application {


    public GUI() throws Exception {

        SwingUtilities.invokeLater(() -> {
            new JFXPanel();
            Platform.runLater(() -> {

                try {
                    start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });


        });

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));

        Scene scene =  new Scene(loader.load());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
