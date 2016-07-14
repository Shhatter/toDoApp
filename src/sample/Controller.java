package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Controller {

        public TextArea toDoTaskView;
        public Button OkNewToDoButton;
        public ListView<Event> toDoList = new ListView<Event>();
        public TextField dateTextBox;
        public TextField nameTextBox;
        public TextArea newToDoDescriptionTextArea;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");

        ObservableList<Event> data = FXCollections.observableArrayList();

        public void pressButton(ActionEvent event){

        }

        public void confirmNewTask(ActionEvent event) {

            OkNewToDoButton.setDisable(true);
            nameTextBox.setDisable(true);
            dateTextBox.setDisable(true);
            newToDoDescriptionTextArea.setDisable(true);

            SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
           try {

               Date date = formatter.parse(dateTextBox.getText());
               Event eventToAddIntoListView = new Event(nameTextBox.getText(),date,dateTextBox.getText());
               toDoList.getItems().add(eventToAddIntoListView);
            }catch (ParseException e)
            {
                e.printStackTrace();
            }



          /* newToDoDescriptionTextArea.setVisible(false);
            OkNewToDoButton.setVisible(false);
            nameTextBox.setVisible(false);
            dateTextBox.setVisible(false);
            //toDoList.
            */
        }

        public void createNewTask(ActionEvent event) {

            toDoTaskView.setText("Guzik działa!!!");
            OkNewToDoButton.setDisable(false);
            nameTextBox.setDisable(false);
            dateTextBox.setDisable(false);
            newToDoDescriptionTextArea.setDisable((false));


           // toDoList.getItems().addd(new Event )

/*
            newToDoDescriptionTextArea.setVisible(true);
            OkNewToDoButton.setVisible(true);
            nameTextBox.setVisible(true);
            dateTextBox.setVisible(true);

*/

        }
}
