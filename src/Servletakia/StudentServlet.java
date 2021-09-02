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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Paketo.Students;
/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Paketo.Students std=new Paketo.Students(16053);
	String student = null;
	Psw ps3=new Psw();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection c = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		PreparedStatement stmt2=null;
		PreparedStatement stmt3=null;
		String password="";
		ResultSet rs2=null;
		ResultSet rs3=null;
		PrintWriter out = response.getWriter(); 
		Scanner input=new Scanner(System.in);
	    response.setContentType("text/html");
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	    String sql3="";
	    final String username=request.getParameter("username");
	   //  final String password=request.getParameter("password");
	    String passwordToHash=request.getParameter("password");
	    if(passwordToHash!=null) {
	    	
	    	 password = ps3.Return_psw(passwordToHash) ;
	    	 System.out.println("password:"+password); 	    }
	    System.out.println(password); 
	    String sql=" Select * from students where username='"+username+"' and password='"+password+"';";
	    System.out.println("sql: "+sql);
	    String sql2="";
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
			
			System.out.println("Created statement successfully");
		
			out.println("<!DOCTYPE html>\n" + 
					"<html>\n"
					+ "<head>\n"
					+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"CSS.css\">"
					
					+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n"
					+ "<title>Insert title here</title>\n"
					+ "</head>\n"
					+ "<body>\n"+
					"<img src=\"background2.jpg\"  width=\"460\" height=\"345\" >\r\n"+
					"<form method=\"post\" class=\"logout\" action=\"Logout.jsp\">             \r\n" + 
					"      <button type=\"submit\"  class=\"btn\">Logout</button>    \r\n" + 
					"</form>");
			if(request.getParameter("student_param")==null){
				rs = stmt.executeQuery();
				if(rs.next()) {
					response.sendRedirect("Index.jsp?name="+rs.getString(2)+"&parametros=students");
					student=rs.getString(1);
				}else {
					out.write("<h1 align=\"center\">Wrong password or username!!</h1>");
				}
			
			}else { 

				 String parameter=request.getParameter("student_param");
				if(parameter.equals("student1")) {
				
					
					if(request.getParameter("flag")==null ){
						
						out.println("<div align=\"center\">\r\n" + 
								"			<form method=\"post\" action=\"StudentServlet\">	\r\n" + 
                                "Mathima gia provolh vathmologias<br>"+
								"			<input type=\"text\" name=\"course\" value=\"\">\r\n" + 
								"			<input type=\"hidden\" name=\"student_param\" value=\"student1\" >\r\n" + 
								"			<input type=\"hidden\" name=\"flag\" value=\"yes\" >\r\n" + 
								"			<br>\r\n" + 
								"			<input type=\"submit\" class=\"btn\" value=\"fygame\">\r\n" + 
								"			</form>\r\n" + 
								"			</div>");	
						sql3="with spaceship as (select mathimata_foithth.course_id as mathima,grade,mathimata_foithth.student_id as id\r\n" + 
								"from mathimata_foithth,courses\r\n" + 
								"where mathimata_foithth.course_id=courses.course_id)\r\n" + 
								"select grade,mathima \r\n" + 
								"from spaceship \r\n" + 
								"where  id='"+student+"';";
						out.println("<h2 align=\"center\">Professor lessons:</h2>");
						out.println( "<table style=\"width:100%\">\n"
								
									+ "<tr>\n"
									+ "<th><h3>Course_id</h3></th>\n"
									+ "</tr>\n");
						stmt3 = c.prepareStatement(sql3);
						rs3 = stmt3.executeQuery();
						while(rs3.next()) {
							out.println("<tr>\n"
									+ "<th><em>"+rs3.getString(2)+"</em></th>\n"			
									+ "</tr>\n"
									);
						}
					}
						if(request.getParameter("course")!=null) {
							boolean flag=false;
							sql2=std.GetCourseGrade(request.getParameter("course").toString(),student);
							System.out.println(sql2);
							stmt2 = c.prepareStatement(sql2);
							rs2 = stmt2.executeQuery();
							while(rs2.next()) {
								if(!flag) {
									
									out.println( "<table style=\"width:100%\">\n"
											+ "<tr>\n"
											+ "<th><h3>Course_id</h3></th>\n"
											+ "<th><h3>Grade</h3></th>\n "
											+ "</tr>\n");
									System.out.println(rs2.getString(2)+rs2.getDouble(1));
									out.println("<tr>\n"
											+ "<th><em>"+rs2.getString(2)+"</em></th>\n"
											+ "<th><em>"+rs2.getDouble(1)+"</em></th>\n"
											+ "</tr>\n"
											);
								}
								flag=true;
							}
							if(!flag)out.println("<h3 align=\"center\"><em><b>Cannot see grades of other courses!</b></em></h3>");
						}
					}else if(parameter.equals("student2")) {
						if(request.getParameter("flag")==null ){
							out.println("<div align=\"center\">\r\n" + 
									"			<form method=\"post\" class=\"verical-menu\" action=\"StudentServlet\">	\r\n" + 
									"			Eksamhno<br>" +
									"			<input type=\"text\" name=\"semester\" value=\"\">\r\n" + 
									"			<input type=\"hidden\" name=\"student_param\" value=\"student2\" >\r\n" + 
									"			<input type=\"hidden\" name=\"flag\" value=\"yes\" >\r\n" + 
									"			<br>\r\n" + 
									"			<input type=\"submit\" class=\"btn\" value=\"fygame\" >\r\n" + 
									"			</form>\r\n" + 
									"			</div>");	
							sql3="Select course_id,semester,avg(grade) \r\n" + 
									"									from mathimata_foithth\r\n" + 
									"									where  student_id='"+student+"' \r\n" + 
									"									GROUP BY semester,course_id;";
							out.println("<h2 align=\"center\">Professor lessons:</h2>");
							out.println( "<table style=\"width:100%\">\n"
									
										+ "<tr>\n"
										+ "<th><h3>Course_id</h3></th>\n"
										+ "<th><h3>Semester</h3></th>\n"
										+ "</tr>\n");
							stmt3 = c.prepareStatement(sql3);
							rs3 = stmt3.executeQuery();
							while(rs3.next()) {
								out.println("<tr>\n"
										+ "<th><em>"+rs3.getString(1)+"</em></th>\n"	
												+ "<th><em>"+rs3.getString(2)+"</em></th>\n"
										+ "</tr>\n"
										);
							}
						}
						if(request.getParameter("semester")!=null) {
							sql2=std.GetCourseSemester(request.getParameter("semester"), student);
							out.println( "<table style=\"width:100%\">\n"
									+ "<tr>\n"
									+ "<th><h3>Semester</h3></th>\n"
									+ "<th><h3>Vathmologia</h3></th>\n "
									+ "</tr>\n");
							System.out.println(sql2);
							stmt2 = c.prepareStatement(sql2);
							rs2 = stmt2.executeQuery();
							while(rs2.next()) {
								out.println("<tr>\n"
										+ "<th><em>"+rs2.getString(1)+"</em></th>\n"
										+ "<th><em>"+rs2.getDouble(2)+"</em></th>\n"
										+ "</tr>\n"
										);
							}
						}
					}else if(parameter.equals("student3")) {
							sql2=std.GetCoursesSynolika(student);
							out.println( "<table style=\"width:100%\">\n"
									+ "<tr>\n"
									+ "<th><h3>AM</h3></th>\n"
									+ "<th><h3>Vathmologia</h3></th>\n "
									+ "</tr>\n");
							System.out.println(sql2);
							stmt2 = c.prepareStatement(sql2);
							rs2 = stmt2.executeQuery();
							while(rs2.next()) {
								out.println("<tr>\n"
										+ "<th><em>"+rs2.getString(1)+"</em></th>\n"
										+ "<th><em>"+rs2.getDouble(2)+"</em></th>\n"
										+ "</tr>\n"
										);
							}
						
						
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
				
				if (c != null) {
					c.close();
				}
			} catch (SQLException ex) {
				Logger.getLogger(SecretaryServlet.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
		
	}


