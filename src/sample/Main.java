package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {



    public ListView<Event> toDoList = new ListView<Event>();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));
        primaryStage.setTitle("To do application ");

        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
    }

//    public void  showNewTaskScene(Stage primaryStage) throws IOException {
////        FXMLLoader loader = new FXMLLoader();
////        loader.setLocation(Main.class.getResource("newTaskView.fxml"));
//        Parent root =FXMLLoader.load(getClass().getResource("newTaskView.fxml"));
//        primaryStage.setTitle("To do application");
//        primaryStage.setScene(new Scene(root,700,600));
//        primaryStage.show();
//
//    }
    public static void main(String[] args) {

        launch(args);
    }
}
