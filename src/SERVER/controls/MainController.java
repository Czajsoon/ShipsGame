package SERVER.controls;

import SERVER.main.ServerMake;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class MainController {

    private ServerMake server;


    @FXML
    private Button StopServerButton;

    @FXML
    private TextArea ServerLogs;

    @FXML
    private TextField PortServer;

    @FXML
    private Button ServerStartButton;

    @FXML
    private void StartServ(ActionEvent event){
        if(PortServer.getText().isEmpty()){
            ServerLogs.appendText("Port is empty! Insert port server!\n");
        }
        else{
            ServerStartButton.setDisable(true);
            StopServerButton.setDisable(false);
            PortServer.setEditable(false);
            server = new ServerMake(Integer.parseInt(PortServer.getText()));
            ServerLogs.appendText(new Date() + " || Server started on port: " + Integer.parseInt(PortServer.getText()) +"\n");
            server.acceptPlayers(ServerLogs);
        }
    }

    @FXML
    private void StopServer(ActionEvent event){
        if(server.isRunning()){
            ServerStartButton.setDisable(false);
            StopServerButton.setDisable(true);
            PortServer.setEditable(true);
            server.closeServerSocket();
            ServerLogs.appendText("Server has been stoped!\n");
        }
    }

    private void connectPlayer(){

    }

}
