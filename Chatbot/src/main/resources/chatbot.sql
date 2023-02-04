CREATE TABLE chat_flow (
  step_id INT PRIMARY KEY,
  step_description VARCHAR(255),
  next_step_id INT,
  step_options VARCHAR(255)
);

INSERT INTO chat_flow (step_id, step_options, next_step_id, step_description)
VALUES (1, '0', 1, 'Hi! This is LISA. I have a great shift\n\nopportunity for you! Are you\n\nInterested in hearing about it?\n\nPlease respond Yes or No\n\n'),
(2, 'Yes', 1, 'Great the shift is at 1313\n\n Mockingbird Ln \n\n at 2/15/2021 4:00pm-12:00am.\n\n We''ll see you there!\n\n'),
(3, 'No', 1, 'Ok, thanks. Can you let\n\nme know why not?\n\nRespond 1: Too far\n\nRespond 2: Not available\n\nRespond 3: Other\n\n'),
(4, '1', 3, 'Thanks for letting\n\nme know. I''ll avoid\n\noffering shifts at\n\nthis location in the\n\n'),
(5, '2', 3, 'Thanks for letting\n\nme know. I''ll avoid\n\noffering shifts at\n\nthis time in the\n\n'),
(6, '3', 3, 'Ok. Thanks. I\n\nwon''t offer shifts\n\nat this location or\n\ntime in the future. \n'),
(7, 'Invalid', 1, 'I''m sorry, I didn''t\n\nunderstand your\n\nresponse. \n\n\n')
;


CREATE TABLE chat_conversation (
  conversation_id INT PRIMARY KEY,
  step_description VARCHAR(255) ,
  step_id INT,
  user_input VARCHAR(255)
);

CREATE SEQUENCE CHAT_CONVERSATION_SEQ
START WITH 1
INCREMENT BY 1;