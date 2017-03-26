/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactory;

import ClientServer.ClientThrow;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damian Stępniak
 */
public class RequestMessagesDisconect extends RequestMessagesCore {

    public RequestMessagesDisconect(ArrayList<ClientThrow> clientThrows) {
        super(clientThrows);
    }

    public void sendMessagesDisconect(ClientThrow clientThrow) throws IOException {
        // try {
  //      System.out.print("");
        // Thread.sleep(50);
        for (int i = 0; i < super.clientThrows.size(); i++) {
            super.clientThrows.get(i).send(clientThrow.getName() + " : " + "Rozlaczony");
        }
        super.clientThrows.remove(clientThrow);
        //   } //catch (InterruptedException ex) {
        //  Logger.getLogger(RequestMessagesDisconect.class.getName()).log(Level.SEVERE, null, ex);
        // }
    }

}
