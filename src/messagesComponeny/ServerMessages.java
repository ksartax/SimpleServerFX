/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagesComponeny;

import ClientServer.ClientRequest;
import ClientServer.ClientThrow;
import ClientServer.CoreClientManager;
import RequestFactory.RequestMessagesFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damian Stępniak
 */
public class ServerMessages extends CoreClientManager {

    private RequestMessagesFactory requestMessagesFactory;

    public ServerMessages() {
        super();
        requestMessagesFactory = new RequestMessagesFactory(super.clientThrows);
    }

    public void send() throws IOException, Exception {
        String textSendRequest = "";
        for (int i = 0; i < super.clientThrows.size(); i++) {

            if (super.clientThrows.get(i).isReadySend == true) {

                String[] pom2 = super.clientThrows.get(i).getText().split("=");

                if (pom2[0].equals("disconect")) {

                    textSendRequest = super.clientThrows.get(i).getName() + " : " + "Rozlaczony";
                    for (ClientThrow clientThrow2 : super.clientThrows) {
                        clientThrow2.send(textSendRequest, super.clientThrows.get(i));
                    }
                    super.clientThrows.remove(i);

                } else {
                    requestMessagesFactory.setMessages(super.clientThrows.get(i).getText());
                    requestMessagesFactory.send(super.clientThrows.get(i));
                }

            } else if (super.clientThrows.get(i).isConnect == false) {
                textSendRequest = super.clientThrows.get(i).getName() + " : " + "Rozlaczony";
                removeClient(i);
                for (ClientThrow clientThrow2 : super.clientThrows) {
                    clientThrow2.send(textSendRequest, super.clientThrows.get(i));
                }
            }
        }
    }

    public void send(String text) throws IOException {
        for (ClientThrow clientThrow2 : super.clientThrows) {
            clientThrow2.send(text);
        }
    }

}
