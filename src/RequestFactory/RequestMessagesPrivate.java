/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactory;

import ClientServer.ClientThrow;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Damian Stępniak
 */
public class RequestMessagesPrivate extends RequestMessagesChangeNick {

    public RequestMessagesPrivate(ArrayList<ClientThrow> clientThrows) {
        super(clientThrows);
    }

    public void sendMessagesPrivate(String nick, String tresc, ClientThrow clientThrow) throws IOException {
        for (ClientThrow clientThrow2 : super.clientThrows) {
            if (clientThrow2.getName().equals(nick)) {
                clientThrow2.send(tresc, clientThrow);
            }
        }
    }

}
