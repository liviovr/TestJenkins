package model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ObservablePerson extends Person {
    private final StringProperty firstNameProperty;
    private final StringProperty lastNameProperty;
    private final ObservableList<Person> observableContacts;
    private Person decoratedPerson;

    public ObservablePerson(Person person) {
        super(person.getFirstName(), person.getLastName());
        this.decoratedPerson = person;
        this.firstNameProperty = new SimpleStringProperty(person.getFirstName());
        this.lastNameProperty = new SimpleStringProperty(person.getLastName());
        this.observableContacts = FXCollections.observableArrayList();
        for(Person contact: person.getContacts()) {
            this.addContact(contact);
        }
    }
    
    @Override
    public final String getFirstName() {
        return firstNameProperty.get();
    }
    
    @Override
    public final void setFirstName(String firstName) {
        this.firstNameProperty.set(firstName);
        this.decoratedPerson.setFirstName(firstName);
    }

    @Override
    public final String getLastName() {
        return lastNameProperty.get();
    }

    @Override
    public final void setLastName(String lastName) {
        this.lastNameProperty.set(lastName);
        this.decoratedPerson.setLastName(lastName);
    }

    public final StringProperty getFirstNameProperty() {
        return this.firstNameProperty;
    }
    
    public final StringProperty getLastNameProperty() {
        return this.lastNameProperty;
    }

    @Override
    public final void addContact(Person person) {
        this.observableContacts.add(person);
        this.decoratedPerson.addContact(person);
    }

    @Override
    public final boolean removeContact(Person person) {
        this.decoratedPerson.removeContact(person);
        return this.observableContacts.remove(person);
    }

    public final ObservableList<Person> getObservableContacts() {
        return this.observableContacts;
    }

    public Person getDecoratedPerson() {
        return decoratedPerson;
    }

}
