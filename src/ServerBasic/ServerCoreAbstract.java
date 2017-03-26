/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerBasic;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damian Stępniak
 */
public abstract class ServerCoreAbstract {

    protected boolean isStopped = false;
    protected int port = -1;
    protected ServerSocket serverSocket;
    protected Socket socket;
    protected final static Logger log = Logger.getLogger(ServerCoreAbstract.class.getName());

    public ServerCoreAbstract(int port) throws Exception {
        this.port = port;
    }

    protected synchronized boolean isStopped() {
        return this.isStopped;
    }

    public ServerCoreAbstract() {
    }

    public void setPort(int port) throws Exception {
        this.port = port;
    }

    public void initConnection() throws Exception {
        if (port == -1) {
            throw new Exception("Brak Portu");
        }
        log.info("Server Start");
        this.serverSocket = new ServerSocket(port);
    }

    public void closeConnection() throws IOException {
        if (this.serverSocket == null) {
            throw new NullPointerException();
        }
        this.isStopped = true;
        log.info("Server Close");
        this.serverSocket.close();
    }

}
