import controller.Controller;

import java.rmi.RemoteException;

public class WhatsAppMain {
    public static void main(String[] args) throws RemoteException {
        Controller controller = new Controller("WhatsApp");
    }
}
