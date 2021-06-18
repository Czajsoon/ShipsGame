package SERVER.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SERVER extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/mainServerGUI.fxml"));
        primaryStage.setTitle("Ships Server");
        primaryStage.setScene(new Scene(root, 540, 410));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
