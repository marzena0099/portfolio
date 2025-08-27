package org.example.portfolio.controller;

import lombok.AllArgsConstructor;
import org.example.portfolio.entity.Message;
import org.example.portfolio.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/messages")
@CrossOrigin(origins = "*")
@AllArgsConstructor
public class MessageController {
private final MessageRepository messageRepository;
@PostMapping
    public Message sendMessage(@RequestBody Message message) {
    return messageRepository.save(message);
}
}
