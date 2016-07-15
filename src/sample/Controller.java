package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;
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
    // initialize your logic here: all @FXML variables will have been injected
    }
  //  ObservableList<Event> data = FXCollections.observableArrayList();

    public void pressButton(ActionEvent event){

    }

    public void confirmNewTask(ActionEvent event) {




        //dueDatePicker.setValue(LocalDate.now());

        LocalDate localDate = dueDatePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date date = Date.from(instant);

//        System.out.println(date + "\n" + instant + "\n" + localDate);

        Event toAddEvent = new Event(nameTextBox.getText(),date,localDate.toString(),newToDoDescriptionTextArea.getText());
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





}
