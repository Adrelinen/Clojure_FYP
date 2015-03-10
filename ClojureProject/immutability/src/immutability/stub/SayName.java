package stub;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SayName extends Remote {
      String Name() throws RemoteException;
}