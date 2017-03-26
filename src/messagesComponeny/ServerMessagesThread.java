/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package messagesComponeny;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Damian Stępniak
 */
public class ServerMessagesThread extends ServerMessages implements Runnable {

    public ServerMessagesThread(){
        super();
    }
    
    @Override
    public void run() {
        while (true) {
            try {
              System.out.print("");
                super.send();
            } catch (IOException ex) {
                Logger.getLogger(ServerMessagesThread.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ServerMessagesThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
