package sample.SmartHomeController;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;
import sample.SmartHomeModel.HouseModel;
import sample.SmartHomeModel.RoomModel;
import sample.SmartHomeModel.UserModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.function.UnaryOperator;


public class MainViewController {

    SimulationDataController simulationDataController;
    HouseViewController houseViewController;
    SHSController shsController;
    RoomModel[] roomArray;
    HouseModel houseModel;
    ArrayList<UserModel> userModelArrayList;
    ArrayList<String> roomNameArrayList;

    @FXML
    BorderPane bp;

    @FXML
    GridPane gridSHS;

    @FXML
    GridPane gridSHC;

    @FXML
    GridPane gridSHP;

    @FXML
    GridPane gridSHH;

    @FXML
    Button buttonSelectSHS;

    @FXML
    Button buttonSelectSHC;

    @FXML
    Button buttonSelectSHP;

    @FXML
    Button buttonSelectSHH;

    @FXML
    ComboBox<String> addModifyRoleComboBoxSHS;

    @FXML
    ComboBox<String> addModifyLocComboBoxSHS;

    @FXML
    ComboBox<String> blockWinLocComboBoxSHS;

    @FXML
    TableView<UserModel> userTable;

    @FXML
    DatePicker dateSHS;

    @FXML
    TextField addModifyUserName;

    @FXML
    Spinner<Integer> addModifyUserID;

    @FXML
    Spinner<Integer> userIdToRemove;

    @FXML
    Spinner<Integer> userIdToLogin;

    @FXML
    Spinner<Integer> hourSHS;

    @FXML
    Spinner<Integer> minSHS;

    @FXML
    Spinner<Integer> outTempSHS;

    @FXML
    Spinner<Integer> inTempSHS;

    private final ObservableList<UserModel> data;

    public MainViewController(){
        simulationDataController = new SimulationDataController();
        houseViewController = new HouseViewController();
        shsController = new SHSController();
        simulationDataController.loadData();
        roomArray = simulationDataController.getRoomArray();
        roomNameArrayList = simulationDataController.getRoomNameList();
        userModelArrayList = simulationDataController.getUserArrayList();

        data =
                FXCollections.observableArrayList(
                        userModelArrayList.get(0),userModelArrayList.get(1),userModelArrayList.get(2),userModelArrayList.get(3)
                );
    }

    @FXML
    public void initialize () {
        houseViewController.drawLayout(roomArray, bp);

        roomNameArrayList.forEach((roomName) -> {
            addModifyLocComboBoxSHS.getItems().add(roomName);
            blockWinLocComboBoxSHS.getItems().add(roomName);
        });

        addModifyLocComboBoxSHS.getItems().add("Outside");
        addModifyRoleComboBoxSHS.getItems().addAll("Parent", "Child", "Guest", "Stranger");

        userTable.setEditable(true);
        userTable.setItems(data);
    }

    public void drawLayout(){
        System.out.println(bp.getChildren().isEmpty());
        houseViewController.drawLayout(roomArray, bp);
    }

    public void selectModule(ActionEvent actionEvent){

        if (actionEvent.getSource().equals(buttonSelectSHS)) {
            gridSHS.setVisible(true);
            gridSHC.setVisible(false);
            gridSHP.setVisible(false);
            gridSHH.setVisible(false);
        }
        else if (actionEvent.getSource().equals(buttonSelectSHC)) {
            gridSHS.setVisible(false);
            gridSHC.setVisible(true);
            gridSHP.setVisible(false);
            gridSHH.setVisible(false);
        }
        else if (actionEvent.getSource().equals(buttonSelectSHP)) {
            gridSHS.setVisible(false);
            gridSHC.setVisible(false);
            gridSHP.setVisible(true);
            gridSHH.setVisible(false);
        }
        else if (actionEvent.getSource().equals(buttonSelectSHH)) {
            gridSHS.setVisible(false);
            gridSHC.setVisible(false);
            gridSHP.setVisible(false);
            gridSHH.setVisible(true);
        }
    }
}
