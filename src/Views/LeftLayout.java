/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import ClientServer.ClientThrow;
import RMI.RMIServer;
import ViewInterface.ServerBasicInterface;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Damian Stępniak
 */
public class LeftLayout extends Thread {

    private ServerBasicInterface serverBasicInterface;
    private ListView listView;
    Registry reg;
    RMIServer rMIServer;

    public LeftLayout(ServerBasicInterface serverBasicInterface) {
        this.serverBasicInterface = serverBasicInterface;
        this.setPriority(MAX_PRIORITY);
        this.start();
    }

    public VBox addVBox() {
        listView = new ListView();
        listView.setPrefSize(226, 550);
        VBox vbox = new VBox(listView);
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);
        return vbox;
    }

    @Override
    public void run() {
        try {
            reg = LocateRegistry.createRegistry(1000);
            rMIServer = new RMIServer();
            reg.rebind("server", rMIServer);
            while (true) {
              System.out.print("");
                try {
                    if (serverBasicInterface.getClientThrows() != null) {
                        // if (serverBasicInterface.getClientThrows().size() != listView.getItems().size()) {
                        this.sleep(5000);
                        System.out.print("");
                        
                        listView.getItems().clear();
                        rMIServer.remove();
                        for (ClientThrow clientThrow : serverBasicInterface.getClientThrows()) {
                            rMIServer.setGet(clientThrow.getName());
                            setData(clientThrow.getName());
                        }
                    }
                    //  }
                } catch (NullPointerException e) {
                 //   System.err.print("");
                } catch (InterruptedException ex) {
                    Logger.getLogger(LeftLayout.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (RemoteException ex) {
            Logger.getLogger(LeftLayout.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setData(String name) {
        listView.getItems().add(name);
    }

    public void remove() {
        for (int i = 0; i < listView.getItems().size(); i++) {
            listView.getItems().remove(i);
        }
    }

}
