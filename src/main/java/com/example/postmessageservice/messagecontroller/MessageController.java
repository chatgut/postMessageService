

package com.example.postmessageservice.messagecontroller;

import com.example.postmessageservice.messagemodule.Message;
import com.example.postmessageservice.messageservice.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api")
public class MessageController {



    @Autowired
    private MessageService messageService;


    @PostMapping("/post")
    public String save(@RequestBody Message message) {
        message.setDateAndTime(LocalDateTime.now().toString());

        return messageService.save(message).getId();
    }


    @GetMapping("/inbox")
    public Page<Message> inboxMessage(@RequestHeader String sendersUsername,
                                      @RequestParam String receiversUsername,
                                      @RequestParam(defaultValue = "0") Integer page,
                                      @RequestParam(defaultValue = "5")Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("dateAndTime").descending());

            return messageService.search(sendersUsername, receiversUsername, pageable);
    }
}

