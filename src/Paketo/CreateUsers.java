package Paketo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Scanner;
public class CreateUsers {
	public static void main(String[] args)  throws IOException {
		FileWriter writer= new FileWriter("Stoixeia_Mathitwn.txt");
		PrintWriter prtWriter =new PrintWriter(writer);
		FileReader reader = new FileReader("Stoixeia_Mathitwn.txt");
		BufferedReader bufferedReader = new BufferedReader(reader);
        String line,Menou;
		int eisodos,menou;
		Scanner input=new Scanner(System.in);
		Scanner input2=new Scanner(System.in);
		System.out.println("MENOU:"+"\n"+"1:Dhmiourgia adikeimenou Students"+"\n"
		+"2:Dhmiourgia adikeimenou Users"+"\n"
	    +"3:Dhmiourgia adikeimenou Professors"+"\n"
		+"4:Dhmiourgia adikeimenou Courses"+"\n"
		+"5:Dhmiourgia adikeimenou Grades"+"\n"
		+"6:Dhmiourgia adikeimenou Secretaries"+"\n"
		+"7:Dokimh me arxeia"+"\n"
		+"-1:Eksodos"+"\n");
		System.out.println("Dwse epilogh");
		menou=input.nextInt();
		while(menou!=-1) {
			if(menou==1) {
				System.out.println("----------------------------"+"\n"+"STUDENTS");
				try {
					System.out.println("Dwse AM(Prepei na einai akeraios)");
					eisodos=input.nextInt();
					Students student1= new Students(eisodos);
					System.out.println("dwse arithmo mathimatwn pou parakolouhtei o foithths");
					student1.Lesson_number=input.nextInt();
					student1.SetCourses();
					System.out.println("Emfanish mhtrwou foithth");
					System.out.println(student1.GetRegistrationNumber());
					System.out.println("9.2");
					student1.Print_Marks();
				}
				catch(NumberFormatException e){
					System.out.println("Number Format Exception occurred");
				}
			}else if(menou==2) {
				System.out.println("----------------------------"+"\n"+"USERS");
				Users user1=new Users();
				System.out.println("Dwse name tou user");
				user1.setName(input2.nextLine());
				System.out.println("Dwse epitheto tou user");
				user1.setSurname(input2.nextLine());
				input.nextLine();
				System.out.println("Dwse tmhma tou user");
				user1.setDepartment(input.nextLine());
				System.out.println("Name tou user:"+user1.getName());
				System.out.println("Epitheto tou user:"+user1.getSurname());
				System.out.println("Tmhma tou user"+user1.getDepartment());
				System.out.println("Exoun dhmiourgithei:"+user1.getUsersCounter()+"xrhstes");
			}else if (menou==3) {
				System.out.println("----------------------------"+"\n"+"PROFESSORS");
				Professors prof= new Professors();
				prof=new Professors();
				prof.SetCourses();
				System.out.println("Emfanish mathimatwn pou didaskei o kathigitis");
				System.out.println(Arrays.toString(prof.GetCourses()));
			}else if(menou==4) {
				System.out.println("----------------------------"+"\n"+"COURSES");
				Courses mathima=new Courses();
				System.out.println("Dwse id mathimatos");
				input.nextLine();
				mathima.id=input.nextLine();
				System.out.println("Dwse description mathimatos");
				mathima.Description=input2.nextLine();
				System.out.println("Emfanish id mathimatos");
				System.out.println(mathima.getId());
				System.out.println("Emfanish Description mathimatos");
				System.out.println(mathima.getDescription());
			}else if (menou==5) {
				System.out.println("----------------------------"+"\n"+"GRADES");	
				Grades vathmoi=new Grades();
				vathmoi=new Grades();
				System.out.println("Dwse ton arithmo foithtwn pou edwsan to mathima");
				vathmoi.setArithmos_foithtwn(input.nextInt());
				vathmoi.SetVathmoi();
				System.out.println("Dwse Description Mathimatos");
				String x=input2.nextLine();
				input.nextLine(); 
				vathmoi.setDescription(x);
				System.out.println("Dwse Id Mathimatos");
				String y=input.nextLine();
				vathmoi.setId(y);
				System.out.println("Emfanish arithmou foithtwn pou edwsan to mathima: "+vathmoi.getArithmos_foithtwn());
				System.out.println("Emfanish vathmwn foithtwn:\n"+Arrays.deepToString(vathmoi.getVathmoi()));
			}else if (menou==6) {
				System.out.println("----------------------------"+"\n"+"SECRETARIES");	
				Secretaries sec=new Secretaries("Cs");
				System.out.println("Dwse arithmo foithtwn pou exei to tmhma plhroforikhs");
				sec.Number_of_Students=input.nextInt();
				System.out.println("Dwse arithmo kathgitwn pou exei to tmhma plhroforikhs");
				sec.Number_of_Professors=input.nextInt();
				System.out.println("Arithmos foithtwn pou exei to tmhma plhroforikhs");
				System.out.println(sec.getNumber_of_Students());
				System.out.println("9.1.1(Dhmiourgia eggrafwn kathigitwn,foithtwn kai mathimatwn apo thn grammateia)");
				sec.prof();
				sec.course();
				sec.student();
				System.out.println("9.1.2(Anathesh kathigitwn sta mathimata apo thn grammateia)");
				System.out.println("Arithmos kathigitwn pou exei to tmhma plhroforikhs");
				System.out.println(sec.getNumber_of_Professors());
				System.out.println("9.1.3");
				sec.Students_list();
				System.out.println("9.3.1");
				sec.getProf();
				sec.Students_list();
			}else if (menou==7) {
				try {
					System.out.println("----------------------------"+"\n"+"FILES");
					   System.out.println("Dwse mhtrwo foithth");
					   prtWriter.print(input.nextInt()+",");
					   input.nextLine();
					   System.out.println("Dwse onoma foithth");
					   prtWriter.print(input.nextLine()+",");
					   System.out.println("Dwse epitheto foithth");
					   prtWriter.print(input.nextLine()+",");
					   System.out.println("Dwse Tmhma foithth");
					   prtWriter.print(input.nextLine()+",");
				}
				catch(IllegalFormatException e){
					System.out.println("Number Format Exception occurred");
				}
				writer.close();
				prtWriter.close();
				try {
					line= bufferedReader.readLine();
					String[] array=new String[4];
					int i=0;
					for(String str: line.split(",")) {
						array[i]=str;
						i+=1;
					}
					int mhtrwo = Integer.parseInt(array[0]);
					Students xrhsths1=new Students(mhtrwo);
					xrhsths1.setName(array[1]);
					xrhsths1.setSurname(array[2]);
					xrhsths1.setDepartment(array[3]);
					System.out.println("Onoma User:");
					System.out.println(xrhsths1.getName());
					System.out.println("Epitheto User:");
					System.out.println(xrhsths1.getSurname());
					System.out.println("Tmhma User:");
					System.out.println(xrhsths1.getDepartment());
					reader.close();
					bufferedReader.close();
				}catch(Exception e) {
					System.out.println("Exception occurred");
				}
		    }
			System.out.println("Dwse epilogh");
			menou=input.nextInt();
		}
	}
}
		
  

