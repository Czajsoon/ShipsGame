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

    @FXML
    private void handleEn1x0(){
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
                    CB1x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x0.setStyle("-fx-background-color: BLACK");
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x0.setStyle("-fx-background-color: BLACK");
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x0.setStyle("-fx-background-color: BLACK");
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB1x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x0.setStyle("-fx-background-color: BLACK");
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x0.setStyle("-fx-background-color: BLACK");
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x0.setStyle("-fx-background-color: BLACK");
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx1x0() {
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
                    CB1x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x0.setStyle("-fx-background-color: WHITE");
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x0.setStyle("-fx-background-color: WHITE");
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x0.setStyle("-fx-background-color: WHITE");
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB1x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x0.setStyle("-fx-background-color: WHITE");
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x0.setStyle("-fx-background-color: WHITE");
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x0.setStyle("-fx-background-color: WHITE");
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn1x1(){
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
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x1.setStyle("-fx-background-color: BLACK");
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx1x1() {
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
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x1.setStyle("-fx-background-color: WHITE");
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn1x2(){
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
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x2.setStyle("-fx-background-color: BLACK");
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx1x2() {
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
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x2.setStyle("-fx-background-color: WHITE");
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn1x3(){
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
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x3.setStyle("-fx-background-color: BLACK");
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx1x3() {
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
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x3.setStyle("-fx-background-color: WHITE");
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn1x4(){
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
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x4.setStyle("-fx-background-color: BLACK");
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx1x4() {
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
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x4.setStyle("-fx-background-color: WHITE");
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn1x5(){
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
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x5.setStyle("-fx-background-color: BLACK");
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx1x5() {
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
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x5.setStyle("-fx-background-color: WHITE");
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn1x6(){
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
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x6.setStyle("-fx-background-color: BLACK");
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx1x6() {
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
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x6.setStyle("-fx-background-color: WHITE");
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn1x7(){
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
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x7.setStyle("-fx-background-color: BLACK");
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x7.setStyle("-fx-background-color: RED");
                    CB1x8.setStyle("-fx-background-color: RED");
                    CB1x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx1x7() {
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
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x7.setStyle("-fx-background-color: WHITE");
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn1x8(){
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
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x8.setStyle("-fx-background-color: BLACK");
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x8.setStyle("-fx-background-color: RED");
                    CB1x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB1x8.setStyle("-fx-background-color: RED");
                    CB1x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx1x8(){
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
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x8.setStyle("-fx-background-color: WHITE");
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn1x9(){
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
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB1x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB1x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB1x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB1x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx1x9(){
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
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB1x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    //-------------------------------------- third row -------------------------------------------//

    @FXML
    private void handleEn2x0(){
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
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x0.setStyle("-fx-background-color: BLACK");
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx2x0() {
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
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x0.setStyle("-fx-background-color: WHITE");
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn2x1(){
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
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x1.setStyle("-fx-background-color: BLACK");
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx2x1() {
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
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x1.setStyle("-fx-background-color: WHITE");
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn2x2(){
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
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x2.setStyle("-fx-background-color: BLACK");
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx2x2() {
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
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x2.setStyle("-fx-background-color: WHITE");
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn2x3(){
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
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x3.setStyle("-fx-background-color: BLACK");
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx2x3() {
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
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x3.setStyle("-fx-background-color: WHITE");
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn2x4(){
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
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x4.setStyle("-fx-background-color: BLACK");
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx2x4() {
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
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x4.setStyle("-fx-background-color: WHITE");
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn2x5(){
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
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x5.setStyle("-fx-background-color: BLACK");
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx2x5() {
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
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x5.setStyle("-fx-background-color: WHITE");
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn2x6(){
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
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x6.setStyle("-fx-background-color: BLACK");
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx2x6() {
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
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x6.setStyle("-fx-background-color: WHITE");
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn2x7(){
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
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x7.setStyle("-fx-background-color: BLACK");
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x7.setStyle("-fx-background-color: RED");
                    CB2x8.setStyle("-fx-background-color: RED");
                    CB2x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx2x7() {
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
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x7.setStyle("-fx-background-color: WHITE");
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn2x8(){
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
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x8.setStyle("-fx-background-color: BLACK");
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x8.setStyle("-fx-background-color: RED");
                    CB2x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB2x8.setStyle("-fx-background-color: RED");
                    CB2x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx2x8(){
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
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x8.setStyle("-fx-background-color: WHITE");
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn2x9(){
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
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB2x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB2x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB2x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB2x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx2x9(){
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
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB2x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    //-----------------------------------------  fourth row --------------------------------------//

    @FXML
    private void handleEn3x0(){
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
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x0.setStyle("-fx-background-color: BLACK");
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx3x0() {
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
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x0.setStyle("-fx-background-color: WHITE");
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn3x1(){
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
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x1.setStyle("-fx-background-color: BLACK");
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx3x1() {
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
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x1.setStyle("-fx-background-color: WHITE");
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn3x2(){
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
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x2.setStyle("-fx-background-color: BLACK");
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx3x2() {
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
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x2.setStyle("-fx-background-color: WHITE");
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn3x3(){
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
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x3.setStyle("-fx-background-color: BLACK");
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx3x3() {
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
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x3.setStyle("-fx-background-color: WHITE");
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn3x4(){
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
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x4.setStyle("-fx-background-color: BLACK");
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx3x4() {
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
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x4.setStyle("-fx-background-color: WHITE");
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn3x5(){
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
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x5.setStyle("-fx-background-color: BLACK");
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx3x5() {
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
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x5.setStyle("-fx-background-color: WHITE");
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn3x6(){
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
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x6.setStyle("-fx-background-color: BLACK");
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx3x6() {
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
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x6.setStyle("-fx-background-color: WHITE");
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn3x7(){
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
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x7.setStyle("-fx-background-color: BLACK");
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x7.setStyle("-fx-background-color: RED");
                    CB3x8.setStyle("-fx-background-color: RED");
                    CB3x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx3x7() {
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
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x7.setStyle("-fx-background-color: WHITE");
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn3x8(){
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
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x8.setStyle("-fx-background-color: BLACK");
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x8.setStyle("-fx-background-color: RED");
                    CB3x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB3x8.setStyle("-fx-background-color: RED");
                    CB3x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx3x8(){
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
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x8.setStyle("-fx-background-color: WHITE");
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn3x9(){
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
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB3x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB3x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB3x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB3x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx3x9(){
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
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB3x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    // --------------------------------------- fifth row --------------------------------------//

    @FXML
    private void handleEn4x0(){
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
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x0.setStyle("-fx-background-color: BLACK");
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx4x0() {
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
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x0.setStyle("-fx-background-color: WHITE");
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn4x1(){
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
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x1.setStyle("-fx-background-color: BLACK");
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx4x1() {
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
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x1.setStyle("-fx-background-color: WHITE");
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn4x2(){
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
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x2.setStyle("-fx-background-color: BLACK");
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx4x2() {
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
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x2.setStyle("-fx-background-color: WHITE");
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn4x3(){
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
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x3.setStyle("-fx-background-color: BLACK");
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx4x3() {
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
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x3.setStyle("-fx-background-color: WHITE");
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn4x4(){
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
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x4.setStyle("-fx-background-color: BLACK");
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx4x4() {
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
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x4.setStyle("-fx-background-color: WHITE");
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn4x5(){
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
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x5.setStyle("-fx-background-color: BLACK");
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx4x5() {
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
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x5.setStyle("-fx-background-color: WHITE");
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn4x6(){
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
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x6.setStyle("-fx-background-color: BLACK");
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx4x6() {
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
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x6.setStyle("-fx-background-color: WHITE");
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn4x7(){
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
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x7.setStyle("-fx-background-color: BLACK");
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x7.setStyle("-fx-background-color: RED");
                    CB4x8.setStyle("-fx-background-color: RED");
                    CB4x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx4x7() {
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
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x7.setStyle("-fx-background-color: WHITE");
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn4x8(){
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
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x8.setStyle("-fx-background-color: BLACK");
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x8.setStyle("-fx-background-color: RED");
                    CB4x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB4x8.setStyle("-fx-background-color: RED");
                    CB4x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx4x8(){
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
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x8.setStyle("-fx-background-color: WHITE");
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn4x9(){
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
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB4x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB4x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB4x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB4x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx4x9(){
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
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio) {
                case 1: {
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2: {
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3: {
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4: {
                    CB4x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    // ------------------------------------------- sixth row -------------------------------------- //

    @FXML
    private void handleEn5x0(){
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
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x0.setStyle("-fx-background-color: BLACK");
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx5x0() {
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
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x0.setStyle("-fx-background-color: WHITE");
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn5x1(){
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
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x1.setStyle("-fx-background-color: BLACK");
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx5x1() {
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
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x1.setStyle("-fx-background-color: WHITE");
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn5x2(){
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
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x2.setStyle("-fx-background-color: BLACK");
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx5x2() {
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
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x2.setStyle("-fx-background-color: WHITE");
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn5x3(){
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
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x3.setStyle("-fx-background-color: BLACK");
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx5x3() {
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
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x3.setStyle("-fx-background-color: WHITE");
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn5x4(){
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
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x4.setStyle("-fx-background-color: BLACK");
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx5x4() {
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
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x4.setStyle("-fx-background-color: WHITE");
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn5x5(){
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
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x5.setStyle("-fx-background-color: BLACK");
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx5x5() {
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
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x5.setStyle("-fx-background-color: WHITE");
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn5x6(){
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
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x6.setStyle("-fx-background-color: BLACK");
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx5x6() {
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
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x6.setStyle("-fx-background-color: WHITE");
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn5x7(){
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
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x7.setStyle("-fx-background-color: BLACK");
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x7.setStyle("-fx-background-color: RED");
                    CB5x8.setStyle("-fx-background-color: RED");
                    CB5x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx5x7() {
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
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x7.setStyle("-fx-background-color: WHITE");
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn5x8(){
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
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x8.setStyle("-fx-background-color: BLACK");
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x8.setStyle("-fx-background-color: RED");
                    CB5x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB5x8.setStyle("-fx-background-color: RED");
                    CB5x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx5x8(){
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
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x8.setStyle("-fx-background-color: WHITE");
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn5x9(){
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
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB5x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB5x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB5x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx5x9(){
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
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB5x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    //---------------------------------------  seventh row ---------------------------------------//

    @FXML
    private void handleEn6x0(){
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
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    CB9x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x0.setStyle("-fx-background-color: BLACK");
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx6x0() {
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
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x0.setStyle("-fx-background-color: WHITE");
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn6x1(){
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
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x1.setStyle("-fx-background-color: BLACK");
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx6x1() {
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
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x1.setStyle("-fx-background-color: WHITE");
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn6x2(){
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
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x2.setStyle("-fx-background-color: BLACK");
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx6x2() {
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
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x2.setStyle("-fx-background-color: WHITE");
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn6x3(){
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
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x3.setStyle("-fx-background-color: BLACK");
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx6x3() {
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
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x3.setStyle("-fx-background-color: WHITE");
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn6x4(){
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
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x4.setStyle("-fx-background-color: BLACK");
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx6x4() {
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
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x4.setStyle("-fx-background-color: WHITE");
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn6x5(){
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
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x5.setStyle("-fx-background-color: BLACK");
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx6x5() {
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
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x5.setStyle("-fx-background-color: WHITE");
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn6x6(){
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
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x6.setStyle("-fx-background-color: BLACK");
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx6x6() {
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
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x6.setStyle("-fx-background-color: WHITE");
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn6x7(){
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
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x7.setStyle("-fx-background-color: BLACK");
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x7.setStyle("-fx-background-color: RED");
                    CB6x8.setStyle("-fx-background-color: RED");
                    CB6x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx6x7() {
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
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x7.setStyle("-fx-background-color: WHITE");
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn6x8(){
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
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x8.setStyle("-fx-background-color: BLACK");
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x8.setStyle("-fx-background-color: RED");
                    CB6x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB6x8.setStyle("-fx-background-color: RED");
                    CB6x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx6x8(){
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
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x8.setStyle("-fx-background-color: WHITE");
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn6x9(){
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
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    CB9x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB6x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB6x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB6x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx6x9(){
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
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB6x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    //------------------------------- eighth row ---------------------------------//

    @FXML
    private void handleEn7x0(){
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
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    CB9x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x0.setStyle("-fx-background-color: RED");
                    CB8x0.setStyle("-fx-background-color: RED");
                    CB9x0.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x0.setStyle("-fx-background-color: BLACK");
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx7x0() {
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
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x0.setStyle("-fx-background-color: WHITE");
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn7x1(){
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
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x1.setStyle("-fx-background-color: RED");
                    CB8x1.setStyle("-fx-background-color: RED");
                    CB9x1.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x1.setStyle("-fx-background-color: BLACK");
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx7x1() {
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
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x1.setStyle("-fx-background-color: WHITE");
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn7x2(){
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
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x2.setStyle("-fx-background-color: RED");
                    CB8x2.setStyle("-fx-background-color: RED");
                    CB9x2.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x2.setStyle("-fx-background-color: BLACK");
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx7x2() {
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
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x2.setStyle("-fx-background-color: WHITE");
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn7x3(){
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
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x3.setStyle("-fx-background-color: RED");
                    CB8x3.setStyle("-fx-background-color: RED");
                    CB9x3.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x3.setStyle("-fx-background-color: BLACK");
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx7x3() {
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
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x3.setStyle("-fx-background-color: WHITE");
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn7x4(){
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
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x4.setStyle("-fx-background-color: RED");
                    CB8x4.setStyle("-fx-background-color: RED");
                    CB9x4.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x4.setStyle("-fx-background-color: BLACK");
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx7x4() {
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
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x4.setStyle("-fx-background-color: WHITE");
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn7x5(){
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
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x5.setStyle("-fx-background-color: RED");
                    CB8x5.setStyle("-fx-background-color: RED");
                    CB9x5.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x5.setStyle("-fx-background-color: BLACK");
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx7x5() {
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
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x5.setStyle("-fx-background-color: WHITE");
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn7x6(){
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
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x6.setStyle("-fx-background-color: RED");
                    CB8x6.setStyle("-fx-background-color: RED");
                    CB9x6.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x6.setStyle("-fx-background-color: BLACK");
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx7x6() {
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
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x6.setStyle("-fx-background-color: WHITE");
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn7x7(){
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
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x7.setStyle("-fx-background-color: RED");
                    CB8x7.setStyle("-fx-background-color: RED");
                    CB9x7.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x7.setStyle("-fx-background-color: BLACK");
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x7.setStyle("-fx-background-color: RED");
                    CB7x8.setStyle("-fx-background-color: RED");
                    CB7x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx7x7() {
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
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x7.setStyle("-fx-background-color: WHITE");
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn7x8(){
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
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x8.setStyle("-fx-background-color: RED");
                    CB8x8.setStyle("-fx-background-color: RED");
                    CB9x8.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x8.setStyle("-fx-background-color: BLACK");
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x8.setStyle("-fx-background-color: RED");
                    CB7x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB7x8.setStyle("-fx-background-color: RED");
                    CB7x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx7x8(){
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
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x8.setStyle("-fx-background-color: WHITE");
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn7x9(){
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
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    CB9x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB7x9.setStyle("-fx-background-color: RED");
                    CB8x9.setStyle("-fx-background-color: RED");
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB7x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB7x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB7x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx7x9(){
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
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB7x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    //-------------------------------------------- nieneth row ----------------------------//

    @FXML
    private void handleEn8x0(){
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
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    CB9x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x0.setStyle("-fx-background-color: RED");
                    CB9x0.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x0.setStyle("-fx-background-color: RED");
                    CB9x0.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB8x0.setStyle("-fx-background-color: BLACK");
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx8x0() {
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
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x0.setStyle("-fx-background-color: WHITE");
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn8x1(){
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
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x1.setStyle("-fx-background-color: RED");
                    CB9x1.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x1.setStyle("-fx-background-color: RED");
                    CB9x1.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB8x1.setStyle("-fx-background-color: BLACK");
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx8x1() {
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
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x1.setStyle("-fx-background-color: WHITE");
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn8x2(){
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
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x2.setStyle("-fx-background-color: RED");
                    CB9x2.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x2.setStyle("-fx-background-color: RED");
                    CB9x2.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB8x2.setStyle("-fx-background-color: BLACK");
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx8x2() {
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
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x2.setStyle("-fx-background-color: WHITE");
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn8x3(){
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
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x3.setStyle("-fx-background-color: RED");
                    CB9x3.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x3.setStyle("-fx-background-color: RED");
                    CB9x3.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB8x3.setStyle("-fx-background-color: BLACK");
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx8x3() {
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
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x3.setStyle("-fx-background-color: WHITE");
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn8x4(){
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
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x4.setStyle("-fx-background-color: RED");
                    CB9x4.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x4.setStyle("-fx-background-color: RED");
                    CB9x4.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB8x4.setStyle("-fx-background-color: BLACK");
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx8x4() {
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
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x4.setStyle("-fx-background-color: WHITE");
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn8x5(){
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
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x5.setStyle("-fx-background-color: RED");
                    CB9x5.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x5.setStyle("-fx-background-color: RED");
                    CB9x5.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB8x5.setStyle("-fx-background-color: BLACK");
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx8x5() {
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
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x5.setStyle("-fx-background-color: WHITE");
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn8x6(){
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
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x6.setStyle("-fx-background-color: RED");
                    CB9x6.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x6.setStyle("-fx-background-color: RED");
                    CB9x6.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB8x6.setStyle("-fx-background-color: BLACK");
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx8x6() {
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
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x6.setStyle("-fx-background-color: WHITE");
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn8x7(){
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
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x7.setStyle("-fx-background-color: RED");
                    CB9x7.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x7.setStyle("-fx-background-color: RED");
                    CB9x7.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x7.setStyle("-fx-background-color: BLACK");
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB8x7.setStyle("-fx-background-color: RED");
                    CB8x8.setStyle("-fx-background-color: RED");
                    CB8x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx8x7() {
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
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x7.setStyle("-fx-background-color: WHITE");
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn8x8(){
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
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x8.setStyle("-fx-background-color: RED");
                    CB9x8.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x8.setStyle("-fx-background-color: RED");
                    CB9x8.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x8.setStyle("-fx-background-color: BLACK");
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x8.setStyle("-fx-background-color: RED");
                    CB8x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x8.setStyle("-fx-background-color: RED");
                    CB8x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx8x8(){
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
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x8.setStyle("-fx-background-color: WHITE");
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn8x9(){
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
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    CB9x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB8x9.setStyle("-fx-background-color: RED");
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x9.setStyle("-fx-background-color: RED");
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB8x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB8x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB8x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx8x9(){
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
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB8x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    //-------------------------------------------- tenth row ----------------------------//

    @FXML
    private void handleEn9x0(){
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
                    CB9x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x0.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x0.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x0.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x0.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x0.setStyle("-fx-background-color: BLACK");
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB9x0.setStyle("-fx-background-color: BLACK");
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB9x0.setStyle("-fx-background-color: BLACK");
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx9x0() {
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
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x0.setStyle("-fx-background-color: WHITE");
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn9x1(){
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
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x1.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x1.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x1.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB9x1.setStyle("-fx-background-color: BLACK");
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx9x1() {
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
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x1.setStyle("-fx-background-color: WHITE");
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn9x2(){
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
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x2.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x2.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x2.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB9x2.setStyle("-fx-background-color: BLACK");
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx9x2() {
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
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x2.setStyle("-fx-background-color: WHITE");
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn9x3(){
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
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x3.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x3.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x3.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB9x3.setStyle("-fx-background-color: BLACK");
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx9x3() {
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
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x3.setStyle("-fx-background-color: WHITE");
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn9x4(){
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
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x4.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x4.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x4.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB9x4.setStyle("-fx-background-color: BLACK");
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx9x4() {
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
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x4.setStyle("-fx-background-color: WHITE");
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn9x5(){
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
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x5.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x5.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x5.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB9x5.setStyle("-fx-background-color: BLACK");
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx9x5() {
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
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x5.setStyle("-fx-background-color: WHITE");
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn9x6(){
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
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x6.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x6.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x6.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB9x6.setStyle("-fx-background-color: BLACK");
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    CB9x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
            }
    }
    @FXML
    private void handleEx9x6() {
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
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x6.setStyle("-fx-background-color: WHITE");
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn9x7(){
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
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x7.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x7.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x7.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB9x7.setStyle("-fx-background-color: BLACK");
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    CB9x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 4:{
                    CB9x7.setStyle("-fx-background-color: RED");
                    CB9x8.setStyle("-fx-background-color: RED");
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx9x7() {
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
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x7.setStyle("-fx-background-color: WHITE");
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn9x8(){
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
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x8.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x8.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x8.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x8.setStyle("-fx-background-color: BLACK");
                    CB9x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 3:{
                    CB9x8.setStyle("-fx-background-color: RED");
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x8.setStyle("-fx-background-color: RED");
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx9x8(){
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
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x8.setStyle("-fx-background-color: WHITE");
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }

    @FXML
    private void handleEn9x9(){
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
                    CB9x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x9.setStyle("-fx-background-color: BLACK");
                    break;
                }
                case 2:{
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 3:{
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
                case 4:{
                    CB9x9.setStyle("-fx-background-color: RED");
                    break;
                }
            }
    }
    @FXML
    private void handleEx9x9(){
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
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
        else
            switch (numberRadio){
                case 1:{
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 2:{
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 3:{
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
                case 4:{
                    CB9x9.setStyle("-fx-background-color: WHITE");
                    break;
                }
            }
    }
}
