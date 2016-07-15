package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;


public class Controller {

        public TextArea toDoTaskView;
        public Button OkNewToDoButton;
        public ListView<Event> toDoList = new ListView<Event>();
        public TextField nameTextBox;
        public TextArea newToDoDescriptionTextArea;
        public DatePicker dueDatePicker;



        ObservableList<Event> data = FXCollections.observableArrayList();

        public void pressButton(ActionEvent event){

        }

        public void confirmNewTask(ActionEvent event) {

            OkNewToDoButton.setDisable(true);
            nameTextBox.setDisable(true);
            newToDoDescriptionTextArea.setDisable(true);
            


            dueDatePicker.setValue(LocalDate.now());

            LocalDate localDate = dueDatePicker.getValue();
            Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
            Date date = Date.from(instant);

            System.out.println(date + "\n" + instant + "\n" + localDate);

            Event toAddEvent = new Event(nameTextBox.getText(),date,date.toString(),newToDoDescriptionTextArea.getText());
            toDoList.getItems().add(toAddEvent);


//            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//           try {
//
//               Date date = formatter.parse(dateTextBox.getText());
//               Event eventToAddIntoListView = new Event(nameTextBox.getText(),date,dateTextBox.getText());
//               toDoList.getItems().add(eventToAddIntoListView);
//            }catch (ParseException e)
//            {
//                e.printStackTrace();
//            }





          /* newToDoDescriptionTextArea.setVisible(false);
            OkNewToDoButton.setVisible(false);
            nameTextBox.setVisible(false);
            dateTextBox.setVisible(false);
            //toDoList.
            */
        }

        public void createNewTask(ActionEvent event) {

//            toDoTaskView.setText("Guzik działa!!!");
            OkNewToDoButton.setDisable(false);
            nameTextBox.setDisable(false);
            newToDoDescriptionTextArea.setDisable((false));
            dueDatePicker.setDisable(false);
            OkNewToDoButton.setDisable(false);

/*
            newToDoDescriptionTextArea.setVisible(true);
            OkNewToDoButton.setVisible(true);
            nameTextBox.setVisible(true);
            dateTextBox.setVisible(true);

*/

        }
}
