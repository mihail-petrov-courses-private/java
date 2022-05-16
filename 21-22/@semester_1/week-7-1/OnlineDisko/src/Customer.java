public class Customer {
	
	public int id;
	public String fname;
	public String lname;
	public String gender;
	public int age;
	
	
	public void render() {
		
		System.out.println("My first name is 	" + this.fname);
		System.out.println("My last name is 	" + this.lname);		
		System.out.println("My gender is 		" + this.gender);
		System.out.println("My age is 			" + this.age);
	}
}
