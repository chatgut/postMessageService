package com.example.postmessageservice.messageservice;

import com.example.postmessageservice.messagemodule.Message;
import com.example.postmessageservice.messagerepository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Message save(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Page<Message> search(String sendersUsername, String receiversUsername, Pageable pageable) {

        Query query = new Query().with(pageable);
         List<Criteria> criteria = new ArrayList<>();

         if (sendersUsername !=null && !sendersUsername.isEmpty()) {
             criteria.add(Criteria.where("sendersUsername").regex(receiversUsername,"i"));
         }

        if (sendersUsername !=null && receiversUsername !=null) {

            criteria.add(Criteria.where("sendersUsername").in(0,1)
                    .and("receiversUsername").in(1,0));
        }

        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria()
                    .andOperator(criteria.toArray(new Criteria[0])));
        }
        Page<Message> messagesInbox = PageableExecutionUtils.getPage(
                mongoTemplate.find(query, Message.class
                ), pageable, () -> mongoTemplate.count(query.skip(0).limit(0), Message.class)
        );

        return messagesInbox;
    }


//    public MessageServiceImpl(MessageRepository messageRepository) {
//        this.messageRepository = messageRepository;
//    }

}
