package Clean;
import java.rmi.*;
import java.rmi.Remote;

// Creating Remote interface for our application
public interface AccessInterface extends Remote {
	public boolean login(int studentid, String password) throws RemoteException;
}