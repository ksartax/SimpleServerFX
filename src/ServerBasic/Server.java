/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBasic;

import ClientServer.ClientThrow;
import RMI.RMIServer;
import ViewInterface.ServerBasicInterface;
import java.io.IOException;
import java.net.Socket;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ListView;
import messagesComponeny.ServerMessagesThread;

/**
 *
 * @author Damian Stępniak
 */
public class Server extends ServerConnectUsers implements Runnable, ServerBasicInterface {

    private ServerMessagesThread serverMessages;
    private RMIServer rMIServer;
    private Registry req;

    public Server(int port) throws Exception {
        super(port);
    }

    public Server() {
    }

    @Override
    public void run() {
        serverMessages = new ServerMessagesThread();
        //
        Thread t = new Thread(serverMessages);
        t.start();
        while (true) {
            try {
                Socket pom = super.setConnectUser();
                ClientThrow pomThrow = new ClientThrow("Incognito", pom);
                pomThrow.setName("Incognito");
                serverMessages.setClient(pomThrow);
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void start() {
        try {
            super.initConnection();
            new Thread(this).start();
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stop() {
        try {
            super.closeConnection();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setPort(int port) throws Exception {
        super.setPort(port);
    }

    @Override
    public void sendGlobalMessages(String text) {
        try {
            serverMessages.send(text);
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<ClientThrow> getClientThrows() {
        return serverMessages.getClientThrows();
    }

}
