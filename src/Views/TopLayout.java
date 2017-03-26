/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import ViewInterface.ServerBasicInterface;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Damian Stępniak
 */
public class TopLayout {
    
    private ServerBasicInterface serverBasicInterface;
    private BorderPane pane;
    private Button startServer;
    private TextField port;
    private Button stopServer;
    
    public TopLayout(ServerBasicInterface serverBasicInterface) {
        this.serverBasicInterface = serverBasicInterface;
        pane = new BorderPane();
        pane.setRight(this.topRightBox());
        pane.setLeft(this.topLeftBox());
    }
    
    private int getPortNr() {
        if (port.getText() == null || port.getText().trim().equals("")) {
            throw new NullPointerException("Nie wprowadzono nr portu");
        }
        return Integer.valueOf(port.getText());
    }
    
    public BorderPane getPanel() {
        return pane;
    }
    
    private Button startButton() {
        startServer = new Button("Start");
        startServer.setPrefSize(100, 20);
        startServer.setStyle("-fx-background-color: #d6d6c2;");
        startServer.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    
                    serverBasicInterface.setPort(getPortNr());
                    serverBasicInterface.start();
                    
                    System.out.println("Server Start port : " + getPortNr());
                    stopServer.setDisable(false);
                    port.setStyle("-fx-background-color: #ffffff;");
                    port.setDisable(true);
                    startServer.setStyle("-fx-background-color: #ffff33;");
                    startServer.setDisable(true);
                    stopServer.setStyle("-fx-background-color: #d6d6c2;");
                    
                } catch (NullPointerException e) {
                    port.setStyle("-fx-background-color: #ff6666;");
                    JOptionPane.showMessageDialog(null, e.getMessage());
                } catch (NumberFormatException e) {
                    port.setStyle("-fx-background-color: #ff6666;");
                    JOptionPane.showMessageDialog(null, "Port : nie poprawne dane");
                } catch (Exception e) {
             //       JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        });
        return startServer;
    }
    
    private Button stopButton() {
        
        stopServer = new Button("Stop");
        stopServer.setPrefSize(100, 20);
        stopServer.setStyle("-fx-background-color: #d6d6c2;");
        stopServer.setDisable(true);
        stopServer.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                serverBasicInterface.stop();
                
                startServer.setDisable(false);
                stopServer.setDisable(true);
                port.setDisable(false);
                startServer.setStyle("-fx-background-color: #d6d6c2;");
                stopServer.setStyle("-fx-background-color: #ffff33;");
                System.out.println("Server Stop");
            }
        });
        return stopServer;
    }
    
    private TextField portTextField() {
        port = new TextField();
        port.setPrefSize(80, 20);
        return port;
    }
    
    private Label portLabel() {
        Label portLabel = new Label("Nr portu : ");
        portLabel.setPrefSize(60, 20);
        portLabel.setStyle("-fx-text-fill: #ffffff;");
        return portLabel;
    }
    
    private HBox topLeftBox() {
        HBox hboxLeft = new HBox();
        hboxLeft.setPadding(new Insets(15, 12, 15, 12));
        hboxLeft.setSpacing(10);
        hboxLeft.setStyle("-fx-background-color: #000000;");
        
        hboxLeft.getChildren().addAll(this.startButton(), this.stopButton());
        return hboxLeft;
    }
    
    private HBox topRightBox() {
        HBox hboxRight = new HBox();
        hboxRight.setPadding(new Insets(15, 12, 15, 12));
        hboxRight.setSpacing(10);
        hboxRight.setStyle("-fx-background-color: #000000;");
        
        hboxRight.getChildren().addAll(this.portLabel(), this.portTextField());
        return hboxRight;
    }
    
}
