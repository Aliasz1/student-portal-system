import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class StudentPortal extends UnicastRemoteObject implements StudentPortalInt{

    Student s;

    protected StudentPortal() throws RemoteException {
        super();
    }
    
    public List<Student> getall() throws RemoteException{
        return SPServer.db.getStudents();
    }

    public Student getme(int i) throws RemoteException{
        s = SPServer.db.getClient(i);
        return s;
    }

    public void addStdnt(Student s) throws RemoteException{
        SPServer.db.addStudentdb(s);
    }

    public void delStdnt(int i) throws RemoteException{
        SPServer.db.delStudentdb(i);
    }
}
