package nl.fontys.s3.chatservice.service;

import nl.fontys.s3.chatservice.entity.Message;
import nl.fontys.s3.chatservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    public Message getMessage(long messageId) {
        return messageRepository.findById(messageId).get();
    }

    public List<Message> getLogs(String userId) {
        return messageRepository.findByUserId(userId);
    }
}