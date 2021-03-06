package sample.SmartHomeView;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import sample.SmartHomeController.HouseViewController;
import sample.SmartHomeController.MainViewController;
import sample.SmartHomeController.SimulationDataController;
import sample.SmartHomeModel.SimulationData;

/**
 * Class for Main View.
 */
public class MainView extends Application {

    /**
     * Start the main view.
     * @param primaryStage the primary stage.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("SimulatorView.fxml"));
        primaryStage.setTitle("Smart Home Simulator");
        primaryStage.setScene(new Scene(root, 1225, 800));
        primaryStage.show();
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
