package com.trelloclone.trelloclone;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.trelloclone.trelloclone.controllers.WorkspaceController;
import com.trelloclone.trelloclone.enums.WorkspaceType;
import com.trelloclone.trelloclone.models.pm.Workspace;
import com.trelloclone.trelloclone.repositories.pm.WorkspaceRepository;
import com.trelloclone.trelloclone.translate.TranslateMessage;

@SpringBootTest
public class WorkspaceControllerTest {

	@Autowired
	private WorkspaceController controller;
	
	@Autowired
	private WorkspaceRepository workspaceRepository;	
	
	private final int			FAKE_ID				= 99999;
	private final String 		TEST_ENTITY_TITLE 	= "Test Entity";
	private final WorkspaceType TEST_ENTITY_TYPE 	= WorkspaceType.EDUCATION;
	private final String 		TEST_ENTITY_DESC 	= "Test Entity Desc";
	
	private final String 		UPDATE_ENTITY_TITLE = "Update Entity";
	private final WorkspaceType UPDATE_ENTITY_TYPE 	= WorkspaceType.ENGENIRING;
	private final String 		UPDATE_ENTITY_DESC 	= "Update Entity Desc";	
	
	
	@Test
	public void testIsControllerAvailable() {
		assertNotNull(this.controller);
	}
	
	@Test
	public void testIfWeCanGetMessageHelloWorldTest() {

		String message = this.controller.getTestMessage();
		assertEquals("Hellow World Test", message);
	}
	
	@Test
	public void testCreateNewWorkspaceEntity() {
		
		Workspace entity = new Workspace(
				"Example Workspace", 
				WorkspaceType.EDUCATION,
				"Sample workspace holder");
		
		ResponseEntity httpResult = this.controller.createWorkspace(entity);

		assertEquals(HttpStatus.OK, httpResult.getStatusCode());
		assertTrue(httpResult.hasBody());
		
		HashMap<String, Object> httpBodyResult	= (HashMap<String, Object>) httpResult.getBody();
		assertEquals(TranslateMessage.WORKFLOW_CREATE_SUCCESS, httpBodyResult.get("message"));
	}
	
	@Test
	public void testGetExistingSingleWorkspaceEntity() {
		
		Workspace entity = new Workspace(
				"Example Workspace", 
				WorkspaceType.EDUCATION,
				"Sample workspace holder");
		
		Workspace resultEntity 		=  this.workspaceRepository.save(entity);		
		final int RESULT_ENTITY_ID 	= resultEntity.getId();
		ResponseEntity httpResult 	=  this.controller.getSingleWorkspace(RESULT_ENTITY_ID);
		
		assertTrue(httpResult.hasBody());
		
		HashMap<String, Object> httpBodyResult	= (HashMap<String, Object>) httpResult.getBody();
		Workspace httpBodyResultEntity 			=  (Workspace)httpBodyResult.get("collection");
		
		assertEquals(HttpStatus.OK				, httpResult.getStatusCode());
		assertEquals(RESULT_ENTITY_ID			, httpBodyResultEntity.getId());
		assertEquals("Example Workspace"		, httpBodyResultEntity.getTitle());
		assertEquals(WorkspaceType.EDUCATION	, httpBodyResultEntity.getType());
		assertEquals("Sample workspace holder"	, httpBodyResultEntity.getDescription());
	}
	
	@Test
	public void testGetNonExistingSingleWorkspaceEntity() {
		
		ResponseEntity httpResult 	=  this.controller.getSingleWorkspace(FAKE_ID);
		assertEquals(HttpStatus.NOT_FOUND, httpResult.getStatusCode());
	}
	
