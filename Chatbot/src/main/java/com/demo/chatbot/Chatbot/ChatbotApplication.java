package com.demo.chatbot.Chatbot;

import com.demo.chatbot.Chatbot.ui.ChatbotUI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@AutoConfiguration
public class ChatbotApplication  {

	public static void main(String[] args) throws InterruptedException {

		SpringApplication.run(ChatbotApplication.class, args);
		 try {
	            Thread.sleep(5000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    new ChatbotUI();
	}
	
	

}
