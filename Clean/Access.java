package Clean;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Access extends UnicastRemoteObject implements AccessInterface {
	protected Access() throws RemoteException {
		super();
	}

	public boolean login(int studentid, String password) {
		return Authentication.auth(SPServer.db,studentid,password);
	}
}
