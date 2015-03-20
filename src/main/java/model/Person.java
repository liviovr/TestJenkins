package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Person {
    private StringProperty firstName;
    private StringProperty lastName;
    private ObservableList<Person> contacts;

    public Person(String firstName, String lastName) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.contacts = FXCollections.observableArrayList();
    }

    public final String getFirstName() {
        return firstName.get();
    }

    public final void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public final String getLastName() {
        return lastName.get();
    }

    public final void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public final StringProperty getFirstNameProperty() {
        return this.firstName;
    }

    public final void addContact(Person person) {
        this.contacts.add(person);
    }

    public final void removeContact(Person person) {
        this.contacts.remove(person);
    }

    public final ObservableList<Person> getContacts() {
        return this.contacts;
    }

}
