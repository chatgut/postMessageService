

package com.example.postmessageservice.messagecontroller;

import com.example.postmessageservice.messagemodule.Message;
import com.example.postmessageservice.messageservice.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin
public class MessageController {

    @Autowired
    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }



    @PostMapping("/post")
    public Message createMessage(@RequestBody Message message) {
        message.setDateAndTime(LocalDateTime.now().toString());
        return messageService.createMessage(message);
    }


    @GetMapping("posts")
    public List<Message> getSendersOutbox(@RequestHeader("userID") String sendersUsername,
                                          @RequestParam String receiversUsername,
                                          @RequestParam(defaultValue = "0") int page,
                                          @RequestParam(defaultValue = "10") int nMessages) {
        Pageable pageable = PageRequest.of(page, nMessages, Sort.by("dateAndTime").descending());


        return messageService.getSendersOutbox(sendersUsername, receiversUsername, pageable);
    }

}

