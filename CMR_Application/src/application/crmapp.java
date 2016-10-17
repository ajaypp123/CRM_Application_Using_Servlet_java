package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class crmapp
 */
@WebServlet("/crmapp")
public class crmapp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public crmapp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
		String fn =request.getParameter("firstname");
		String mn =request.getParameter("middlename");
		String ln =request.getParameter("lastname");
		
		String cusid =request.getParameter("cusid");
		String polino =request.getParameter("polino");
		String ticket =request.getParameter("ticket");
		String category =request.getParameter("category");
		String componey =request.getParameter("componey");
		String paymentno =request.getParameter("paymentno");
		String paymenttype =request.getParameter("paymenttype");
		String ammount =request.getParameter("ammount");
		
		String cellphone =request.getParameter("cellphone");
		String mobile =request.getParameter("mobile");
		String email =request.getParameter("email");
		String city =request.getParameter("city");
		String state =request.getParameter("state");
		String pincode =request.getParameter("pincode");
		
		try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/demo", "root", "root");
 
            PreparedStatement ps = con
                    .prepareStatement("insert into xmldb values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
 
            ps.setString(1, fn);
            ps.setString(2, mn);
            ps.setString(3, ln);
            ps.setString(4, cusid);
            ps.setString(5, polino);
            ps.setString(6, ticket);
            ps.setString(7, category);
            ps.setString(8, componey);
            ps.setString(9, paymentno);
            ps.setString(10, paymenttype);
            ps.setString(11, ammount);
            ps.setString(12, cellphone);
            ps.setString(13, mobile);
            ps.setString(14, email);
            ps.setString(15, city);
            ps.setString(16, state);
            ps.setString(17, pincode);
 
            int i = ps.executeUpdate();
            if (i > 0)
                
            
            out=response.getWriter();
            out.print("<html>");
            out.print("<body bgcolor=\"#42d7f4\"><h2>CRM System</h2><br>");
			out.print("Your Data saved...<br>");
			out.println("--------------------------------<br>");
			out.print("<b>Name:</b>");
			out.println("<br>");
			out.print("firstname    : " + fn);
			out.println("<br>");
			out.print("middlename   : " + mn);
			out.println("<br>");
			out.print("lastname     : " + ln);
			out.println("<br>");
			
			out.println("--------------------------------<br>");
			out.print("<b>Policy:</b><br>");
			out.print("cusid        : " + cusid + "<br>");
			out.print("polino       : " + polino + "<br>");
			out.print("ticket       : " + ticket + "<br>");
			out.print("category     : " + category + "<br>");
			out.print("componey     : " + componey + "<br>");
			out.print("paymentno    : " + paymentno + "<br>");
			out.print("paymenttype    : " + paymenttype + "<br>");
			out.print("ammount      : " + ammount + "<br>");
			
			out.println("--------------------------------<br>");
			out.print("<b>Contact:</b><br>");
			out.print("cellphone        : " + cellphone + "<br>");
			out.print("mobile       : " + mobile + "<br>");
			out.print("email       : " + email + "<br>");
			out.print("city     : " + city + "<br>");
			out.print("state     : " + state + "<br>");
			out.print("pincode    : " + pincode + "<br>");
			out.println("--------------------------------<br>");
			out.print("</body>");
			out.print("</html>");
 
        } catch (Exception e2) {
            System.out.println(e2);
        }
 
        out.close();
	}

}
