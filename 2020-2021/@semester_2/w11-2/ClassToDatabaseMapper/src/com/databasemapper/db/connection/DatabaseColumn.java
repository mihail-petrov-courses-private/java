package com.databasemapper.db.connection;

import com.databasemapper.db.migration.DatabaseColumnModificatorEnum;
import com.databasemapper.db.migration.DatabaseTypeEnum;

public class DatabaseColumn {

	private String name;
	int size;
	private DatabaseTypeEnum type;
	private DatabaseColumnModificatorEnum modificator;
	private boolean isNull 		= true;
	private boolean isPrimary 	= false;
	
	public DatabaseColumn(String name, DatabaseTypeEnum type) {
		this.name = name;
		this.type = type;
	}
	
	public DatabaseColumn(String name, DatabaseTypeEnum type, DatabaseColumnModificatorEnum modificator) {
		this.name 			= name;
		this.type 			= type;
		this.modificator 	= modificator;
	}
	
	public DatabaseColumn(String name, DatabaseTypeEnum type, int size, DatabaseColumnModificatorEnum modificator) {
		this.name 			= name;
		this.type 			= type;
		this.size 			= size;
		this.modificator 	= modificator;
	}	
	
	public boolean isPrimary() {
		return (this.modificator == DatabaseColumnModificatorEnum.PRIMARY); 
	}
	
	public boolean isNullable() {
		return (this.modificator == DatabaseColumnModificatorEnum.NULLABLE);
	}

	public boolean isNotNullable() {
		return !this.isNullable();
	}
	
	public boolean hasSize() {
		return this.size != -1;
	}
	
	public String getColumnName() {
		return this.name;
	}
	
	public DatabaseTypeEnum getType() {
		return this.type;
	}
	
	public String getCannonicalType() {
		return this.cannonicalTypeMapper();
	}	
	
	public int getSize() {
		return this.size;
	}
	
	public String getCannonicalTypeWithSize() {
		
		if(this.hasSize()) {
			return this.getCannonicalType() + "(" + this.getSize() + ")";	
		}
		
		return this.getCannonicalType();
	}
	
	public String getCannonicalModificator() {
		
		if(this.isPrimary()) return "PRIMARY";
		return (this.isNullable()) ? "NULL" : "NOT NULL";
	}
	
	private String cannonicalTypeMapper() {
		
		if(this.getType() == DatabaseTypeEnum.TEXT		) return "TEXT";
		if(this.getType() == DatabaseTypeEnum.VARCHAR	) return "VARCHAR";
		if(this.getType() == DatabaseTypeEnum.INT		) return "INT";
		if(this.getType() == DatabaseTypeEnum.DOUBLE	) return "DOUBLE";
		return null;
	}
}
