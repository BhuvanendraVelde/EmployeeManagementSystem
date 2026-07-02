import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class UpdateSrv extends HttpServlet
{
   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
	System.out.println("doPost of ULDSrv");
  	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

	int emp_id = Integer.parseInt(request.getParameter("emp_id"));
	String emp_name = request.getParameter("emp_name");
	String dept = request.getParameter("dept");
	String job_title= request.getParameter("job_title");

	Connection con;
	PreparedStatement pst;
	int n;
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Administrators","root","root");
	
		String q = "update employee set emp_name=?, dept=? , job_title=? where emp_id = ?";
		pst = con.prepareStatement(q);
		pst.setString(1, emp_name);
		pst.setString(2, dept);
		pst.setString(3, job_title);
		pst.setInt(4,emp_id);

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
out.print("<h1 class='text-success'>Successfully Updated</h1>");
out.print("<p class='mt-3'>The employee details have been updated in the database.</p>");
if (n > 0) {
	out.print("<h1 class='text-success'>Record Updated Successfully</h1>");
	out.print("<p>Number of Records Updated: " + n + "</p>");
} else {
	out.print("<h1 class='text-danger'>No Records Found</h1>");
	out.print("<p>No employee found with Emp_ID: " + emp_id + "</p>");
}
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
         catch(Exception e){}
   }
}
