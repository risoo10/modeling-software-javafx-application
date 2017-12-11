package sample;

import javafx.beans.property.StringProperty;

/**
 * Created by Riso on 12/11/2017.
 */
public class Student {

    private StringProperty firstName;
    private StringProperty lastName;

    public Student(String firstName, String lastName) {
        this.firstName.set(firstName);
        this.lastName.set(lastName);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }
}
