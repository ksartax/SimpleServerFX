/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damian Stępniak
 */
public class ClientSend extends ClientRequest {

    private OutputStream out;

    public ClientSend(Socket socket) throws IOException {
        super(socket);
        out = socket.getOutputStream();
    }

    public void send(String text, ClientThrow clientThrow) throws IOException {
        if (!text.equals("")) {
            out.write((clientThrow.getName() + " : " + text).getBytes());
            out.write("\n".getBytes());
        }
    }
    
    public void send(String text) throws IOException {
        if (!text.equals("")) {
            out.write(("Server" + " : " + text).getBytes());
            out.write("\n".getBytes());
        }
    }

}
