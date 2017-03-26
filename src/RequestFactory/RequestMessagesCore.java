/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RequestFactory;

import ClientServer.ClientThrow;
import java.util.ArrayList;

/**
 *
 * @author Damian Stępniak
 */
public class RequestMessagesCore {

    protected String requestMessages;
    protected ArrayList<ClientThrow> clientThrows;
    
    public RequestMessagesCore(ArrayList<ClientThrow> clientThrows){
        this.clientThrows = clientThrows;
    }

    public void setMessages(String meString) {
        this.requestMessages = meString;
    }

    public String getRequestMessages() {
        return this.requestMessages;
    }
}
