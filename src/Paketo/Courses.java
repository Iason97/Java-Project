package Paketo;


public class Courses  {
	String Description,id;
	String professor_name;
	public Courses()
	{
		System.out.println("Creating Course");
	}
	void setDescription(String Value) 
	{
		Description=Value;
	}
	String getDescription() 
	{
		return Description;
	}
	void setId(String Value)
	{
		id=Value;
	}
	String getId() 
	{
		return id;
	}
	String  getProf_name() 
		{
			return professor_name;
		}
}
