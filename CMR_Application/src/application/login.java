package application;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
@SuppressWarnings("serial")
@WebServlet("/login")
public class login extends HttpServlet {

	public static boolean validate(String name,String pass){  
	    boolean status=false;  
	    
	    try{  
	    Class.forName("com.mysql.jdbc.Driver");  
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo", "root", "root");  
	          
	    PreparedStatement ps=con.prepareStatement("select * from login where username=? and password=?");  
	    ps.setString(1,name);  
	    ps.setString(2,pass);  
	          
	    ResultSet rs=ps.executeQuery();  
	    status=rs.next();  
	              
	    }catch(Exception e)
	    {System.out.println(e);} 
	    
	    return status;  
	    } 
	
public void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
  
    response.setContentType("text/html");  
    PrintWriter out = response.getWriter();  
          
    String n=request.getParameter("user");  
    String p=request.getParameter("password"); 
    
    
          
    if(validate(n, p)){  
        RequestDispatcher rd=request.getRequestDispatcher("application.html");  
        rd.forward(request,response); 
       // response.sendRedirect("application.html");
    }  
    else{  
        out.print("Sorry username or password error<br><br>");  
        RequestDispatcher rd=request.getRequestDispatcher("index.html");  
        rd.include(request,response);  
    } 
          
    out.close();  
    
	}
}