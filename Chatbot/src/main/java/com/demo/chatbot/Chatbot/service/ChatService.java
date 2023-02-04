package com.demo.chatbot.Chatbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.chatbot.Chatbot.helper.Constants;
import com.demo.chatbot.Chatbot.model.ChatFlow;
import com.demo.chatbot.Chatbot.repo.ChatFlowRepository;

@Service
public class ChatService {

    private final ChatFlowRepository chatFlowRepository;
  @Autowired
  private ChatConversationService chatConversationService;
    
    public ChatService(ChatFlowRepository chatFlowRepository) {
        this.chatFlowRepository = chatFlowRepository;
    }
    public String getStepInfo(Integer currentStepId) {
        try {

            ChatFlow nextStep = chatFlowRepository.findByStepId(currentStepId);
            
            chatConversationService.saveConversation(nextStep); 
            return nextStep.getStepDescription();
        } catch (Exception e) {
            ChatFlow nextStep = chatFlowRepository.findByStepId(7);
            chatConversationService.saveConversation(nextStep); 

            return nextStep.getStepDescription();
        }
    }
    
    public String determineNextStep(String option) {
        try {

            ChatFlow nextStep = chatFlowRepository.findByStepOptions(option);
            chatConversationService.saveConversation(nextStep); 

            return nextStep.getStepDescription();
        } catch (Exception e) {
        	  ChatFlow nextStep = chatFlowRepository.findByStepOptions(Constants.INVALID);
        	  chatConversationService.saveConversation(nextStep); 
            return nextStep.getStepDescription();
        }
    }
    
    

    public String determinePreviousStep( String option) {
        try {
        	ChatFlow nextStep = chatFlowRepository.findByStepOptions(option);
        	chatConversationService.saveConversation(nextStep); 

        	Integer nextStepId = nextStep.getNextStepId();
            ChatFlow previous = chatFlowRepository.findByStepId(nextStepId);
            chatConversationService.saveConversation(previous); 

            return previous.getStepDescription();
        } catch (Exception e) {
        	 ChatFlow nextStep = chatFlowRepository.findByStepId(7);
        	 chatConversationService.saveConversation(nextStep); 

             return nextStep.getStepDescription();
        }
    }
    
   
}
