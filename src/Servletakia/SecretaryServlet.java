package Servletakia;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class SecretaryServlet
 */
@WebServlet("/SecretaryServlet")
public class SecretaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Paketo.Secretaries sec=new Paketo.Secretaries("plhroforikhs");
    Psw ps=new Psw();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecretaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter out = response.getWriter(); 
		response.setContentType("text/html");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		String username=request.getParameter("username");
		String password="";
		String passwordToHash=request.getParameter("password");
		System.out.println(passwordToHash); 		
        if(passwordToHash!=null) {
        	password = ps.Return_psw(passwordToHash) ;
        	System.out.println("password:"+password); 
        }
		String sql=" Select * from secretary where username='"+username+"' and password='"+password+"';";
		Connection c = null;
		PreparedStatement stmt=null;
		PreparedStatement stmt2=null;
		ResultSet rs=null;
		ResultSet rs2=null;
		String sql2;
		try {
			
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
			
		}
		try {
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/java_telikh-ergasia2",
							"postgres", "1234");
			
			System.out.println("Opened database successfully");
			
			stmt = c.prepareStatement(sql);
			System.out.println("Create statement successfully");
			if(request.getParameter("param")==null) {
				rs = stmt.executeQuery();
				if(rs.next()) {
					response.sendRedirect("Index.jsp?name="+rs.getString(2)+"&parametros=secretaries");
					
				}else {
					out.write("<h1 align=\"center\">Wrong password or username!!</h1>");
				}
			
			}else {
				String parameter=request.getParameter("param");
				out.println("<!DOCTYPE html >\n" + 
						"<html>\n"
						+ "<head>\n"
						+"  <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS.css\">\r\n" 
						+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
						+ "<title>Insert title here</title>\n"
						+ "</head>\n"
						+ "<body>\n"
						+"<form method=\"post\" class=\"logout\" action=\"Logout.jsp\">             \r\n" + 
						"      <button type=\"submit\"  class=\"btn\">Logout</button>    \r\n" + 
						"</form>");
				if(parameter.equals("mathimata")) {
					sql=sec.getCourses();
					System.out.println(sql);
					stmt = c.prepareStatement(sql);
					try {
						rs = stmt.executeQuery();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					out.println( "<table style=\"width:100%\">\n"
							+ "<tr>\n"
							+ "<th><h3>course_id</h3></th>\n"
							+ "<th><h3>title</h3></th>\n "
							+ "<th><h3>dept_name</h3></th>\n"
							+ "<th><h3>credits</h3></th>\n"
							+ "</tr>\n");
					System.out.println();
					
					
					while( rs.next()) {
						out.println("<tr>\n"
								+ "<th><em>"+rs.getString(1)+"</em></th>\n"
								+ "<th><em>"+rs.getString(2)+"</em></th>\n"
								+ "<th><em>"+rs.getString(3)+"</em></th>\n"
								+ "<th><em>"+rs.getInt(4)+"</em></th>\n"
								+ "</tr>\n"
								);
					}
				}else if(parameter.equals("mathimata2")) {
					sql=sec.getCourses();
					System.out.println(sql);
					stmt = c.prepareStatement(sql);
					try {
						rs = stmt.executeQuery();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					out.println( "<table style=\"width:100%\">\n"
							+ "<tr>\n"
							+ "<th>course_id</th>\n"
							+ "<th>title</th>\n "
							+ "<th>dept_name</th>\n"
							+ "<th>credits</th>\n"
							+ "<th>Professor</th>\n"
							+ "</tr>\n");
					while( rs.next()) {
						out.println("<tr>\n"
								+ "<th><em>"+rs.getString(1)+"</em></th>\n"
								+ "<th><em>"+rs.getString(2)+"</em></th>\n"
								+ "<th><em>"+rs.getString(3)+"</em></th>\n"
								+ "<th><em>"+rs.getInt(4)+"</em></th>\n"
								);
						sql2=sec.getCourses_by_id(rs.getString(1));
						System.out.println(sql2);
						stmt2 = c.prepareStatement(sql2);
						try {
							rs2 = stmt2.executeQuery();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if(rs2.next()) {
							
							out.println("<th><em>"+rs2.getString(3)+"</em></th>\n"
									+ "</tr>\n");
						}
					}
				}else if(parameter.equals("professor")) {
					response.sendRedirect("Professor_assignment.jsp");
				}
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(SecretaryServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (stmt2 != null) {
					stmt2.close();
				}
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				Logger.getLogger(SecretaryServlet.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
	}
           
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection c = null;
		PreparedStatement stmt=null;
		PrintWriter out = response.getWriter(); 
		ResultSet rs=null;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("Where is your PostgreSQL JDBC Driver? "
					+ "Include in your library path!");
			e.printStackTrace();
			return;
			
		}
		try {
			c = DriverManager
					.getConnection("jdbc:postgresql://localhost:5432/ergasia",
							"postgres", "1234");
			
			System.out.println("Opened database successfully");
			
			stmt = c.prepareStatement( "INSERT INTO professor_courses"
					+ " VALUES(?,?,?)");
			
			System.out.println("Created statement successfully");
			
			String idd=request.getParameter("a1");
			String course=request.getParameter("a2");
			String professor=request.getParameter("a3");
			System.out.println(idd);
				try {
					
					 stmt.setString(1,idd);
					 stmt.setString(2,course);
					 stmt.setString(3,professor);
					    //ResultSet rs = insertStudent.executeQuery();
					    
						    
					    stmt.executeUpdate();
					    out.print("<h1 align=\\\"center\\\">Successful add!</h1>");
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			
		     
			} catch (SQLException ex) {
			Logger.getLogger(SecretaryServlet.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				Logger.getLogger(SecretaryServlet.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
}
