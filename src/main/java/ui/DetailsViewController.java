package ui;

import model.Person;

public class DetailsViewController {

	public DetailsViewController() {

	}

	public void changePersonFirstName(Person person, String firstName) {
		person.setFirstName(firstName);
	}

}
