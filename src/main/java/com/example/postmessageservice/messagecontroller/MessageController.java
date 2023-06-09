package com.example.postmessageservice.messagecontroller;

import com.example.postmessageservice.messagemodule.Message;
import com.example.postmessageservice.messagerepository.MessageRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
@RestController
@RequestMapping("/")
public class MessageController {

    private final MessageRepository repository;


    public MessageController(MessageRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/posts")
    public Message createMessage(@RequestBody Message message) {
        message.setDateAndTime(LocalDateTime.now().toString());
        return repository.save(message);
    }


    @GetMapping("/posts")
    public List<com.example.postmessageservice.messagemodule.Message> getMessages(@RequestHeader("userID") String sendersUsername,
                                                                                  @RequestParam String receiversUsername,
                                                                                  @RequestParam(defaultValue = "0") int page,
                                                                                  @RequestParam(defaultValue = "10") int nMessages) {
        Pageable paging = PageRequest.of(page, nMessages, Sort.by("dateAndTime").descending());


        return repository.findMessages(sendersUsername, receiversUsername, paging).getContent();
    }

}