	@Test
	public void testGetAllWorkspaceEntities() {
		
		ArrayList<Workspace> testCollection = new ArrayList<>();
		testCollection.add(new Workspace("T1",  WorkspaceType.EDUCATION, "D1"));
		testCollection.add(new Workspace("T2",  WorkspaceType.EDUCATION, "D2"));
		testCollection.add(new Workspace("T3",  WorkspaceType.EDUCATION, "D3"));
		
		ArrayList<Workspace> resultEntityCollection =  (ArrayList<Workspace>) this.workspaceRepository.saveAll(testCollection);
		ResponseEntity httpResult 	=  this.controller.getAllWorkspace();
		
		assertTrue(httpResult.hasBody());
		HashMap<String, Object> httpBodyResult		  = (HashMap<String, Object>) httpResult.getBody();
		ArrayList<Workspace> httpBodyResultCollection =  (ArrayList<Workspace>)httpBodyResult.get("collection");
		
		Workspace testElement 			= null;
		Workspace resultEntityElement 	= resultEntityCollection.get(0);
		
		for(Workspace element: httpBodyResultCollection) {
			if(element.getTitle().equals("T1")) {
				testElement = element; 
			}	
		}
		
		assertEquals(HttpStatus.OK				, httpResult.getStatusCode());
		assertEquals(resultEntityElement.getId(), testElement.getId());
		assertEquals("T1"						, testElement.getTitle());
		assertEquals(WorkspaceType.EDUCATION	, testElement.getType());
		assertEquals("D1"						, testElement.getDescription());
	}
	
	@Test
	public void testUpdateExistingEntity() {
		
		Workspace providedEntity 		= this.provideEntity();
		final int PROVIDED_ENTITY_ID 	= providedEntity.getId();
		
		Workspace updateEntity 		= new Workspace(UPDATE_ENTITY_TITLE, UPDATE_ENTITY_TYPE, UPDATE_ENTITY_DESC);
		ResponseEntity httpResult 	=  this.controller.updateWorkspace(updateEntity, PROVIDED_ENTITY_ID);
		
		assertTrue(httpResult.hasBody());
		HashMap<String, Object> httpBodyResult	= (HashMap<String, Object>) httpResult.getBody();
		Workspace updatedEntity 				= (Workspace)httpBodyResult.get("collection");
		
		assertEquals(HttpStatus.OK			, httpResult.getStatusCode());
		assertEquals(providedEntity.getId()	, updatedEntity.getId());
		assertEquals(UPDATE_ENTITY_TITLE	, updatedEntity.getTitle());
		assertEquals(UPDATE_ENTITY_TYPE		, updatedEntity.getType());
		assertEquals(UPDATE_ENTITY_DESC		, updatedEntity.getDescription());		
	}
	
	@Test
	public void testUpdateNonExistentEntity() {
		
		Workspace updateEntity 		 = new Workspace(UPDATE_ENTITY_TITLE, UPDATE_ENTITY_TYPE, UPDATE_ENTITY_DESC);
		ResponseEntity httpResult 	 =  this.controller.updateWorkspace(updateEntity, FAKE_ID);
		assertEquals(HttpStatus.NOT_FOUND, httpResult.getStatusCode());
	}
	
	@Test
	public void testRemoveExistingEntity() {
		
		Workspace providedEntity 		= this.provideEntity();
		final int PROVIDED_ENTITY_ID 	= providedEntity.getId();
		
		ResponseEntity httpResult 		=  this.controller.removeWorkspace(PROVIDED_ENTITY_ID);
		
		assertTrue(httpResult.hasBody());
		HashMap<String, Object> httpBodyResult	= (HashMap<String, Object>) httpResult.getBody();
		assertEquals(TranslateMessage.WORKFLOW_REMOVE_SUCCESS, httpBodyResult.get("message"));
	}
	
	@Test
	public void testRemoveNonExistingEntity() {
		ResponseEntity httpResult =  this.controller.removeWorkspace(FAKE_ID);
		assertEquals(HttpStatus.NOT_FOUND, httpResult.getStatusCode());
	}
	
	private Workspace provideEntity() {

		Workspace entity = new Workspace(TEST_ENTITY_TITLE,  TEST_ENTITY_TYPE, TEST_ENTITY_DESC);
		return this.workspaceRepository.save(entity);
	}
}
