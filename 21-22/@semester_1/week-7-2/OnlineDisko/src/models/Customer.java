package models;
public class Customer {
	
	public static final String 	GENDER_MALE 				= "M";
	public static final String 	GENDER_FIMALE 				= "F";
	public static final int 	MIN_AGE_FOR_REGISTRATION 	= 4;
	
	private int id;
	private String fname;
	private String lname;
	private String gender;
	private int age;
	
	public Customer(int id, String fname, String lname, String gender, int age) {
		
		this.setId(id);
		this.setFname(fname);
		this.setLname(lname);
		this.setGender(gender);
		this.setAge(age);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getFname() {
		return this.fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getLname() {
		return this.lname;
	}
	
	public void setGender(String gender) {
		
		boolean isGenderApplicable = gender.equals(Customer.GENDER_MALE) || 
									 gender.equals(Customer.GENDER_FIMALE); 
		
		if(isGenderApplicable) {
			this.gender = gender;	
		}
	}
	
	public String getGender() {
		return this.gender;
	}	
	
	public void setAge(int age) {
		
		if(age > Customer.MIN_AGE_FOR_REGISTRATION) {
			this.age = age;
		}
	}
	
	
	public void render() {
		
		System.out.println("My first name is 	" + this.fname);
		System.out.println("My last name is 	" + this.lname);		
		System.out.println("My gender is 		" + this.gender);
		System.out.println("My age is 			" + this.age);
	}
}
