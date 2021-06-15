package nl.fontys.s3.chatservice.controller;

import nl.fontys.s3.chatservice.VO.MessageVO;
import nl.fontys.s3.chatservice.entity.Message;
import nl.fontys.s3.chatservice.service.MessageService;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/{id}")
    @RolesAllowed("admin")
    public Message getMessage(@PathVariable("id") Long messageId) {
        return messageService.getMessage(messageId);
    }

    @GetMapping("/logs")
    public List<Message> getLogs(HttpServletRequest request) {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal=(KeycloakPrincipal)token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        String id = session.getToken().getSubject();
        return messageService.getLogs(id);
    }

    @PostMapping("/create")
    public Message postMessage(HttpServletRequest request, @RequestBody MessageVO messageVO) {
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) request.getUserPrincipal();
        KeycloakPrincipal principal=(KeycloakPrincipal)token.getPrincipal();
        KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
        String id = session.getToken().getSubject();
        var message = new Message();
        message.setDescription(messageVO.getDescription());
        message.setUserId(id);
        return messageService.saveMessage(message);
    }


}
