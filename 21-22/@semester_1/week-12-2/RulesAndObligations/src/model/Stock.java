package model;

public class Stock {

	private String name;
	private String code;
	private double value;
	
	public Stock(String name, String code, double value) {
		
		this.name = name;
		this.code = code;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "{" + this.getCode() + " " + this.getValue() + "}";
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof Stock) {

			Stock a = (Stock) obj;
			return this.getCode().equals(a.getCode()) && 
					this.getValue() == a.getValue();
		}
		
		return false;
	}
}
