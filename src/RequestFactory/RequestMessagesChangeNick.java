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
public class RequestMessagesChangeNick extends RequestMessagesDisconect {

    public RequestMessagesChangeNick(ArrayList<ClientThrow> clientThrows) {
        super(clientThrows);
    }

    public void sendMessagesChangeNick(String nick, ClientThrow clientThrow) throws IOException {
        int i = 0;
        for (ClientThrow clientThrow2 : super.clientThrows) {
            if (clientThrow2.getName().equals(nick)) {
                i = 1;
            }
        }
        if (i == 0) {
            clientThrow.setName(nick);
            for (ClientThrow clientThrow2 : super.clientThrows) {
                clientThrow2.send(nick + " : " + "dolaczyla nowa osoba");
            }
        } else {
            clientThrow.send("Taka nazwa juz istnieje");
        }
    }

}
