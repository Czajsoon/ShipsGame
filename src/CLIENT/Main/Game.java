package CLIENT.Main;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Game{
    private Socket socket;
    private DataOutputStream dout;
    private String nickname;

    public Game(Socket socket,DataOutputStream dout) {
        this.socket = socket;
        this.dout = dout;
    }



    public void sendGreeting(DataOutputStream dout){
        try{
            dout.writeUTF("HI im client " + this.nickname);
        }
        catch(IOException ex){
            ex.getMessage();
        }
    }

    public void sendMessage(String textMessage,DataOutputStream dout){
        try{
            dout.writeUTF(textMessage);
        }
        catch (IOException ex){
            ex.getMessage();
        }
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }
}
