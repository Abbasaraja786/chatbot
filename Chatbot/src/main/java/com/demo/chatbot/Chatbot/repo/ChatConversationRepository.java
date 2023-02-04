package com.demo.chatbot.Chatbot.repo;

import com.demo.chatbot.Chatbot.model.ChatConversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatConversationRepository extends JpaRepository<ChatConversation, Integer> {

    ChatConversation findByConversationId(Integer conversationId);
    
}
