/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;


import ServerBasic.Server;
import ViewInterface.ServerBasicInterface;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Damian Stępniak
 */
public class main extends Application {

    private BorderPanel panel;
    private ServerBasicInterface serverBasicInterface;

    @Override
    public void start(Stage primaryStage) {

        try {
            serverBasicInterface = new Server();

            panel = new BorderPanel();
            panel.setTop(new TopLayout(serverBasicInterface).getPanel());
            panel.setLeft(new LeftLayout(serverBasicInterface).addVBox());
            panel.setCeter(new CenterLayout(serverBasicInterface).addGridPane());

            Scene scene = new Scene(panel.getPanel(), 600, 550);

            primaryStage.setTitle("Server");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
