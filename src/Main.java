import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost/student?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String userName = "root";
        String password = "";
        String Query = "insert into details value(10, 'bala','mech')";
        String data = "";
        String query = "select * from student";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        int count = st.executeUpdate(Query);
        System.out.println(count + " - row is affected");
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            data = rs.getInt(1)+":"+rs.getString(2)+":"+rs.getString(3);
            System.out.println(data);
        }
        st.close();
        con.close();
    }
}
