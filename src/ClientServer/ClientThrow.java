/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClientServer;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Damian Stępniak
 */
public class ClientThrow extends ClientSend{

    private String name;

    public ClientThrow(String name, Socket socket) throws IOException {
        super(socket);
        this.name = name;
    }
}
