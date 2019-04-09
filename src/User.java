/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class User {
 
   // Fields 
   private int id;
   private String firstname;
   private String lastname;
   private int age ;
  
  
  // Constructor
   public User ( int ID , String FirstName ,String LastName , int Age)
   {
     this.id = ID;
	 this.firstname = FirstName;
	 this.lastname = LastName;
	 this.age = Age;
	 
   
   }
    // Functions
   
   public int getId ( ) {
   
   
   return id;
   }
  
  public String getFirstName( ) {
    
	
  
    return firstname;
  }
 
  public String getLastName( ) {
  
  
     return lastname;
    }
	
	public int getAge( ) {
	
	return age;
	}
 
 
 
    }
