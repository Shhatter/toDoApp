package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

    public class Controller {

        public TextArea toDoTaskView;
        public Button OkNewToDoButton;
      //  public ListView<Event> ToDoList;

        public void pressButton(ActionEvent event){

        }

        public void confirmNewTask(ActionEvent event) {


        }

        public void createNewTask(ActionEvent event) {

            toDoTaskView.setText("Guzik działa!!!");
        }
}
