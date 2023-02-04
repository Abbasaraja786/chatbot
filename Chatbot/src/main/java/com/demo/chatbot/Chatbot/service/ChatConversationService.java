package com.demo.chatbot.Chatbot.service;

import org.springframework.stereotype.Service;

import com.demo.chatbot.Chatbot.model.ChatConversation;
import com.demo.chatbot.Chatbot.model.ChatFlow;
import com.demo.chatbot.Chatbot.repo.ChatConversationRepository;
import com.demo.chatbot.Chatbot.repo.ChatFlowRepository;

@Service
public class ChatConversationService {
	 private final ChatConversationRepository chatConversationRepository;
	 public ChatConversationService(ChatConversationRepository chatConversationRepository) {
	        this.chatConversationRepository = chatConversationRepository;
	    }
	 
	 public void saveConversation(ChatFlow chatFlow) {
	    	
	    	if(chatFlow!=null) {
	    	ChatConversation chatConversation=new ChatConversation();
	    	chatConversation.setStepId(chatFlow.getStepId());
	    	chatConversation.setUserInput(chatFlow.getStepOptions());
	    	chatConversation.setStepDescription(chatFlow.getStepDescription());
	    	chatConversationRepository.save(chatConversation);
	    	}
	    	
	    }
}
