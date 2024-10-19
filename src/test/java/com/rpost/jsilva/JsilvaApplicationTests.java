package com.rpost.jsilva;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rpost.jsilva.services.PageService;

@SpringBootTest
class JsilvaApplicationTests {

	@Autowired
	private PageService pageService;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void returnTypeString() {
		var result = pageService.reshape("{\"test\": 1}");
		assertTrue(result instanceof String);
	}

}
