package SERVER.main;

import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerMake {
    private ServerSocket serverSocket;
    private ArrayList<Socket> playersSockets = new ArrayList<>();

    public ServerMake(int port){
        try{
            serverSocket = new ServerSocket(port);
        }
        catch(IOException ex){
            ex.getMessage();
        }
    }

    public boolean isRunning(){
        return !serverSocket.isClosed();
    }

    public void closeServerSocket(){
        try{
            serverSocket.close();
        }
        catch (IOException ex){
            ex.getMessage();
        }
    }

    public void acceptPlayers(TextArea loggServer){
        ServerAcceptPlayersThread serverAcceptPlayersThread = new ServerAcceptPlayersThread(serverSocket,playersSockets,loggServer);
    }

}
