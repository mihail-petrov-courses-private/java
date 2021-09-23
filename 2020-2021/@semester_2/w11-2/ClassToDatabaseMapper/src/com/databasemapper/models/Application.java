package com.databasemapper.models;

import java.awt.datatransfer.SystemFlavorMap;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import com.databasemapper.anotations.MigrationColumn;
import com.databasemapper.db.connection.Database;
import com.databasemapper.db.migration.DatabaseMigration;
import com.databasemapper.scanner.EntityScanner;

public class Application {

	public static void main(String[] args) {

		DatabaseMigration migrationManager = new DatabaseMigration();
		migrationManager.migrate("com.databasemapper.models");
	}
}
