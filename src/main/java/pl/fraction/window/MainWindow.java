package pl.fraction.window;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

public class MainWindow extends Application {

    private static final Logger log = Logger.getLogger(MainWindow.class);

    public static void main(String[] args) {
        log.info("Application started.");
        launch(args);
        log.info("Application exited.");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MainWindow/MainWindow.fxml"));
        Parent root = loader.load();
        MainWindowController controller = loader.getController();
        primaryStage.setTitle("Project Fraction");
        primaryStage.setScene(new Scene(root));
        primaryStage.setOnShown(event -> controller.setUiControlsDefaultSettings());
        primaryStage.show();
    }
}
