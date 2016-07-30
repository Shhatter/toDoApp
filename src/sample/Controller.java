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


    public TextField nameTextBox;
    public TextArea newToDoDescriptionTextArea;
    public DatePicker dueDatePicker;
    public TextArea toDoTaskView;
    public Button OkNewToDoButton;
    public Label taskNameLabel;
    public Button createNewButton;
    public TextField deadlineDateTextBox;
    public ListView<String> toDoList = new ListView<String>();
    public List<Event> EventList = new ArrayList<Event>();
    public ObservableList<String> observableEventList = FXCollections.observableArrayList();
    public Button newTaskButton2;







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

        }
    });

    }


    @FXML
    public void openNewTaskWindow(){

    }

    public void pressButton(ActionEvent event){

    }

    public void confirmNewTask(ActionEvent event) {

        if (dueDatePicker.getValue() != null && nameTextBox.getText().isEmpty()==false && newToDoDescriptionTextArea.getText().isEmpty() ==false) {
            crateNewTaskOnTheList();
        } else {
            Alert noDataAlert = new Alert(Alert.AlertType.WARNING, "Please fill all required fields");
            noDataAlert.showAndWait();
        }
    }

    public void crateNewTaskOnTheList() {
        LocalDate localDate;
        localDate = dueDatePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);


        Event toAddEvent = new Event(nameTextBox.getText(), date, localDate.toString(), newToDoDescriptionTextArea.getText());
        EventList.add(toAddEvent);
        observableEventList.add(nameTextBox.getText());
        toDoList.setItems(observableEventList);

        OkNewToDoButton.setDisable(true);

        nameTextBox.setDisable(true);
        nameTextBox.setText("");
        newToDoDescriptionTextArea.setDisable(true);
        newToDoDescriptionTextArea.setText("");
        createNewButton.setDisable(false);
        dueDatePicker.setValue(null);
        dueDatePicker.setDisable(true);

    }

    void initData( List<Event> eventList, ObservableList<String> observableEventList) {

        EventList = eventList;
        this.observableEventList = observableEventList;
    }



    public void createNewTask(ActionEvent event) {

        setButtonsToFalse();


    }

    public void setButtonsToFalse() {
        OkNewToDoButton.setDisable(false);
        nameTextBox.setDisable(false);
        newToDoDescriptionTextArea.setDisable((false));
        dueDatePicker.setDisable(false);
        OkNewToDoButton.setDisable(false);
        createNewButton.setDisable(true);
        dueDatePicker.setDisable(false);

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
