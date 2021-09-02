package Paketo;

import Paketo.Courses;

public  class Users extends Courses {
 String username,name,surname,department;
 static int usersCounter=0;
      public Users(){
    	  System.out.println("Creating object of class Users");
    	  System.out.println("Adding 1 to variable UsersCounter");
    	  usersCounter+=1;
      }
      void setDepartment(String Value) {
    	  department=Value;
      }
      String getDepartment() {
    	  return department;
      }
      void setUsername(String Value) {
    	  username=Value;
      }
      String getUsername() {
    	  return username;
      }
      void setName(String Value) {
    	  name=Value;
      }
      String getName() {
    	  return name;
      }
      void setSurname(String Value) {
    	  surname=Value;
      }
      String getSurname() {
    	  return surname;
      }
      int getUsersCounter() {
    	  return usersCounter;
      }
}
