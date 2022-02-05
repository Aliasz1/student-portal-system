package Unclean;
import java.util.List;
import Lib.Database;
import Lib.Student;

public class Authentication {
	
	public static boolean auth(Database dblogin, int i, String pw) {
		boolean logged = false;
		try{
			List<Student> s = dblogin.getStudents();
			boolean checkid, checkpw;
			for(int x = 0; x < s.size(); x++) {
				Student check = s.get(x);
				checkid = check.getID() == i;
				checkpw = check.getPassword().equals(pw);
			 	if (checkid == true && checkpw == true) {
			 		logged = true;
			 	}
			}
			return logged;
		}
		catch (Exception e){
			System.out.print(e.toString());
			}
		return logged;
	}
}