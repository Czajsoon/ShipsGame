package SERVER.main;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class ServerAcceptPlayersThread {
    private ServerSocket socketServer;
    private ArrayList<Socket> playersSockets;
    private ArrayList<String> nicknames;
    private TextArea loggServ;

    public ServerAcceptPlayersThread(ServerSocket socketServer, ArrayList<Socket> playersSockets, TextArea loggServ){
        this.socketServer = socketServer;
        this.playersSockets = playersSockets;
        this.loggServ = loggServ;
        serverThread();
    }

    private void serverThread(){
        new Thread(() ->{
            int i = 1;
            try{
                while (playersSockets.size() != 2){
                    Socket client = this.socketServer.accept();
                    playersSockets.add(client);
                    loggServ.appendText(new Date() + " || New client " + playersSockets.size() + " connected!\n");
                }
                for(Socket s : playersSockets){
                    serverReciveMessages(s,i);
                    i++;
                }
            }
            catch(IOException ex){
                ex.getMessage();
            }
        }).start();
    }

    private void serverReciveMessages(Socket client,int clientNumber){
        new Thread( () ->{
            try{
                DataInputStream din = new DataInputStream(client.getInputStream());
                while(!socketServer.isClosed()){
                    String message = din.readUTF();
                    loggServ.appendText(new Date() + " || Player " + clientNumber + " message: " + message + "\n");
                    for(Socket s :playersSockets){
                        if(client != s){
                            sentToOtherPlayerMessage(s,message);
                        }
                    }
                }
            }
            catch(IOException ex){
                ex.getMessage();
            }
        }).start();
    }

    public void sentToOtherPlayerMessage(Socket oponentSocket,String message){
        try{
            DataOutputStream dout = new DataOutputStream(oponentSocket.getOutputStream());
            dout.writeUTF("Oponent: " + message);
        }
        catch(IOException ex){
            ex.getMessage();
        }
    }
}
