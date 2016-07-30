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
    public TextField titleTextBox;
    public DatePicker dueDatePicker;
    public TextArea newToDoDescriptionTextArea;
    public Slider prioritySlider;
    public Button clearAllFields;
    public Button cancelButton;

    public ListView<String> toDoList = new ListView<String>();
    public List<Event> EventList = new ArrayList<Event>();
    public ObservableList<String> observableEventList = FXCollections.observableArrayList();


    void initData( List<Event> eventList, ObservableList<String> observableEventList) {

        EventList = eventList;
        this.observableEventList = observableEventList;
    }

    @Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        prioritySlider.setValue(2);


        // initialize your logic here: all @FXML variables will have been injected
    }



    @FXML
    public void confirmNewTaskToListAction(ActionEvent event) throws IOException{

        if (dueDatePicker.getValue() != null && titleTextBox.getText().isEmpty()==false && newToDoDescriptionTextArea.getText().isEmpty() ==false) {
            crateNewTaskOnTheList();
            sendDataToMainWindow(event);
        } else {
            Alert noDataAlert = new Alert(Alert.AlertType.WARNING, "Please fill all required fields");
            noDataAlert.showAndWait();
        }


    }




@FXML
    public void sendDataToMainWindow(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainGuiView.fxml"));
        loader.load();
        Parent root  = loader.getRoot();
        Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        appStage.setTitle("To do application ");
        Scene newTaskScene = new Scene(root);
        appStage.setScene(newTaskScene);
        Controller addElementToMainWIndow = loader.getController();
        addElementToMainWIndow.initData(EventList,observableEventList);
        addElementToMainWIndow.toDoList.refresh();
        addElementToMainWIndow.toDoList.setItems(observableEventList);
        appStage.show();
    }

    public void crateNewTaskOnTheList() {
        LocalDate localDate;
        localDate = dueDatePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);



        Event toAddEvent = new Event(titleTextBox.getText(), date, localDate.toString(), newToDoDescriptionTextArea.getText(),(int)  prioritySlider.getValue());
        EventList.add(toAddEvent);
        observableEventList.add(EventList.size()+" "+titleTextBox.getText() +" "+date+ " priority: "+(int) prioritySlider.getValue());
        toDoList.setItems(observableEventList);


    }


    public void clearFields(ActionEvent event){

        titleTextBox.setText("");
        newToDoDescriptionTextArea.setText("");
        dueDatePicker.setValue(null);
        prioritySlider.setValue(2);
    }

    public void cancelCreation(ActionEvent event)throws IOException {
        sendDataToMainWindow(event);
    }
}
