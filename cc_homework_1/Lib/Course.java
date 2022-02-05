package Lib;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Course {
		int code;
		String name;
		List<Student> students = new ArrayList<Student>();
		
		public Course(int c, String n) throws RemoteException {
			code = c;
			name = n;
		}
		
		public Course() throws RemoteException {
		}
		
		public int getCode() {
			return code;
		}
		
		public void setCode(int s) {
			code = s;
		}
		
		public String getCourseName() {
			return name;
		}
		
		public void setCourseName(String s) {
			name = s;
		}
		
		public List<Student> getStudents() {
			return students;
		}
		
		public void addStudent(Student... stdnt) {
			for(Student s : stdnt) {
				students.add(s);
				}
			}
		
		public void delStudent(Student... stdnt) {
			for(Student s : stdnt) {
				students.remove(s);
				}
		}

	}