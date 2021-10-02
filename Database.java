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
    public void update_firstname(int id, String firstname) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            String sql = "update employer set firstname = '"+firstname+"' where id = '"+id+"'";
            //String sql = String.format("update employer set firstname = '%s' where id = %d",firstname,id);
            int updated_field = statement.executeUpdate(sql);
        } else {
            System.out.println("ERORR in Connection with DB");
        }
    }

    public void update_lastname(int id, String lastname) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            //String sql = String.format("update employer set lastname = '%s' where id = %d",lastname,id);
            String sql = "update employer set lastname = '"+lastname+"' where id = '"+id+"'";
            int updated_field = statement.executeUpdate(sql);
        } else {
            System.out.println("ERORR in Connection with DB");
        }
    }
public void update_department(int id, String name) throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();

            String sql = "update department set name = '"+name+"' where id ='"+id+"'";
            int updated_field = statement.executeUpdate(sql);
        } else {
            System.out.println("ERORR in Connection with DB");
        }
    }
public void show_all_department() throws SQLException {
        if (connection!=null){
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select name from department");
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        }
        else {
            System.out.println("ERORR in Connection with DB");
        }
    }

    public void show_all_employer_of_department(String name) throws SQLException {
        if (connection!=null){
            Statement statement= connection.createStatement();
            String sql= String.format("select id from department where name = '%s'",name);
            ResultSet resultSet=statement.executeQuery(sql);
            int departmentid=0;
            while(resultSet.next()) {
                 departmentid = resultSet.getInt(1);
            }
            //sql =  String.format("select firstname,lastname from employer where departmentid = %d",departmentid);
            sql =  "select firstname,lastname from employer where departmentid = '"+departmentid+"'";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));
            }
        }
        else {
            System.out.println("ERORR in Connection with DB");
        }
    }
}