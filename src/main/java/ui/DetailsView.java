package ui;

import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import model.Person;

public class DetailsView extends VBox {
	private DetailsViewController controller;
	private Person currentPerson;

	private Label firstNameLabel;
	private Label lastNameLabel;

	private Label firstNameValueLabel;
	private Label lastNameValueLabel;

	private TextField firstNameTextField;
	private TextField lastNameTextField;

	public DetailsView(DetailsViewController dvController, Person person) {
		this.controller = dvController;
		this.currentPerson = person;
		build();
		addListeners();
	}

	private void build() {
		firstNameLabel = new Label("First name:");
		lastNameLabel = new Label("Last name:");
		firstNameValueLabel = new Label(currentPerson.getFirstName());
		lastNameValueLabel = new Label(currentPerson.getLastName());

		this.getChildren().addAll(firstNameLabel, firstNameValueLabel,
				lastNameLabel, lastNameValueLabel);

		firstNameTextField = new TextField();
		firstNameTextField.focusedProperty()
				.addListener(
						(ObservableValue<? extends Boolean> ov, Boolean t,
								Boolean t1) -> {
							if (t1) {

							} else {
								this.controller.changePersonFirstName(
										currentPerson,
										firstNameTextField.getText());
							}
						});
		lastNameTextField = new TextField();

		this.getChildren().addAll(firstNameTextField, lastNameTextField);
	}

	public DetailsViewController getController() {
		return controller;
	}

	private void addListeners() {
		currentPerson.getFirstNameProperty().addListener(
				(ObservableValue<? extends String> ov, String oldValue,
						String newValue) -> {
					firstNameValueLabel.setText(newValue);
				});

		currentPerson.getContacts().addListener(
				new ListChangeListener<Person>() {

					@Override
					public void onChanged(
							javafx.collections.ListChangeListener.Change<? extends Person> c) {
						while (c.next()) {
							if (c.wasPermutated()) {
								for (int i = c.getFrom(); i < c.getTo(); ++i) {
									// permutate
								}
							} else if (c.wasUpdated()) {
								// update item
							} else {
								for (Person remitem : c.getRemoved()) {
									// On remove
								}
								for (Person additem : c.getAddedSubList()) {
									// On add
								}
							}
						}
					}

				});
	}
}
