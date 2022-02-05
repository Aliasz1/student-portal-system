import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Student2
{
    public static void main(String[] args) throws Exception
    {
        try
        {
            System.out.println("Client Started.");
            // Getting the information
            Registry registry = LocateRegistry.getRegistry(1234);
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Client ID: ");
            int id = sc.nextInt();
            System.out.println("Enter Client Password: ");
            String pw = sc.next();
            
            // Look up the information
            AccessInt stub = (AccessInt) registry.lookup("Access");
            boolean log = stub.login(id, pw);
            
            if(log == true){
                System.out.println("");
                System.out.println("Logged in. Connecting to Student Portal.");
                System.out.println("");
                StudentPortalInt stub2StudentPortal = (StudentPortalInt) registry.lookup("StudentPortal");

                System.out.println("Enter Student Details to be added into the system: ");

                System.out.println("Student ID: ");
                int ID = sc.nextInt();
            
                System.out.println("Student Name: ");
                String StudentName = sc.next();
                
                System.out.println("Student Age: ");
                int Age = sc.nextInt();
                
                System.out.println("Student Gender: ");
                String Gender = sc.next();
                
                System.out.println("Student Contact: ");
                int Contact = sc.nextInt();
                
                System.out.println("Student Password: ");
                String Password = sc.next();
                
                Student s1 = new Student(ID, StudentName, Age, Gender, Contact, Password);

                stub2StudentPortal.addStdnt(s1);
                System.out.println("Student has been added into the database.");
        }
        sc.close();
    }
        
        catch (Exception e)
        {
            System.err.println("Student Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}