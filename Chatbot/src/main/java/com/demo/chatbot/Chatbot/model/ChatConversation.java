package com.demo.chatbot.Chatbot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "chat_conversation")
@NoArgsConstructor

public class ChatConversation {

    @Id
    @Column(name = "conversation_id")
    @SequenceGenerator(name = "my_sequence_generator", sequenceName = "CHAT_CONVERSATION_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence_generator")

    private Integer conversationId;

    @Column(name = "step_description")
    private String stepDescription;

    @Column(name = "step_id")
    private Integer stepId;

    @Column(name = "user_input")
    private String userInput;

    public Integer getConversationId() {
        return conversationId;
    }

    public void setConversationId(Integer conversationId) {
        this.conversationId = conversationId;
    }

    public String getStepDescription() {
		return stepDescription;
	}

	public void setStepDescription(String stepDescription) {
		this.stepDescription = stepDescription;
	}

	public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    // Getters and setters omitted for brevity
}
