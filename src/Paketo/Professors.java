package Paketo;

import java.util.Scanner;

public class Professors extends Users {
	public Professors(){
		System.out.println("Dhmiourgia adikeimenou klashs professors");
	}
	String Professor_Courses[];
   public void SetCourses() 
   {
	   Scanner input=new Scanner(System.in);
	   Scanner input2=new Scanner(System.in);
	   int Professor_Lessons_number;	
	   System.out.println("Dwse arithmo mathimatwn pou didaskei o kathigitis");
	   Professor_Lessons_number=input.nextInt();
	   Professor_Courses=new String[Professor_Lessons_number];
	   for(int i=0; i<Professor_Courses.length; i++) 
	   {
		   System.out.println("Dwse id mathimatos");
		   Professor_Courses[i]=input2.nextLine();
	   }
   }
   String[] GetCourses() {
	   return Professor_Courses;
   }
   void Marks_Assignment() {
	   System.out.println("mathimata pou borei na kataxwrhsei vathmo:");
	   System.out.println("Poio mathima thelete na vathmologhsetai");
	 //Ylopoihsh se epomeno stadio ergasias
   }
  public String  Courses_view_courseId(String str1,String str2) {
	return "Select grade,mathimata_foithth.student_id\r\n" + 
			"from professor_courses,mathimata_foithth\r\n" + 
			   "where professor_id='"+str1+"'  and mathimata_foithth.course_id=professor_courses.course_id and grade IS NOT NULL and mathimata_foithth.course_id='"+str2+"';\r\n";
   }
  public String Courses_view_semester(String grade) {
	  return "select grade,student_id,mathimata_foithth.course_id,semester\r\n" + 
				"from professor_courses,mathimata_foithth\r\n" + 
				"where professor_courses.course_id=mathimata_foithth.course_id and grade IS NULL and professor_courses.course_id='"+grade+"';\r\n" ; 
				
  }
}
