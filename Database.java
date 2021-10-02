import java.sql.*;

public class Database {
private Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "54321");


public Database() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
public void add_employer(Employer employer, String department) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql= String.format("select id from department where name = '%s'",department);
            ResultSet resultSet = statement.executeQuery(sql);
            int departmentid=0;
            while (resultSet.next()) {
                departmentid = resultSet.getInt(1);
            }
            //sql = String.format("insert into employer(firstname, " +
                           // "lastname,personnelnumber,birthdate,department) values ('%s','%s',%d,'%s',%d)",
                    //employer.getFirstname(), employer.getLastname(),
                    //employer.getPersonnelnumber(), employer.getBirthday(), departmentid);
            sql = "insert into employer(firstname, " +
                            "lastname,personnelnumber,birthdate,departmentid) values ('"+employer.getFirstname()+"', '"+employer.getLastname()+"',\n" +
                    "                    '"+employer.getPersonnelnumber()+"','"+ employer.getBirthday()+"','"+ departmentid+"')";
            int updated_field = statement.executeUpdate(sql);
        } else {
            System.out.println("ERORR in Connection with DB");
        }
    }
public void add_Department(Department department) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
           //tring sql = String.format("insert into department (name, " +
                            //honenumber) values ('%s',%d)",
                  //department.getName(), department.getTelephonenumber());
            String sql = "insert into department (name, phonenumber) values " +
                    "('"+department.getName()+"','"+department.getTelephonenumber()+"')";
            int updated_field = statement.executeUpdate(sql);
        } else {
            System.out.println("ERORR in Connection with DB");
        }
    }
}