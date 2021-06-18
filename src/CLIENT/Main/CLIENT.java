package CLIENT.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CLIENT extends Application {

    public String nickname;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/clientGUI.fxml"));
        primaryStage.setTitle("Ships Game");
        primaryStage.setScene(new Scene(root, 603, 487));
        primaryStage.show();
    }
}
