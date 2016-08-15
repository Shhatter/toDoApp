package ToDoApp;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;

/**
 * Created by Praca on 2016-08-14.
 */
public class DataContainer {

    private final ObservableList<Event> eventList = FXCollections.observableArrayList();
    private final ObjectProperty<Event> currentEvent = new SimpleObjectProperty<>(null);




    public void saveDataToFile(File s){
    }
    public void loadDataFromFIle(File s){
    }


}
