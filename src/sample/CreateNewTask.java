package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;



public class CreateNewTask implements  Initializable{
    @FXML
    public Button confirmNewTaskButton;
    public TextField newTaskTitle;





    private void initialize() {
    }

    void initData(String customer) {
        newTaskTitle.setText(customer);
    }

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {


        // initialize your logic here: all @FXML variables will have been injected
    }



    @FXML
    public void confirmNewTaskToListAction(ActionEvent event) throws IOException{

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource("Gui.fxml"));
        loader.load();
        Parent root  = loader.getRoot();
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setTitle("To do application ");
        Scene newTaskScene = new Scene(root);
        appStage.setScene(newTaskScene);
        appStage.show();

    }

}
