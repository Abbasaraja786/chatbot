package com.demo.chatbot.Chatbot.controller;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.chatbot.Chatbot.service.ChatService;

@RestController
@RequestMapping("/api")
public class ChatbotController {
	
	@Autowired
	private ChatService chatService;
	
	@GetMapping("/data/{id}")
    public ResponseEntity<String> getData(@PathVariable("id") Integer id) {
		String description = chatService.getStepInfo(id);
		
        return ResponseEntity.ok(description);
    }
	
	@GetMapping("/options/{info}")
    public ResponseEntity<String> getDataOnOptions(@PathVariable("info") String option) {
		String description = chatService.determineNextStep(option);
		
        return ResponseEntity.ok(description);
    }
    
	@GetMapping("/fail/{info}")
	  public ResponseEntity<String> getPreviousData(@PathVariable("info") String option) {
			String description = chatService.determinePreviousStep(option);
			
	        return ResponseEntity.ok(description);
	    }
}
