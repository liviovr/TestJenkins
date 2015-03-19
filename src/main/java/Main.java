import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application{
	final Group root = new Group();

	private final double sceneWidth = 1024;
	private final double sceneHeight = 768;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene scene = new Scene(root, sceneWidth, sceneHeight, true);
		scene.setFill(Color.GRAY);
		Label label = new Label("Testing jenkins");
		root.getChildren().add(label);
		primaryStage.setTitle("Jeninks Test");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
