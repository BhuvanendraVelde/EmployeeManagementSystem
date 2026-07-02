import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class StoreSrv extends HttpServlet
{
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
	System.out.println("doPost of StoreSrv");
   	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

        int emp_id = Integer.parseInt(request.getParameter("emp_id"));
	String emp_name = request.getParameter("emp_name");
	String dept = request.getParameter("dept");
String job_title= request.getParameter("job_title");
        
       
  	Connection con;
 	PreparedStatement pst;
	int n=0;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Administrators", "root", "root");
 
          	String q = "insert into employee values(?, ?,?,?)";
              	pst = con.prepareStatement(q);
		pst.setInt(1, emp_id);
  		pst.setString(2, emp_name);
  		pst.setString(3, dept);
  		pst.setString(4, job_title);
		
		

		
		n = pst.executeUpdate();

		out.print("<!DOCTYPE html>");
out.print("<html lang='en'>");
out.print("<head>");
out.print("<meta charset='UTF-8'>");
out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
out.print("<title>Success</title>");
out.print("</head>");
out.print("<body>");
out.print("<div class='container mt-5'>");
out.print("<div class='row justify-content-center'>");
out.print("<div class='col-md-6'>");
out.print("<div class='card shadow-lg'>");
out.print("<div class='card-body text-center'>");
out.print("<h1 class='text-success'>Successfully Inserted</h1>");
out.print("<p class='mt-3'>The employee details have been added to the database.</p>");
out.print("<a href='homef.html' class='btn btn-primary mt-4'>HOME</a>");
out.print("</div>");
out.print("</div>");
out.print("</div>");
out.print("</div>");
out.print("</div>");
out.print("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
out.print("</body>");
out.print("</html>");

		pst.close();
		con.close();
		out.close();
	}
	catch(Exception e){
		System.out.println(e);
	}
   }
}
	   
