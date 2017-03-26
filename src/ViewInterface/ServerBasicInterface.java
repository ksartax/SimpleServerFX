/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewInterface;

import ClientServer.ClientThrow;
import RMI.RMIServer;
import java.util.ArrayList;
import javafx.scene.control.ListView;

/**
 *
 * @author Damian Stępniak
 */
public interface ServerBasicInterface {
    
    public void start();
    
    public void setPort(int port) throws Exception;
    
    public void stop();
    
    public void sendGlobalMessages(String text);
    
    public ArrayList<ClientThrow> getClientThrows();
    
}
