package com.websocketChat.websocketChat.Controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.websocketChat.websocketChat.models.Chat;
import com.websocketChat.websocketChat.models.ChatMessage;

@Controller
public class StompController {

    @MessageMapping("/chat")
    @SendTo("/topic/chat")
    public Chat chat(ChatMessage chat) {
        System.out.println("/chat");
        return  new Chat(chat.getContent());
    }

}
