import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static  void main(String[]args) throws ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        System.out.println("********WELCOME*********");
        int choice = 0;
        do {
            System.out.println("1.Add Employer\n2.Add Department \n3.Update Firstname\n 4.Update Lastname" +
                    "\n5.Update Department \n6.Show All Department\n " +
                    "7.Show All Employer of specific department\n8.Exit");
            System.out.println("Please Enter Number");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    Employer employer = new Employer();
                    System.out.println("Please Enter firstname, lastname, personnel number, birthdate, departmrnt");
                    employer.setFirstname(scanner.next());
                    employer.setLastname(scanner.next());
                    employer.setPersonnelnumber(scanner.nextInt());
                    employer.setBirthday(scanner.next());
                    database.add_employer(employer, scanner.next());
                    break;
                case 2:
                    Department department = new Department();
                    System.out.println("Please Enter name,phone number");
                    department.setName(scanner.next());
                    department.setTelephonenumber(scanner.nextInt());
                    database.add_Department(department);
                    break;
                case 3:
                    System.out.println("Please Enter Id and new first name");
                    database.update_firstname(scanner.nextInt(),scanner.next());
                    break;
                case 4:
                    System.out.println("Please Enter Id and new last name");
                    database.update_lastname(scanner.nextInt(),scanner.next());
                    break;
                case 5:
                    System.out.println("Please Enter Id and new name");
                    database.update_department(scanner.nextInt(),scanner.next());
                    break;
                case 6:
                    database.show_all_department();
                    break;
                case 7:
                    System.out.println("Please Enter Department name");
                    database.show_all_employer_of_department(scanner.next());
                    break;
                case 8:
                    break;

            }
        }while (choice != 8);
    }
}