package CLIENT.Controls;

import CLIENT.Main.CLIENT;
import CLIENT.Main.Game;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class GameControlls extends ClientController{
    @FXML
    private Button CB0x0;

    @FXML
    private Button CB0x1;

    @FXML
    private Button CB0x2;

    @FXML
    private Button CB0x3;

    @FXML
    private Button CB0x4;

    @FXML
    private Button CB0x5;

    @FXML
    private Button CB0x8;

    @FXML
    private Button CB0x6;

    @FXML
    private Button CB0x7;

    @FXML
    private Button CB0x9;

    @FXML
    private Button CB1x0;

    @FXML
    private Button CB1x1;

    @FXML
    private Button CB1x2;

    @FXML
    private Button CB1x3;

    @FXML
    private Button CB1x4;

    @FXML
    private Button CB1x5;

    @FXML
    private Button CB1x6;

    @FXML
    private Button CB1x7;

    @FXML
    private Button CB3x0;

    @FXML
    private Button CB2x6;

    @FXML
    private Button CB3x1;

    @FXML
    private Button CB3x2;

    @FXML
    private Button CB2x9;

    @FXML
    private Button CB2x7;

    @FXML
    private Button CB2x8;

    @FXML
    private Button CB3x3;

    @FXML
    private Button CB2x5;

    @FXML
    private Button CB2x4;

    @FXML
    private Button CB2x3;

    @FXML
    private Button CB2x2;

    @FXML
    private Button CB2x1;

    @FXML
    private Button CB2x0;

    @FXML
    private Button CB1x9;

    @FXML
    private Button CB1x8;

    @FXML
    private Button CB4x9;

    @FXML
    private Button CB4x8;

    @FXML
    private Button CB4x7;

    @FXML
    private Button CB4x6;

    @FXML
    private Button CB4x5;

    @FXML
    private Button CB4x4;

    @FXML
    private Button CB4x3;

    @FXML
    private Button CB4x2;

    @FXML
    private Button CB4x1;

    @FXML
    private Button CB4x0;

    @FXML
    private Button CB3x9;

    @FXML
    private Button CB3x8;

    @FXML
    private Button CB3x7;

    @FXML
    private Button CB3x6;

    @FXML
    private Button CB3x5;

    @FXML
    private Button CB3x4;

    @FXML
    private Button CB9x2;

    @FXML
    private Button CB9x1;

    @FXML
    private Button CB9x0;

    @FXML
    private Button CB8x9;

    @FXML
    private Button CB8x8;

    @FXML
    private Button CB8x7;

    @FXML
    private Button CB8x6;

    @FXML
    private Button CB8x5;

    @FXML
    private Button CB8x4;

    @FXML
    private Button CB8x3;

    @FXML
    private Button CB8x2;

    @FXML
    private Button CB8x1;

    @FXML
    private Button CB8x0;

    @FXML
    private Button CB7x9;

    @FXML
    private Button CB7x8;

    @FXML
    private Button CB7x7;

    @FXML
    private Button CB7x6;

    @FXML
    private Button CB7x5;

    @FXML
    private Button CB7x4;

    @FXML
    private Button CB7x3;

    @FXML
    private Button CB7x2;

    @FXML
    private Button CB7x1;

    @FXML
    private Button CB7x0;

    @FXML
    private Button CB6x9;

    @FXML
    private Button CB6x8;

    @FXML
    private Button CB6x7;

    @FXML
    private Button CB6x6;

    @FXML
    private Button CB6x5;

    @FXML
    private Button CB6x4;

    @FXML
    private Button CB6x3;

    @FXML
    private Button CB6x2;

    @FXML
    private Button CB6x1;

    @FXML
    private Button CB6x0;

    @FXML
    private Button CB5x9;

    @FXML
    private Button CB5x8;

    @FXML
    private Button CB5x7;

    @FXML
    private Button CB5x6;

    @FXML
    private Button CB5x5;

    @FXML
    private Button CB5x3;

    @FXML
    private Button CB5x4;

    @FXML
    private Button CB5x2;

    @FXML
    private Button CB5x1;

    @FXML
    private Button CB5x0;

    @FXML
    private Button CB9x9;

    @FXML
    private Button CB9x8;

    @FXML
    private Button CB9x7;

    @FXML
    private Button CB9x6;

    @FXML
    private Button CB9x5;

    @FXML
    private Button CB9x4;

    @FXML
    private Button CB9x3;

    private Socket socket;
    private DataOutputStream dout;
    private DataInputStream din;
    private Game game;


    @FXML
    TextField messageField;

    @FXML
    TextArea GameChat;

    @FXML
    Button clearButton;

    public void initialize(){
        try {
            socket = new Socket("localhost",2115);
            dout = new DataOutputStream(socket.getOutputStream());
            din = new DataInputStream(socket.getInputStream());
            game = new Game(socket,dout);
            chatThread();
        }
        catch(IOException ex){
            ex.getMessage();
        }

    }

    private void chatThread(){
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

    @FXML
    private void actionSendButton(ActionEvent event){
        if(!messageField.getText().isEmpty()){
            game.sendMessage(messageField.getText(),dout);
            GameChat.appendText("You: " + messageField.getText() + "\n");
            messageField.clear();
        }
    }

    @FXML
    public void SendEnter(KeyEvent event){
        if(event.getCode().equals(KeyCode.ENTER)){
            System.out.println("elo");
            game.sendMessage(messageField.getText(),dout);
            GameChat.appendText("You: " + messageField.getText() + "\n");
            messageField.clear();
        }
    }

    @FXML
    RadioButton radioButton4x1;

    @FXML
    RadioButton radioButton3x1;

    @FXML
    RadioButton radioButton2x1;

    @FXML
    RadioButton radioButton1x1;

    @FXML
    GridPane clientShipsGrid;

    @FXML
    private void handleClicked4x1(){
        radioButton3x1.setSelected(false);
        radioButton2x1.setSelected(false);
        radioButton1x1.setSelected(false);
    }

    @FXML
    private void handleClicked3x1(){
        radioButton4x1.setSelected(false);
        radioButton2x1.setSelected(false);
        radioButton1x1.setSelected(false);
    }

    @FXML
    private void handleClicked2x1(){
        radioButton3x1.setSelected(false);
        radioButton4x1.setSelected(false);
        radioButton1x1.setSelected(false);
    }

    @FXML
    private void handleClicked1x1(){
        radioButton3x1.setSelected(false);
        radioButton2x1.setSelected(false);
        radioButton4x1.setSelected(false);
    }



    @FXML
    CheckBox verticalSet;
//--------------------------------------- first row ------------------------------------------------------------//
    @FXML
    private void handleEn0x0(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
            case 1:{
                CB0x0.setStyle("-fx-background-color: BLACK");
                break;
            }
            case 2:{
                CB0x0.setStyle("-fx-background-color: BLACK");
                CB1x0.setStyle("-fx-background-color: BLACK");
                break;
            }
            case 3:{
                CB0x0.setStyle("-fx-background-color: BLACK");
                CB1x0.setStyle("-fx-background-color: BLACK");
                CB2x0.setStyle("-fx-background-color: BLACK");
                break;
            }
            case 4:{
                CB0x0.setStyle("-fx-background-color: BLACK");
                CB1x0.setStyle("-fx-background-color: BLACK");
                CB2x0.setStyle("-fx-background-color: BLACK");
                CB3x0.setStyle("-fx-background-color: BLACK");
                break;
            }
        }
        else
            switch (numberRadio){
            case 1:{
                CB0x0.setStyle("-fx-background-color: BLACK");
                break;
            }
            case 2:{
                CB0x0.setStyle("-fx-background-color: BLACK");
                CB0x1.setStyle("-fx-background-color: BLACK");
                break;
            }
            case 3:{
                CB0x0.setStyle("-fx-background-color: BLACK");
                CB0x1.setStyle("-fx-background-color: BLACK");
                CB0x2.setStyle("-fx-background-color: BLACK");
                break;
            }
            case 4:{
                CB0x0.setStyle("-fx-background-color: BLACK");
                CB0x1.setStyle("-fx-background-color: BLACK");
                CB0x2.setStyle("-fx-background-color: BLACK");
                CB0x3.setStyle("-fx-background-color: BLACK");
                break;
            }
        }
    }
    @FXML
    private void handleEx0x0(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
            case 1:{
                CB0x0.setStyle("-fx-background-color: WHITE");
                break;
            }
            case 2:{
                CB0x0.setStyle("-fx-background-color: WHITE");
                CB1x0.setStyle("-fx-background-color: WHITE");
                break;
            }
            case 3:{
                CB0x0.setStyle("-fx-background-color: WHITE");
                CB1x0.setStyle("-fx-background-color: WHITE");
                CB2x0.setStyle("-fx-background-color: WHITE");
                break;
            }
            case 4:{
                CB0x0.setStyle("-fx-background-color: WHITE");
                CB1x0.setStyle("-fx-background-color: WHITE");
                CB2x0.setStyle("-fx-background-color: WHITE");
                CB3x0.setStyle("-fx-background-color: WHITE");
                break;
            }
        }
        else
            switch (numberRadio){
            case 1:{
                CB0x0.setStyle("-fx-background-color: WHITE");
                break;
            }
            case 2:{
                CB0x0.setStyle("-fx-background-color: WHITE");
                CB0x1.setStyle("-fx-background-color: WHITE");
                break;
            }
            case 3:{
                CB0x0.setStyle("-fx-background-color: WHITE");
                CB0x1.setStyle("-fx-background-color: WHITE");
                CB0x2.setStyle("-fx-background-color: WHITE");
                break;
            }
            case 4:{
                CB0x0.setStyle("-fx-background-color: WHITE");
                CB0x1.setStyle("-fx-background-color: WHITE");
                CB0x2.setStyle("-fx-background-color: WHITE");
                CB0x3.setStyle("-fx-background-color: WHITE");
                break;
            }
        }
    }

    @FXML
    private void handleEn0x1(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
                case 1:{
                    CB0x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x1.setStyle("-fx-background-color: BLACK");
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x1.setStyle("-fx-background-color: BLACK");
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x1.setStyle("-fx-background-color: BLACK");
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB0x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x1.setStyle("-fx-background-color: BLACK");
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x1.setStyle("-fx-background-color: BLACK");
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x1.setStyle("-fx-background-color: BLACK");
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx0x1() {
        int numberRadio = 0;
        if (radioButton1x1.isSelected())
            numberRadio = 1;
        else if (radioButton2x1.isSelected())
            numberRadio = 2;
        else if (radioButton3x1.isSelected())
            numberRadio = 3;
        else if (radioButton4x1.isSelected())
            numberRadio = 4;
        if (verticalSet.isSelected())
            switch (numberRadio) {
                case 1: {
                    CB0x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x1.setStyle("-fx-background-color: WHITE");
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x1.setStyle("-fx-background-color: WHITE");
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x1.setStyle("-fx-background-color: WHITE");
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB0x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x1.setStyle("-fx-background-color: WHITE");
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x1.setStyle("-fx-background-color: WHITE");
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x1.setStyle("-fx-background-color: WHITE");
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn0x2(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
                case 1:{
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x2.setStyle("-fx-background-color: BLACK");
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx0x2() {
        int numberRadio = 0;
        if (radioButton1x1.isSelected())
            numberRadio = 1;
        else if (radioButton2x1.isSelected())
            numberRadio = 2;
        else if (radioButton3x1.isSelected())
            numberRadio = 3;
        else if (radioButton4x1.isSelected())
            numberRadio = 4;
        if (verticalSet.isSelected())
            switch (numberRadio) {
                case 1: {
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x2.setStyle("-fx-background-color: WHITE");
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn0x3(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
                case 1:{
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x3.setStyle("-fx-background-color: BLACK");
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx0x3() {
        int numberRadio = 0;
        if (radioButton1x1.isSelected())
            numberRadio = 1;
        else if (radioButton2x1.isSelected())
            numberRadio = 2;
        else if (radioButton3x1.isSelected())
            numberRadio = 3;
        else if (radioButton4x1.isSelected())
            numberRadio = 4;
        if (verticalSet.isSelected())
            switch (numberRadio) {
                case 1: {
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x3.setStyle("-fx-background-color: WHITE");
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn0x4(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
                case 1:{
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x4.setStyle("-fx-background-color: BLACK");
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx0x4() {
        int numberRadio = 0;
        if (radioButton1x1.isSelected())
            numberRadio = 1;
        else if (radioButton2x1.isSelected())
            numberRadio = 2;
        else if (radioButton3x1.isSelected())
            numberRadio = 3;
        else if (radioButton4x1.isSelected())
            numberRadio = 4;
        if (verticalSet.isSelected())
            switch (numberRadio) {
                case 1: {
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x4.setStyle("-fx-background-color: WHITE");
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn0x5(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
                case 1:{
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x5.setStyle("-fx-background-color: BLACK");
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx0x5() {
        int numberRadio = 0;
        if (radioButton1x1.isSelected())
            numberRadio = 1;
        else if (radioButton2x1.isSelected())
            numberRadio = 2;
        else if (radioButton3x1.isSelected())
            numberRadio = 3;
        else if (radioButton4x1.isSelected())
            numberRadio = 4;
        if (verticalSet.isSelected())
            switch (numberRadio) {
                case 1: {
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x5.setStyle("-fx-background-color: WHITE");
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn0x6(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
                case 1:{
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x6.setStyle("-fx-background-color: BLACK");
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    CB0x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx0x6() {
        int numberRadio = 0;
        if (radioButton1x1.isSelected())
            numberRadio = 1;
        else if (radioButton2x1.isSelected())
            numberRadio = 2;
        else if (radioButton3x1.isSelected())
            numberRadio = 3;
        else if (radioButton4x1.isSelected())
            numberRadio = 4;
        if (verticalSet.isSelected())
            switch (numberRadio) {
                case 1: {
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x6.setStyle("-fx-background-color: WHITE");
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn0x7(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
                case 1:{
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x7.setStyle("-fx-background-color: BLACK");
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    CB0x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x7.setStyle("-fx-background-color: RED");
                    CB0x8.setStyle("-fx-background-color: RED");
                    CB0x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx0x7() {
        int numberRadio = 0;
        if (radioButton1x1.isSelected())
            numberRadio = 1;
        else if (radioButton2x1.isSelected())
            numberRadio = 2;
        else if (radioButton3x1.isSelected())
            numberRadio = 3;
        else if (radioButton4x1.isSelected())
            numberRadio = 4;
        if (verticalSet.isSelected())
            switch (numberRadio) {
                case 1: {
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x7.setStyle("-fx-background-color: WHITE");
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn0x8(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
                case 1:{
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x8.setStyle("-fx-background-color: BLACK");
                    CB0x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x8.setStyle("-fx-background-color: RED");
                    CB0x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB0x8.setStyle("-fx-background-color: RED");
                    CB0x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx0x8(){
        int numberRadio = 0;
        if (radioButton1x1.isSelected())
            numberRadio = 1;
        else if (radioButton2x1.isSelected())
            numberRadio = 2;
        else if (radioButton3x1.isSelected())
            numberRadio = 3;
        else if (radioButton4x1.isSelected())
            numberRadio = 4;
        if (verticalSet.isSelected())
            switch (numberRadio) {
                case 1: {
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x8.setStyle("-fx-background-color: WHITE");
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn0x9(){
        int numberRadio = 0;
        if(radioButton1x1.isSelected())
            numberRadio = 1;
        else if(radioButton2x1.isSelected())
            numberRadio = 2;
        else if(radioButton3x1.isSelected())
            numberRadio = 3;
        else if(radioButton4x1.isSelected())
            numberRadio = 4;
        if(verticalSet.isSelected())
            switch (numberRadio){
                case 1:{
                    CB0x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x9.setStyle("-fx-background-color: BLACK");
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB0x9.setStyle("-fx-background-color: BLACK");
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB0x9.setStyle("-fx-background-color: BLACK");
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB0x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB0x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB0x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB0x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx0x9(){
        int numberRadio = 0;
        if (radioButton1x1.isSelected())
            numberRadio = 1;
        else if (radioButton2x1.isSelected())
            numberRadio = 2;
        else if (radioButton3x1.isSelected())
            numberRadio = 3;
        else if (radioButton4x1.isSelected())
            numberRadio = 4;
        if (verticalSet.isSelected())
            switch (numberRadio) {
                case 1: {
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {

                    CB0x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    //----------------------------- secound row -------------------------------------//


}
