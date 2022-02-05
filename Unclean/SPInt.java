package Unclean;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import Lib.Student;

public interface SPInt extends Remote {
    public Student getme(int i) throws RemoteException;
    public List<Student> getall() throws RemoteException;
    public void addStdnt(Student s) throws RemoteException;
    public void delStdnt(int i) throws RemoteException;
}
