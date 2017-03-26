/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author Damian Stępniak
 */
public class ClientRequest extends Thread {

    protected String text = "";
    protected InputStream in;
    protected Socket socket;
    public boolean isReadySend = false;
    public boolean isConnect = true;

    public ClientRequest(Socket socket) throws IOException {
        this.socket = socket;
        in = socket.getInputStream();
    }

    public String getText() throws Exception {
        isReadySend = false;
        return text;
    }

    @Override
    public void run() {
        while (isConnect) {
            try {
                int k;
                System.out.print("");
                String textPom = "";
                while ((k = in.read()) != -1 && k != '\n') {
                    textPom = textPom + (char) k;
                }
                text = textPom;
                isReadySend = true;
            } catch (Exception e) {
                isConnect = false;
            }
        }
    }

}
