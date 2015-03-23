package ui;

import model.ObservablePerson;

public class DetailsViewController {

    public DetailsViewController() {

    }

    public final void changePersonFirstName(ObservablePerson person, String firstName) {
        person.setFirstName(firstName);
    }

}
