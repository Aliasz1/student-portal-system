package Unclean;
import java.rmi.*;
import java.rmi.Remote;

// Creating Remote interface for our application
public interface AccessInt extends Remote {
	public boolean login(int i, String pw) throws RemoteException;
}