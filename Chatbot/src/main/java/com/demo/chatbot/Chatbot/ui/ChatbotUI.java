package com.demo.chatbot.Chatbot.ui;

import java.awt.BorderLayout;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.demo.chatbot.Chatbot.helper.Constants;
import com.demo.chatbot.Chatbot.helper.RestCall;

public class ChatbotUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea chatHistory;
	private JTextField messageField;
	private JButton sendButton;
	private JScrollPane scrollPane;
	private static String prevState;
	private static boolean errorState;

	// Load Chat window
	public ChatbotUI() {
		setTitle(Constants.TITLE);
		setSize(600, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		chatHistory = new JTextArea();
		chatHistory.setEditable(false);

		String response = RestCall.getData(1, "data");

		chatHistory.append(hanldeNewLine(response));
		messageField = new JTextField();

		sendButton = new JButton(Constants.BUTTON);
		sendButton.addActionListener(e -> {
			String message = messageField.getText();
			chatHistory.append(Constants.USER + message + "\n\n");
			chatHistory.append(Constants.BOT + respondToUserInput(message) + "\n\n");
			if (errorState) {
				if (prevState == null) {
					chatHistory.append(Constants.BOT+ " "+respondToUserInput("0") + "\n\n");

				} else {
					chatHistory.append(Constants.BOT+" " + handleFailure(prevState) + "\n\n");

				}

			}
			messageField.setText("");
		});

		scrollPane = new JScrollPane(chatHistory);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setFocusable(true);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		add(messageField, BorderLayout.SOUTH);
		add(sendButton, BorderLayout.EAST);
		getRootPane().setDefaultButton(sendButton);

		setVisible(true);
	}

	private String respondToUserInput(String userText) {
		errorState=false;
		String response = RestCall.getData(userText, "options");
		if(response!=null && response.contains("sorry")) {
			errorState=true;
		}
		if(!errorState)
		prevState=userText;
		return hanldeNewLine(response);
	}
	private String handleFailure(String userText) {
		errorState=false;
		String response = RestCall.getNextStepData(userText, "fail");
		if(response!=null && response.contains("sorry")) {
			errorState=true;
		}
		if(!errorState)
		prevState=userText;
		return hanldeNewLine(response);
	}


	private static String hanldeNewLine(String response) {
		String lineSeparator = System.getProperty("line.separator");
		String decodedString = null;
		String result = "";
		try {
			decodedString = URLDecoder.decode(response, StandardCharsets.UTF_8.name());
			result = decodedString.replaceAll("\n", lineSeparator);

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
}
