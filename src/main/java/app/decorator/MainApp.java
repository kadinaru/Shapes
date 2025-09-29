package app.decorator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.logging.*;

public class MainApp extends Application {
    private static final Logger logger = Logger.getLogger(MainApp.class.getName());

    static {
        try {
            FileHandler fh = new FileHandler("logs/mainapp.log");
            fh.setFormatter(new SimpleFormatter());
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        logger.info("Application starting");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/app/decorator/view.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Decorator Shapes");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        logger.info("Application started");
    }

    public static void main(String[] args) {
        logger.info("Launching JavaFX application");
        launch(args);
    }
}
