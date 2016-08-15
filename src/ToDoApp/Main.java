package ToDoApp;


import mainController.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainController.Controller;


public class Main extends Application {




    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader mainControllerLoader = new FXMLLoader();
        mainControllerLoader.setLocation(getClass().getResource("/mainController/MainGuiView.fxml"));
        mainControllerLoader.load();
        Parent root = mainControllerLoader.getRoot();



        DataContainer mainDataContainer = new DataContainer();
        Controller controller = new Controller();



        primaryStage.setTitle("To do application ");
        primaryStage.setScene(new Scene(root, 1001, 767));

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
