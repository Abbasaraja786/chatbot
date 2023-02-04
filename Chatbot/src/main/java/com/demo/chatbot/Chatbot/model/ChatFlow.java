package com.demo.chatbot.Chatbot.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "chat_flow")
@NoArgsConstructor
public class ChatFlow {

    @Id
    @Column(name = "step_id")
    private Integer stepId;

    @Column(name = "step_description")
    private String stepDescription;

    public Integer getStepId() {
        return stepId;
    }

    public void setStepId(Integer stepId) {
        this.stepId = stepId;
    }

    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public Integer getNextStepId() {
        return nextStepId;
    }

    public void setNextStepId(Integer nextStepId) {
        this.nextStepId = nextStepId;
    }

    public String getStepOptions() {
        return stepOptions;
    }

    public void setStepOptions(String stepOptions) {
        this.stepOptions = stepOptions;
    }

    @Column(name = "next_step_id")
    private Integer nextStepId;

    @Column(name = "step_options")
    private String stepOptions;

    // Getters and setters omitted for brevity
}
