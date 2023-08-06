package com.example.postmessageservice.messageservice;

import com.example.postmessageservice.messagemodule.Message;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MessageService {
//    String save(Message message);


//    List<Message> getSendersOutbox(String sendersUsername, String receiversUsername, Pageable paging);


    Message createMessage(Message message);


    List<Message> getSendersOutbox(String sendersUsername, String receiversUsername, Pageable pageable);
}
