package com.trelloclone.trelloclone;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.trelloclone.trelloclone.controllers.WorkspaceController;

public class MestTest {

	@Test
	void hello() {
		
		WorkspaceController wsc = new WorkspaceController();
		var response = wsc.getAllWorkspace();
		
		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}
	
}
