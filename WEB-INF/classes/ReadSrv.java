import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class ReadSrv extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doPost of ReadSrv");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection con;
        PreparedStatement pst;
        ResultSet rst;

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Administrators", "root", "root");

            // Query to fetch all employee data
            String q = "SELECT * FROM employee";
            pst = con.prepareStatement(q);
            rst = pst.executeQuery();

            // Start HTML output
            out.print("<!DOCTYPE html>");
            out.print("<html lang='en'>");
            out.print("<head>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.print("<title>Employee Data</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<div class='container mt-5'>");
            out.print("<h1 class='text-center text-primary mb-4'>Employee Data</h1>");
            out.print("<table class='table table-bordered table-hover'>");
            out.print("<thead class='table-dark'>");
            out.print("<tr>");
            out.print("<th>Emp ID</th>");
            out.print("<th>Emp Name</th>");
            out.print("<th>Department</th>");
            out.print("<th>Job Title</th>");
            out.print("</tr>");
            out.print("</thead>");
            out.print("<tbody>");

            // Loop through the ResultSet and display data
            while (rst.next()) {
                out.print("<tr>");
                out.print("<td>" + rst.getInt(1) + "</td>");
                out.print("<td>" + rst.getString(2) + "</td>");
                out.print("<td>" + rst.getString(3) + "</td>");
                out.print("<td>" + rst.getString(4) + "</td>");
                out.print("</tr>");
            }
            out.print("</tbody>");
            out.print("</table>");
            out.print("<div class='text-center mt-4'>");
            out.print("<a href='homef.html' class='btn btn-primary'>Home</a>");
            out.print("</div>");
            out.print("</div>");

            // Footer
            out.print("<footer class='bg-primary text-white text-center py-3 mt-5'>");
            out.print("<p class='mb-0'>© 2025 Employee Management System. All Rights Reserved.</p>");
            out.print("</footer>");
            out.print("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
            out.print("</body>");
            out.print("</html>");

            // Close resources
            rst.close();
            pst.close();
            con.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
