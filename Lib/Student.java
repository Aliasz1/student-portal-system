package Lib;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;

import Clean.SPServer;
		
public class Student implements Serializable {
	
		int ID;
		String name;
		int age;
		String gender;
		int contact;
		String password;
		
		public Student(int i, String s, int a, String g, int c, String p) throws RemoteException {
			ID = i;
			name = s;
			age = a;
			contact = c;
			password = p;
			
			if(g.equals("Male") || g.equals("male")) {
				gender = "Male";
			}
			else if(g.equals("Female") || g.equals("female")){
				gender = "Female";
				} 
			else {
				gender = "Others";
			}
		}

		public Student() throws RemoteException {
		}

		public int getID() {
			return ID;
		}
		
		public void setID(int i) {
			ID = i;
			System.out.println("ID set as " + ID);
		}
		
		public String getStudentName() {
			return name;
		}
		
		public void setStudentName(String s) {
			name = s;
			System.out.println("Name set as " + name);
		}
		public int getAge() {
			return age;
		}
		
		public void setAge(int i) {
			age = i;
			System.out.println("Age set as " + age);
		}
		
		public String getGender() {
			return gender;
			}
		
		public void setGender(String s) {
			if(s.equals("Male") || s.equals("male")) {
				gender = "Male";
			}
			else if(s.equals("Female") || s.equals("female")){
				gender = "Female";
				} 
			else {
				gender = "Others";
				}
			System.out.println("Gender set as " + gender);
			}
		
		public int getContact() {
			return contact;
		}
		
		public void setContact(int i) {
			age = i;
			System.out.println("Contact set as " + age);
		}
		
		public String getPassword() {
			return password;
			}

		public void enrollCourse(Student s, int i){
			List<Course> courses = SPServer.db.dbcourse;
			for(Course c : courses){
				if(c.code == i){
					c.addStudent(s);
				}
			}
		}
	}
