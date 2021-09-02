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

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Paketo.Professors;
/**
 * Servlet implementation class ProfessorServlet
 */
@WebServlet("/ProfessorServlet")
public class ProfessorServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	Paketo.Professors pf=new Paketo.Professors();
	Psw ps2=new Psw();
      String professor;
      int counter=0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfessorServlet() {
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
	    
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection c = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		PreparedStatement stmt2=null;
		ResultSet rs2=null;
		PreparedStatement stmt3=null;
		ResultSet rs3=null;
		String password="" ;
		PrintWriter out = response.getWriter(); 
		Scanner input=new Scanner(System.in);
	    response.setContentType("text/html");
	    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	     String username=request.getParameter("username");
	    //final String password=request.getParameter("password");
	    
	    // hash and salt password
	    String passwordToHash=request.getParameter("password");
		System.out.println("passwordToHash: "+passwordToHash); 
		if(passwordToHash!=null) {
			
			password = ps2.Return_psw(passwordToHash) ;
			System.out.println("password:"+password); 
		}
	    
	    String sql=" Select * from professors where username='"+username+"' and password='"+password+"';";
	    System.out.println("sql: "+sql);
	    String sql2="";
	    String sql3="";
	    String []str; 
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
		
			out.println("<!DOCTYPE html >\n" + 
					"<html>\n"
					+ "<head>\n"
					+"<head>\r\n" + 
					"  <link rel=\"stylesheet\" type=\"text/css\" href=\"CSS.css\">\r\n" + 
					"</head>"
					+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
					+ "<title>Insert title here</title>\n"
					+ "</head>\n"
					+ "<body>\n"
					+"<img src=\"background2.jpg\"  width=\"460\" height=\"345\" >\r\n"
					+ "<form method=\"post\" class=\"logout\" action=\"Logout.jsp\">             \r\n" + 
					"      <button type=\"submit\"  class=\"btn\">Logout</button>    \r\n" + 
					"</form>");
			if(request.getParameter("professor_param")==null){
				rs = stmt.executeQuery();
				if(rs.next()) {
					response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
					response.sendRedirect("Index.jsp?name="+rs.getString(2)+"&parametros=professors");
					professor=rs.getString(1);
				}else {
					out.write("<h1 align=\"center\">Wrong password or username!!</h1>");
				}
			
			}else { 
				 String parameter=request.getParameter("professor_param");
				if(parameter.equals("professor1")) {
					if(request.getParameter("flag")==null){
						
						out.println("<div align=\"center\">\r\n" + 
								"			<form method=\"post\" action=\"ProfessorServlet\">	\r\n" + 
								" Mathima gia provolh vathmologias<br>" +
								"			<input type=\"text\" name=\"mathima_prof\" value=\"\">\r\n" + 
								"			<input type=\"hidden\" name=\"professor_param\" value=\"professor1\" >\r\n" + 
								"			<input type=\"hidden\" name=\"flag\" value=\"yes\" >\r\n" + 
								"			<br>\r\n" + 
								"			<input type=\"submit\" class=\"btn\" value=\"fygame\">\r\n" + 
								"			</form>\r\n" + 
								"			</div>");	
						sql3="Select grade,mathimata_foithth.student_id,mathimata_foithth.course_id\r\n" + 
								"								from professor_courses,mathimata_foithth\r\n" + 
								"								where professor_id='"+professor+"' and professor_courses.course_id=mathimata_foithth.course_id and grade IS NOT NULL ;";
						out.println("<h2 align=\"center\">Professor lessons:</h2>");
						out.println( "<table style=\"width:100%\">\n"
								
									+ "<tr>\n"
									+ "<th><h3>Course_id</h3></th>\n"
									+ "</tr>\n");
						stmt3 = c.prepareStatement(sql3);
						rs3 = stmt3.executeQuery();
						while(rs3.next()) {
							out.println("<tr>\n"
									+ "<th><em>"+rs3.getString(3)+"</em></th>\n"			
									+ "</tr>\n"
									);
						}
					}
					if(request.getParameter("mathima_prof")!=null) {
						int shmaia=0;
						    
							sql2=pf.Courses_view_courseId(professor, request.getParameter("mathima_prof"));
							System.out.println(sql2);
							stmt2 = c.prepareStatement(sql2);
							rs2 = stmt2.executeQuery();
							while(rs2.next()) {
								if(shmaia==0) {
									out.println( "<table style=\"width:100%\">\n"
											
									+ "<tr>\n"
									+ "<th><h3>Course_id</h3></th>\n"
									+ "<th><h3>Grade</h3></th>\n "
									+ "</tr>\n");
									
								}
								out.println("<tr>\n"
										+ "<th><em>"+rs2.getString(2)+"</em></th>\n"			
										+ "<th><em>"+rs2.getDouble(1)+"</em></th>\n"
										+ "</tr>\n"
										);
								shmaia+=1;
							}
							if(shmaia==0)out.println("<h1 align=\"center\" >O kathigitis den didaskei to sygkekrimeno mathima</h1>");
						}
				}else if(parameter.equals("professor2")) {
					if(request.getParameter("flag")==null) {
						counter=0;
						out.println("<div align=\"center\">\r\n" + 
								"			<form method=\"post\" class=\"verical-menu\" action=\"ProfessorServlet\">	\r\n" + 
								" Mathima gia kataxwrhsh vathmologias<br>" + 
								"			<input type=\"text\" name=\"mathima_updt\" value=\"\">\r\n" + 
								"			<input type=\"hidden\" name=\"professor_param\" value=\"professor2\" >\r\n" + 
								"			<input type=\"hidden\" name=\"flag\" value=\"yes\" >\r\n" + 
								"			<br>\r\n" + 
								"			<input  class=\"btn\" type=\"submit\" value=\"fygame\">\r\n" + 
								"			</form>\r\n" + 
								"			</div>");	
						sql3="Select grade,mathimata_foithth.student_id,mathimata_foithth.course_id\r\n" + 
								"								from professor_courses,mathimata_foithth\r\n" + 
								"								where professor_id='"+professor+"' and professor_courses.course_id=mathimata_foithth.course_id and grade IS  NULL ;";
						out.println("<h2 align=\"center\">Professor lessons:</h2>");
						out.println( "<table style=\"width:100%\">\n"
								
									+ "<tr>\n"
									+ "<th><h3>Course_id</h3></th>\n"
									+ "</tr>\n");
						stmt3 = c.prepareStatement(sql3);
						rs3 = stmt3.executeQuery();
						while(rs3.next()) {
							out.println("<tr>\n"
									+ "<th><em>"+rs3.getString(3)+"</em></th>\n"			
									+ "</tr>\n"
									);
						}
					}
					
					if(request.getParameter("mathima_updt")!=null) {
						if(request.getParameter("vathmos1")==null) {
							pf.Courses_view_semester(request.getParameter("mathima_updt"));
							stmt2 = c.prepareStatement(pf.Courses_view_semester(request.getParameter("mathima_updt")));
							
							rs2 = stmt2.executeQuery();
							
							out.println( "<table style=\"width:100%\">\n"
									+"<tr>\n"
									+ "<th><h3>Grade</h3></th>\n "
									+ "<th><h3>Student_id</h3></th>\n "
									+ "<th><h3>Course_id</h3></th>\n"
									+ "<th><h3>Semester</h3></th>\n"
									+ "</tr>\n");
							while(rs2.next()) {
								counter+=1;
								out.println("<form method=\"post\" class=\"verical-menu\" action=\"ProfessorServlet\">"+
										"<th><em><input type=\"text\" name=\"vathmos"+counter+"\" ></em></th>\r\n" + 
										"<input type=\"hidden\" name=\"mathima_updt\" value=\""+request.getParameter("mathima_updt")+"\" >  \r\n" + 
										"			<input type=\"hidden\" name=\"professor_param\" value=\"professor2\" >\r\n" + 
										"			<input type=\"hidden\" name=\"flag\" value=\"yes\" >\r\n" + 
										"<th><em>"+rs2.getString(2)+"</em></th>\n"
										+ "<th><em>"+rs2.getString(3)+"</em></th>\n"
										+ "<th><em>"+rs2.getString(4)+"</em></th>\n"
										+ "</tr>\n"
										);
							}
							if(counter==0) {
								out.println("<h1 align=\"center\">DEN YPARXOUN  MH VATHMOLOGIMENA MATHIMATA OR TO MATHIMA POU DWSATE DEN EINAI TOU SYGKEKRIMENOU KATHIGITI</h1>");	
							}else {
								
								out.println("<input type=\"submit\" value=\"update\">  \r\n" + 
										"</form>"+
										"<br> \r\n" + 
										"</div></em></th>\n");
							}
						}
						if(request.getParameter("vathmos1")!=null) {
							int metrhths=0;
							stmt2 = c.prepareStatement( pf.Courses_view_semester(request.getParameter("mathima_updt")));
							Kataxwrhsh []obj=new Kataxwrhsh[counter+1];
							rs2 = stmt2.executeQuery();
							while(rs2.next()) {
								metrhths+=1;
								obj[metrhths]=new Kataxwrhsh(rs2.getString(3),rs2.getString(2),rs2.getString(4),Double.parseDouble(request.getParameter("vathmos"+metrhths)));
								System.out.println("course_id:"+obj[metrhths].GetCourse_id());
								System.out.println("grade:"+obj[metrhths].GetGrade());
								System.out.println("Semester:"+obj[metrhths].GetSemester());
								System.out.println("Student_id:"+obj[metrhths].GetStudent_id());
								sql3="UPDATE mathimata_foithth\n"+
   								"SET grade =?\n"+
								"WHERE grade IS NULL and course_id=? and student_id=? and semester=?;";
								stmt3 = c.prepareStatement(sql3);
								stmt3.setDouble(1, obj[metrhths].GetGrade());
								stmt3.setString(2, obj[metrhths].GetCourse_id());
								stmt3.setString(3, obj[metrhths].GetStudent_id());
								stmt3.setString(4, obj[metrhths].GetSemester());
								stmt3.execute();
								out.println("Successful update!");
								
							}
						}
						
					}
					
				}
			}
		}catch (SQLException ex) {
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
							
						


	
