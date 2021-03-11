package model;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

public class Model {

    private final String prhoneNumber = "111123";
    private IConnect remote;

    public void connectToServer(){
        String host = "localhost";

        try{
             remote = (IConnect) Naming.lookup("//" + host + ":1099/echo1");

            System.out.println(remote.getUserIdFromPhonNumber(prhoneNumber));
            remote.getContacts(prhoneNumber);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public String[] getContactList() throws RemoteException {

//        for (int i = 0; i < remote.getContacts(prhoneNumber).length; i++) {
//            System.out.println(remote.getContacts(prhoneNumber)[i]);
//        }

        return remote.getContacts(prhoneNumber);
    }

    public boolean sendMessage(String userToNumber, String message){

        System.out.println(userToNumber);
        try {
            remote.sendMessage(this.prhoneNumber, userToNumber, message);
        } catch (RemoteException e) {

            e.printStackTrace();
            return false;
        }

        return true;
    }

    public String getUserNumberFromName(String userName) throws Exception {

        return remote.getUserNumberFromName(userName);
    }

    public HashMap<String, String> getChats(String userToNumber) throws Exception {

        return remote.getChats(remote.getUserIdFromPhonNumber(this.prhoneNumber), remote.getUserIdFromPhonNumber(userToNumber));
    }

}
