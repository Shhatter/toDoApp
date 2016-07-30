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

public class Controller implements Initializable{



    public TextArea toDoTaskView;
    public Label taskNameLabel;
    public TextField deadlineDateTextBox;
    public ListView<String> toDoList = new ListView<String>();
    public List<Event> EventList = new ArrayList<Event>();
    public ObservableList<String> observableEventList = FXCollections.observableArrayList();
    public Button newTaskButton2;
    public Label priorityLabel;









@Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

    toDoList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    toDoList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {

            int indexOfListVIew=toDoList.getSelectionModel().getSelectedIndex();
            taskNameLabel.setText(EventList.get(indexOfListVIew).getName());
            toDoTaskView.setText(EventList.get(indexOfListVIew).getDescription());
            deadlineDateTextBox.setText(EventList.get(indexOfListVIew).getVisibleDate());
            switch (EventList.get(indexOfListVIew).getPriority())
            {
                case 1:
                    priorityLabel.setText("PRIORITY 1");
                    priorityLabel.setStyle("-fx-text-fill: red;");
                    break;
                case 2:
                    priorityLabel.setText("PRIORITY 2");
                    priorityLabel.setStyle("-fx-text-fill: #EE7600;");
                    break;
                case 3:
                    priorityLabel.setText("PRIORITY 3");
                    priorityLabel.setStyle("-fx-text-fill: green;");
                    break;
                default:
                    priorityLabel.setText("NO PRIORITY :)");
                    priorityLabel.setStyle("-fx-text-fill: blue;");
                    break;
            }

        }
    });

    }


    void initData( List<Event> eventList, ObservableList<String> observableEventList) {

        EventList = eventList;
        this.observableEventList = observableEventList;
    }



@FXML
    public void addNewTask(ActionEvent event) throws IOException{

    FXMLLoader loader = new FXMLLoader();

    loader.setLocation(getClass().getResource("newTaskView.fxml"));
    loader.load();
    Parent root  = loader.getRoot();
    Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    appStage.setTitle("To do application ");
    Scene newTaskScene = new Scene(root);
    appStage.setScene(newTaskScene);
    CreateNewTask createNewTask = loader.getController();
    createNewTask.initData(EventList,observableEventList);
    appStage.show();
    }


}
