package general;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Person;
import ui.DetailsView;
import ui.DetailsViewController;

public class Main extends Application {
    private final Group root = new Group();

    private final double sceneWidth = 1024;
    private final double sceneHeight = 768;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {
        Scene scene = new Scene(root, sceneWidth, sceneHeight, true);
        scene.setFill(Color.GRAY);

        Person person = new Person("Tester", "Test");
        DetailsViewController dvController = new DetailsViewController();
        DetailsView view = new DetailsView(dvController, person);
        root.getChildren().add(view);
        Button button = new Button("Print");
        button.setOnAction((ActionEvent ev)-> {
            System.out.println(person.getFirstName());
        });

        root.getChildren().add(button);

        primaryStage.setTitle("Jeninks Test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}