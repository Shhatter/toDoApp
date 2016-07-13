package sample;

import java.sql.Time;
import java.util.Date;

/**
 * Created by Praca on 2016-07-10.
 */
public class Event {



    String name;
    Date creationDate;
    Date dueDate;
    String owner;
    int ownerId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    //String target;  podcele listy toDo - do rozkmienia
    //Time timer; // Możliwe że będzie to wykorzystane w przyszłości


    public Event(String _name,Date _creationDate,Date _dueDate,String _owner,int _ownerId) {
        name =_name;
        creationDate=_creationDate;
        dueDate=_dueDate;
        owner=_owner;
        int ownerId =_ownerId;
    }
}
