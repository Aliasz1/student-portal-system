import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Access extends UnicastRemoteObject implements AccessInt {
	protected Access() throws RemoteException {
		super();
	}

	public boolean login(int i, String pw) {
		return Authentication.auth(SPServer.db,i,pw);
	}
}
