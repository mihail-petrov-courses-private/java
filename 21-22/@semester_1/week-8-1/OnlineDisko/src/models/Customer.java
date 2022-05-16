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
	private double wallet;
	
	private boolean isVIP;
	

	public Customer(int id, String fname, String lname, String gender, int age, double wallet) {
		
		this.setId(id);
		this.setFname(fname);
		this.setLname(lname);
		this.setGender(gender);
		this.setAge(age);
		this.setWallet(wallet);
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
	
	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}	
	
	public boolean isVIP() {
		return isVIP;
	}

	public void setVIPStatus() {
		this.isVIP = true;
	}
	
	public void removeVIPStatus() {
		this.isVIP = false;
	}

	public void increseWallet(double increseWith) {
		this.wallet += increseWith;
	}
	
	public void decreseWallet(double decreseWith) {
		this.wallet -= decreseWith;
	}
	
	public boolean hasMoney() {
		return this.wallet > 0;
	}	
	
	public boolean isPaymentProcessable(double payment) {
		
		double currentWalletAmount 	= this.wallet;
		double walletBalance 		= currentWalletAmount - payment; 
		
		return walletBalance >= 0;
	}
	
	
	public void render() {
		
		System.out.println("My first name is 	" + this.fname);
		System.out.println("My last name is 	" + this.lname);		
		System.out.println("My gender is 		" + this.gender);
		System.out.println("My age is 			" + this.age);
	}
}
