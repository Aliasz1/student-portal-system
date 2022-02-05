package Lib;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class Database {
		
		List<Student> dbstudent = new ArrayList<Student>();
		List<Course> dbcourse = new ArrayList<Course>();
		
		public Database(List<Student> s, List<Course> c) throws RemoteException {
			dbstudent = s;
			dbcourse = c;
		}
		
		public Database() throws RemoteException {
		}

		public void addStudenttodb(Student... std) {
			for(Student s : std) {
			dbstudent.add(s);
			}
		}
		
		public void delStudentfromdb(int ID) {
			System.out.println(dbstudent.size());
				for(Student c : dbstudent){
					if (c.ID == ID){
						dbstudent.remove(ID);
					}
				}
			System.out.println(dbstudent.size());
		}
		
		public List<Student> getStudents() {
				return dbstudent;
			}

		public Student getClient(int i) throws RemoteException{
			Student s = new Student();
			for (Student x : dbstudent){
				if(x.getID() == i){
					s = x;
				}
			}
			return s;
		}
		
		public void addCoursetodb(Course... crs) {
			for(Course c : crs) {
				dbcourse.add(c);
			}
		}
		
		public void delCoursefromdb(Course... crs) {
			for(Course c : crs) {
				dbcourse.remove(c);
			}
		}
		
		public Course getCoursedb(int c) {
			Course r = null;
			for(Course s : dbcourse) {
				if(s.code == c) {
					r = s;
				}
				break;
			}
			return r;
		}

	}