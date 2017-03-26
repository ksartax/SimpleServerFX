/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.util.ArrayList;
import RequestFactory.RequestMessagesFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damian Stępniak
 */
public class CoreClientManager {

    protected ArrayList<ClientThrow> clientThrows;

    public CoreClientManager() {
        clientThrows = new ArrayList<ClientThrow>();
    }

    public void setClient(ClientThrow clientThrow) {
        try {
            if (clientThrow == null) {
                System.err.println("NUll");
            }

            clientThrow.start();
            Thread.sleep(50);
            this.clientThrows.add(clientThrow);
        } catch (InterruptedException ex) {
            Logger.getLogger(CoreClientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<ClientThrow> getClientThrows() {
        return clientThrows;
    }

    public void removeClient(int id) {
        clientThrows.remove(id);
    }

}
