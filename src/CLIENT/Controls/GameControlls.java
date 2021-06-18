package CLIENT.Controls;

import CLIENT.Main.CLIENT;
import CLIENT.Main.Game;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GameControlls extends ClientController{
    private Socket socket;
    private DataOutputStream dout;
    private DataInputStream din;
    private Game game;

    @FXML
    TextField messageField;

    @FXML
    TextArea GameChat;

    public void initialize(){
        try {
            socket = new Socket("localhost",2115);
            if(socket.isClosed())
                GameChat.appendText("You are not Connected to any server!");
            dout = new DataOutputStream(socket.getOutputStream());
            din = new DataInputStream(socket.getInputStream());
            game = new Game(socket,dout);
            game.setNickname("Player 1");
            //game.sendGreeting(dout);
            new Thread(()->{
                while(!socket.isClosed()){
                    try{
                        GameChat.appendText(din.readUTF() + "\n");
                    }
                    catch(IOException ex){
                        ex.getMessage();
                    }
                }
            }).start();
        }
        catch(IOException ex){
            ex.getMessage();
        }

    }

    @FXML
    public void actionSendButton(ActionEvent event){
        game.sendMessage(messageField.getText(),dout);
        GameChat.appendText("You: " + messageField.getText() + "\n");
        messageField.clear();
    }

}
