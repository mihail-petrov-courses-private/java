package com.databasemapper.anotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.databasemapper.db.migration.DatabaseColumnModificatorEnum;
import com.databasemapper.db.migration.DatabaseTypeEnum;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MigrationColumn {

	DatabaseTypeEnum dbType() 					default DatabaseTypeEnum.EXTRACT_FROM_FIELD ;
	DatabaseColumnModificatorEnum modificator() default DatabaseColumnModificatorEnum.NULLABLE;  
	int dbTypeSize() 							default -1;
	String columnName() 						default "";
}
