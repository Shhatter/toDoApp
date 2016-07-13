package sample;

/**
 * Created by Praca on 2016-07-10.
 */
public class UserProfile {

    String name; // Imię
    int id; // Nazwisko


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    UserProfile(String a, int b){
        name =a;
        id=b;


    }




}
