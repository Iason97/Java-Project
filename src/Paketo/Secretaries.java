package Paketo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Scanner;


public class Secretaries extends Professors {
	
      public  Secretaries(String Dep) {
         System.out.println("Creating Secretary of department:");
         System.out.println(Dep);
      }
	
      Courses mathima;
      Professors prof;
      Scanner input=new Scanner(System.in);
      Scanner input2=new Scanner(System.in);
      int Number_of_Students,Number_of_Professors;
      String str,id_mathimatos;
      int num=0,eisodos2;
      String[] id_foithtwn;
      public void setNumber_of_Students(int Value){
    	  Number_of_Students=Value;
      }
      public int getNumber_of_Students() {
    	  return Number_of_Students;
      }
      public void setNumber_of_Professors(int Value) {
    	  Number_of_Professors=Value;
      }
      public int getNumber_of_Professors() {
    	  return Number_of_Professors;
      }
   // 9.1.1 Dhmiourgia eggrafwn apo thn grammateia
      public void prof() 
      {
    	
    	    prof= new Professors();
			prof=new Professors();
			System.out.println("dwse onoma kathighth");
			prof.name=input.nextLine();
			prof.SetCourses();
			System.out.println("Emfanish mathimatwn pou didaskei o kathigitis");
			System.out.println(Arrays.toString(prof.GetCourses()));
      }
      void student() 
      {
    	  try {
    		  System.out.println("Dhmiourgia foithth");
				System.out.println("Dwse AM");
				eisodos2=input.nextInt();
				Students student1= new Students(eisodos2);
				System.out.println("dwse arithmo mathimatwn pou parakolouhtei o foithths");
				student1.Lesson_number=input.nextInt();
				student1.SetCourses();
				System.out.println("Emfanish mhtrwou foithth");
				System.out.println(student1.GetRegistrationNumber());
			}
			catch(NumberFormatException e){
				System.out.println("Number Format Exception occurred");
			}
      }
      void course() 
      {
    	    mathima=new Courses();
			System.out.println("Dwse id mathimatos");
			
			mathima.id=input.nextLine();
			System.out.println("Dwse description mathimatos");
			mathima.Description=input2.nextLine();
			System.out.println("Emfanish id mathimatos");
			System.out.println(mathima.getId());
			System.out.println("Emfanish Description mathimatos");
			System.out.println(mathima.getDescription());
     }
     public  String  getCourses() {
    	  return " Select * from courses ;";
      }
     public  String  getCourses_by_id(String str) {
   	  return " Select * from professor_courses where course_id='"+str+"' ;";
     }
      Professors getProf() {
    	  return prof;
      }
      // 9.1.2 Anathetei stous kathigites ta mathimata 
      void setProf(Professors pf,Courses c1)
  		{
  			c1.professor_name = pf.name;
  		}
  		
      // 9.1.3
  	void Students_list() {
  		System.out.println("Dhmiourgia listas foithtwn pros vathmologhsh");
  		System.out.println("Dwse plhthos foithtwn pros vathmologhsh");
  		id_foithtwn=new String[input.nextInt()];
  		for(int i=0; i<id_foithtwn.length; i++) {
  			System.out.println("Dwse id foithth");
  			id_foithtwn[i]=input2.nextLine();
  			
  		}
  		
  	}
  	
}
