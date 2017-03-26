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
public class RequestMessagesFactory extends RequestMessagesPrivate {

    private String[] pom;

    public RequestMessagesFactory(ArrayList<ClientThrow> clientThrows) {
        super(clientThrows);
    }

    public void send(ClientThrow clientThrow) throws IOException {
        try {
          System.out.print("");
            pom = super.getRequestMessages().split("=");
            if (pom[0].equals("private")) {
                super.sendMessagesPrivate(pom[1], pom[2], clientThrow);
            } else if (pom[0].equals("newNick")) {
                super.sendMessagesChangeNick(pom[1], clientThrow);
            } else {
                for (ClientThrow clientThrow2 : super.clientThrows) {
                    clientThrow2.send(super.getRequestMessages(), clientThrow);
                }
            }
        } catch (Exception e) {
            clientThrow.send("Error : " + e.getMessage());
        }
    }

}
