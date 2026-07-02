import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DeleteSrv extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("doPost of DeleteSrv");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        int emp_id = Integer.parseInt(request.getParameter("emp_id"));
        Connection con;
        PreparedStatement pst;
        int n;

        try {
            // Load JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Administrators", "root", "root");

            // Prepare the SQL query
            String q = "DELETE FROM employee WHERE emp_id=?";
            pst = con.prepareStatement(q);
            pst.setInt(1, emp_id);

            // Execute the update
            n = pst.executeUpdate();

            // Display response
            out.print("<!DOCTYPE html>");
            out.print("<html lang='en'>");
            out.print("<head>");
            out.print("<meta charset='UTF-8'>");
            out.print("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
            out.print("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.print("<title>Delete Employee</title>");
            out.print("</head>");
            out.print("<body>");
            out.print("<div class='container mt-5'>");
            out.print("<div class='row justify-content-center'>");
            out.print("<div class='col-md-6'>");
            out.print("<div class='card shadow-lg'>");
            out.print("<div class='card-body text-center'>");

            if (n > 0) {
                out.print("<h1 class='text-success'>Record Deleted Successfully</h1>");
                out.print("<p>Number of Records Deleted: " + n + "</p>");
            } else {
                out.print("<h1 class='text-danger'>No Records Found</h1>");
                out.print("<p>No employee found with Emp_ID: " + emp_id + "</p>");
            }

            out.print("<a href='homef.html' class='btn btn-primary mt-4'>Home</a>");
            out.print("</div>");
            out.print("</div>");
            out.print("</div>");
            out.print("</div>");
            out.print("</div>");

            out.print("<footer class='bg-primary text-white text-center py-3 mt-5'>");
            out.print("<p class='mb-0'>© 2025 Employee Management System. All Rights Reserved.</p>");
            out.print("</footer>");
            out.print("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js'></script>");
            out.print("</body>");
            out.print("</html>");

            pst.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            out.print("<div class='container mt-5'>");
            out.print("<h1 class='text-danger'>Error Occurred</h1>");
            out.print("<p>Unable to delete the record. Please try again later.</p>");
            out.print("<a href='homef.html' class='btn btn-primary'>Home</a>");
            out.print("</div>");
        }
        out.close();
    }
}
