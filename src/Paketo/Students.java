package Paketo;
import java.util.Scanner;
public class Students extends Users
	{
	Scanner input=new Scanner(System.in);
	final int registrationNumber;
	private String Courses[];
	 int Lesson_number;
	public Students(int Am) 
	{
		registrationNumber=Am;
		System.out.println("creating student with registration number:");
		System.out.println(registrationNumber);
	}
	public int GetRegistrationNumber() 
	{
		return registrationNumber;
	}
	public void SetCourses() 
	{
		Courses=new String[Lesson_number];
		for(int i=0; i<Courses.length; i++) 
		{
			System.out.println("Dwse id mathimatos");
			Courses[i]=input.nextLine();
		}
		
	}
	public String GetCourseGrade(String str,String str2) {
		return "with spaceship as (select mathimata_foithth.course_id as mathima,grade,mathimata_foithth.student_id as id\r\n" + 
				"from mathimata_foithth,courses\r\n" + 
				"where mathimata_foithth.course_id=courses.course_id)\r\n" + 
				"select grade,mathima \r\n" + 
				"from spaceship \r\n" + 
				"where mathima='"+str+"' and id='"+str2+"';";
	}
	public String GetCourseSemester(String str,String str2) {
		return "Select semester,avg(grade)\r\n" + 
				"from mathimata_foithth\r\n" + 
				"where semester='"+str+"' and student_id='"+str2+"'\r\n" + 
				"GROUP BY semester;";
	}
	public String GetCoursesSynolika(String str) {
		return "with spaceship as (select students.student_id as id,grade \r\n" + 
				"from students\r\n" + 
				"full outer join mathimata_foithth on students.student_id=mathimata_foithth.student_id\r\n" + 
				")\r\n" + 
				"select id,avg(grade)\r\n" + 
				"from spaceship\r\n" + 
				"where id='"+str+"'\r\n" + 
				"group by id;";
	}
	//9.2
	void Print_Marks() {
		System.out.println("Oi vathmoi sou einai :(endeiktiko mhnuma...tha ylopoieithei se epomeno stadio");
		//Ylopoihsh se epomeno stadio ergasias
	}
}
