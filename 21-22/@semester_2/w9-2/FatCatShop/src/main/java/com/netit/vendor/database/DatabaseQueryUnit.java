package com.netit.vendor.database;

public class DatabaseQueryUnit {

	// CSR - comma separated row
	public static String produceCSR(String[] data) {
		
		String resultRow = "";
		for(String element : data) {
			resultRow += element + ",";
		}
		
		return resultRow.substring(0, resultRow.length() - 1);
	}
	
	
	public static String getOperator(DatabaseQueryoperatorEnum operator) {
		
		if(operator == DatabaseQueryoperatorEnum.GD) {
			return ">";
		}		
		
		if(operator == DatabaseQueryoperatorEnum.LD) {
			return "<";
		}			
		
		if(operator == DatabaseQueryoperatorEnum.IS) {
			return "IS";
		}				
		
		if(operator == DatabaseQueryoperatorEnum.ISNOT) {
			return "IS NOT";
		}
		
		return "=";
	}
}
