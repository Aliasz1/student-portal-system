package Unclean;

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

		Student student_1 = new Student(111,"One", 20, "Male", 10, "123abc");
		Student student_2 = new Student(222,"Two", 22, "Female", 02, "abcabc");
		Student student_3 = new Student(333,"Three", 21, "female", 123, "121212");
		Student student_4 = new Student(444,"Four", 19, "others", 0321, "hello");
		Student student_5 = new Student(555,"Five", 20, "male", 012, "abcdef");
		
		Course course_1 = new Course(11,"C One");
		Course course_2 = new Course(22,"C Two");
		Course course_3 = new Course(33,"C Three");
		
		course_1.addStudent(student_1, student_5, student_2);
		course_2.addStudent(student_1, student_2, student_3, student_4, student_5);
		course_3.addStudent(student_1);
		
		List<Student> dbs = new ArrayList<Student>();
		List<Course> dbc = new ArrayList<Course>();
		
		db = new Database(dbs, dbc);
		db.addStudenttodb(student_1, student_2, student_3, student_4, student_5);
		db.addCoursetodb(course_1, course_2, course_3);
		
		try{
			Registry reg = LocateRegistry.createRegistry(1234);
	        reg.rebind("Access", new Access());
	        reg.rebind("SP", new StudentPortal());
	        System.out.println("Server started");
		} catch (Exception e){
			System.out.print(e.toString());
			}
		}

}