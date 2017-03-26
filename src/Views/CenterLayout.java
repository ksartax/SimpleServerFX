/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import ViewInterface.ServerBasicInterface;
import java.awt.Font;
import java.awt.Image;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Damian Stępniak
 */
public class CenterLayout {

    private TextField textField;
    private Button send;
    private ServerBasicInterface serverBasicInterface;
    private TextArea cssEditorFld;

    public CenterLayout(ServerBasicInterface serverBasicInterface) {
        this.serverBasicInterface = serverBasicInterface;
    }

    public GridPane addGridPane() {

        GridPane grid = new GridPane();
        textField = new TextField();

        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10));

        Label label = new Label("    Wiadomosc Globalna");
        grid.add(label, 0, 0);

        cssEditorFld = new TextArea();
        cssEditorFld.setPrefRowCount(10);
        cssEditorFld.setPrefColumnCount(100);
        cssEditorFld.setWrapText(true);
        cssEditorFld.setPrefWidth(150);
        GridPane.setHalignment(cssEditorFld, HPos.CENTER);
        grid.add(cssEditorFld, 0, 1);

        grid.add(textField, 0, 2);

        grid.add(this.send(), 1, 2);

        return grid;
    }

    private boolean getDataToSend() {
        if (textField.getText() == null || textField.getText().trim().equals("")) {
            return false;
        } else {
            return true;
        }
    }

    private Button send() {
        send = new Button("Wyślij");
        send.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (getDataToSend()) {
                    cssEditorFld.setText(cssEditorFld.getText() + "\t" + textField.getText() + "\t");
                    serverBasicInterface.sendGlobalMessages(textField.getText());
                }
            }
        });
        return send;
    }

}
