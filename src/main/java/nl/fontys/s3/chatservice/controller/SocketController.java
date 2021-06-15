package nl.fontys.s3.chatservice.controller;

import nl.fontys.s3.chatservice.MessageBean;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@Controller

public class SocketController {

    @MessageMapping("/user-all")
    @SendTo("/topic/user")
    public MessageBean send(@Payload MessageBean message) {
        return message;
    }
}
