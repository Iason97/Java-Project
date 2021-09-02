package Paketo;
import java.util.Scanner;

import Paketo.Courses;
public class Grades extends Courses 
{
	Grades()
	{
		System.out.println("Creating object of class Grades");
	}
	Scanner input=new Scanner(System.in);
	String Vathmoi[][];
	int Arithmos_foithtwn;
	void setArithmos_foithtwn(int Value){
		Arithmos_foithtwn=Value;
	}
	int getArithmos_foithtwn(){
		return Arithmos_foithtwn;
	}
    void SetVathmoi() 
    {
		Vathmoi=new String[Arithmos_foithtwn][2];
		for(int i=0; i<Vathmoi.length; i++)
		{
			System.out.println("Dwse mhtrwo foithth");
			Vathmoi[i][0]=input.nextLine();
			System.out.println("Dwse vathmo foithth");
			Vathmoi[i][1]=input.nextLine();
		}	
	}
    String[][] getVathmoi() {
    	return Vathmoi;
    }
    
}
