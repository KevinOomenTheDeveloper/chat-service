package nl.fontys.s3.chatservice.controller;

import nl.fontys.s3.chatservice.entity.Message;
import nl.fontys.s3.chatservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    @RolesAllowed("cards-admin")
    public String Message() {
        return "test";
    }
}
