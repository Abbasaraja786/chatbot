package com.demo.chatbot.Chatbot.repo;

import com.demo.chatbot.Chatbot.model.ChatFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChatFlowRepository extends JpaRepository<ChatFlow, Integer> {

    ChatFlow findByStepId(Integer stepId);
    ChatFlow findByStepOptions(String option);
}
