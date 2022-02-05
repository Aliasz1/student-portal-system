package Clean;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

import Lib.Course;
import Lib.Database;
import Lib.Student;

public class SPServer implements Remote {
	public static Database db = null;
	
	public static void main(String args[]) throws RemoteException {

		Student s1 = new Student(111,"One", 20, "Male", 10, "123abc");
		Student s2 = new Student(222,"Two", 22, "Female", 02, "abcabc");
		Student s3 = new Student(333,"Three", 21, "female", 123, "121212");
		Student s4 = new Student(444,"Four", 19, "others", 0321, "hello");
		Student s5 = new Student(555,"Five", 20, "male", 012, "abcdef");
		
		Course c1 = new Course(11,"C One");
		Course c2 = new Course(22,"C Two");
		Course c3 = new Course(33,"C Three");
		
		c1.addStudent(s5,s2,s1);
		c2.addStudent(s1,s2,s4,s3,s5);
		c3.addStudent(s1);
		
		List<Student> dbstudent = new ArrayList<Student>();
		List<Course> dbcourse = new ArrayList<Course>();
		
		db = new Database(dbstudent, dbcourse);
		db.addStudenttodb(s1,s2,s3,s4,s5);
		db.addCoursetodb(c1,c2,c3);
		
		try{
			Registry reg = LocateRegistry.createRegistry(1234);
	        reg.rebind("Access", new Access());
	        reg.rebind("StudentPortal", new StudentPortal());
	        System.out.println("Server started");
		} catch (Exception e){
			System.out.print(e.toString());
			}
		}

}