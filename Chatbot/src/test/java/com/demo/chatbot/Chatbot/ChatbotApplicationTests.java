package com.demo.chatbot.Chatbot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.chatbot.Chatbot.model.ChatConversation;
import com.demo.chatbot.Chatbot.model.ChatFlow;
import com.demo.chatbot.Chatbot.repo.ChatConversationRepository;
import com.demo.chatbot.Chatbot.repo.ChatFlowRepository;
import com.demo.chatbot.Chatbot.service.ChatConversationService;
import com.demo.chatbot.Chatbot.service.ChatService;

@SpringBootTest
class ChatbotApplicationTests {

	//@InjectMocks
	  private ChatConversationService chatConversationService;

	//@InjectMocks
	  private ChatService chatService;

	  //@Mock
	  private ChatFlowRepository chatFlowRepository;
	  
	  //@Mock
	  private ChatConversationRepository chatConversationRepository;
	  
	  private ChatFlow nextStep;
	  
	//  @Before(value = "")
	  public void setUp() {
	    nextStep = new ChatFlow();
	    nextStep.setStepId(1);
	    nextStep.setStepDescription("Hi! This is LISA. I have a great shift\\\\n\\\\nopportunity for you! Are you\\\\n\\\\nInterested in hearing about it?\\\\n\\\\nPlease respond Yes or No\\\\n\\\\n	\"");
	  }
	@Test
	void contextLoads() {
	}
	
	//@Test
	  public void getStepInfoSuccessTest() {
	    when(chatFlowRepository.findByStepId(1)).thenReturn(nextStep);
	    String result = chatService.getStepInfo(1);
	    assertEquals("Hi! This is LISA. I have a great shift\\\\\\\\n\\\\\\\\nopportunity for you! Are you\\\\\\\\n\\\\\\\\nInterested in hearing about it?\\\\\\\\n\\\\\\\\nPlease respond Yes or No\\\\\\\\n\\\\\\\\n	\\\"", result);
	  }
	
	//@Test
	public void testSaveConversation() {
	    ChatFlow chatFlow = new ChatFlow();
	    chatFlow.setStepId(1);
	    chatFlow.setStepOptions("0");
	    chatFlow.setStepDescription("Hi! This is LISA. I have a great shift\\n\\nopportunity for you! Are you\\n\\nInterested in hearing about it?\\n\\nPlease respond Yes or No\\n\\n	");
	    
	    ChatConversation chatConversation = new ChatConversation();
	    chatConversation.setStepId(chatFlow.getStepId());
	    chatConversation.setUserInput(chatFlow.getStepOptions());
	    chatConversation.setStepDescription(chatFlow.getStepDescription());
	    
	    ChatConversationService chatConversationService = new ChatConversationService(chatConversationRepository);
	    
	    doNothing().when(chatConversationRepository).save(chatConversation);
	    
	    chatConversationService.saveConversation(chatFlow);
	    
	    verify(chatConversationRepository, times(1)).save(chatConversation);
	}

}
