package com.example.postmessageservice.messageservice;

import com.example.postmessageservice.messagemodule.Message;
import com.example.postmessageservice.messagerepository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageServiceImpl implements MessageService{



    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

//    @Override
//    public String save(Message message) {
//        return messageRepository.save(message).getMessage();
//    }

    @Override
    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getSendersOutbox(String sendersUsername, String receiversUsername, Pageable pageable) {
        return messageRepository.findMessages(sendersUsername, receiversUsername, pageable).getContent();
    }


}
