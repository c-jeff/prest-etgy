package com.rpost.jsilva.services;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rpost.jsilva.model.Page;

@Service
public class PageService {
	
	public String reshape(String input) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			Page page = mapper.readValue(input, Page.class);
			
			String output = mapper.writeValueAsString(page);
			//System.out.println(output);
			
			return output;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "JSON Error";
		}
	}
}
