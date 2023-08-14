package com.example.postmessageservice.messageservice;

import com.example.postmessageservice.messagemodule.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MessageService {
    Message save(Message message);

    Page<Message> search(String sendersUsername, String receiversUsername, Pageable pageable);
}
