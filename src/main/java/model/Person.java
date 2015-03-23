package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Person 
 * @author livio.vanrymenant
 *
 */
public class Person {
    /**
     * First name of the person
     */
    private String firstName;
    /*
     * Last name of the person
     */
    private String lastName;
    private List<Person> contacts;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contacts = new ArrayList<Person>();
    }
    
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addContact(Person person) {
        this.contacts.add(person);
    }
    
    public boolean removeContact(Person person) {
        return this.contacts.remove(person);
    }
    
    public List<Person> getContacts() {
        return this.contacts;
    }

}
