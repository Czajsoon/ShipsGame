package SERVER.main;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;

public class ServerAcceptPlayersThread {
    private ServerSocket socketServer;
    private ArrayList<Socket> playersSockets;

    public ServerAcceptPlayersThread(ServerSocket socketServer, ArrayList<Socket> playersSockets, TextArea loggServ){
        this.socketServer = socketServer;
        this.playersSockets = playersSockets;
        new Thread(() ->{
            try{
                while (playersSockets.size() != 2){
                    Socket client = socketServer.accept();
                    playersSockets.add(client);
                    loggServ.appendText(new Date() + " new client connected!");
                }
            }
            catch(IOException ex){

            }
        }).start();
//        startTask();
    }

    public void startTask(){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                runTask();
            }
        };
        Thread backgroundThread = new Thread(task);
        backgroundThread.setDaemon(true);
        backgroundThread.start();
    }

    public void runTask(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                while(playersSockets.size() != 2){
//            try{
//                Socket client = serverSocket.accept();
//                playersSockets.add(client);
//                loggServer.appendText("New client connected!");
//                serverChatThread.startTask();
//            }
//            catch (IOException ex){
//                ex.getMessage();
//            }
                }
            }
        });
    }
}
