/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBasic;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Damian Stępniak
 */
public class ServerConnectUsers extends ServerCoreAbstract {

    public ServerConnectUsers(int port) throws Exception {
        super(port);
    }

    public ServerConnectUsers() {
    }

    public Socket setConnectUser() throws IOException {
        if (super.serverSocket == null) {
            throw new NullPointerException();
        }
        super.socket = this.serverSocket.accept();
        log.info("Server Connect user");
        return super.socket;
    }

}
