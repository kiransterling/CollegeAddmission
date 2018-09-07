

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import java.sql.SQLException;


/**
 * Servlet implementation class Admissionform
 */
@WebServlet("/Admissionform")
public class Admissionform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admissionform() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String mobileString = request.getParameter("mobile");
		String city = request.getParameter("city");
		//String mobile = Integer.parseInt(mobileString);
		
		String dbhostname = "35.188.169.83";
		String DBname = "StudentDB";
		String username ="root";
		String password ="welcome2ibm";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			//Modify below mentioned connection url with your credentials
			//Connection con =DriverManager.getConnection("jdbc:mysql://<hostname>/<DBname>?user=<username>&password=<password>");
			Connection con =DriverManager.getConnection("jdbc:mysql://"+dbhostname+"/"+DBname+"?user="+username+"&password="+password);
						
			String insertTableSQL = "INSERT INTO student"
					+ "(FirstName, LastName, Mobile, City) VALUES"
					+ "(?,?,?,?)";
			PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
			preparedStatement.setString(1,fname);
			preparedStatement.setString(2, lname);
			preparedStatement.setString(3, mobileString);
			preparedStatement.setString(4, city);
			
			// execute insert SQL stetement
			preparedStatement .executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		response.sendRedirect("/index.html");
	}

}
