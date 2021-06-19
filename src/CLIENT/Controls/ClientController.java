package CLIENT.Controls;

import CLIENT.Main.CLIENT;
import CLIENT.Main.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientController {

    @FXML
    AnchorPane mainPane;

    @FXML
    Button joinButton;

    @FXML
    private void actionJoinButton(ActionEvent event){

            try{
                mainPane.getChildren().clear();
                mainPane.getChildren().add(FXMLLoader.load(getClass().getResource("../GUI/GameGui.fxml")));
            }
            catch (IOException ex){
                ex.getMessage();
            }

    }

}
