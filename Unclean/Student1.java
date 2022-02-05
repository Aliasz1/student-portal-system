import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Student1{
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
            sc.close();
            
            // Look up the information
            AccessInt stub = (AccessInt) registry.lookup("Access");
            boolean log = stub.login(id, pw);

            if(log == true){
                System.out.println("");
                System.out.println("Logged in. Connecting to Student Portal.");
                System.out.println("");
                StudentPortalInt stub2StudentPortal = (StudentPortalInt) registry.lookup("StudentPortal");
                Student s = stub2StudentPortal.getme(id);
                if(s != null){
                    System.out.println("Student Details below: ");
                    System.out.print("ID: ");
                    System.out.println(s.getID());
                    System.out.print("Student Name: ");
                    System.out.println(s.getStudentName());
                    System.out.print("Age: ");
                    System.out.println(s.getAge());
                    System.out.print("Gender: ");
                    System.out.println(s.getGender());
                    System.out.print("Contact: ");
                    System.out.println(s.getContact());
                }
            }
        }
        
        catch (Exception e)
        {
            System.err.println("Student Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}