package Servletakia;

public class Kataxwrhsh {
	String id_mathimatos,id_foithth,semester;
	Double mark;
	Kataxwrhsh(String course_id,String student_id,String eksamhno, Double grade){
		this.id_mathimatos=course_id;
		this.id_foithth=student_id;
		this.mark=grade;
		semester=eksamhno;
	}
   public String GetCourse_id() {
	  return id_mathimatos; 
   }
   public String GetStudent_id() {
		  return id_foithth; 
	   }
   public Double GetGrade() {
		  return mark; 
	   }
   public String GetSemester() {
	   return semester;
   }
}
