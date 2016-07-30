package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Gui.fxml"));
        primaryStage.setTitle("To do application ");

        primaryStage.setScene(new Scene(root, 700, 600));
        primaryStage.show();
    }



    public static void main(String[] args) {

        launch(args);
    }
}
