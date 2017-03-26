package RMI;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.LinkedList;
import javafx.scene.control.ListView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Damian Stępniak
 */
public class RMIServer extends UnicastRemoteObject implements RMI {

    private LinkedList<String> list;

    public RMIServer() throws RemoteException {
        super();
        list = new LinkedList<>();
    }

    @Override
    public LinkedList<String> get() throws RemoteException {
        return list;
    }

    @Override
    public void setGet(LinkedList s) throws RemoteException {
        this.list = s;
    }

    @Override
    public void setGet(String s) throws RemoteException {
        this.list.add(s);
    }

    @Override
    public void remove() {
        this.list = new LinkedList<>();
    }

}
