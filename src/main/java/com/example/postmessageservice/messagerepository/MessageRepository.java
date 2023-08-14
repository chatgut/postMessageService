package com.example.postmessageservice.messagerepository;

import com.example.postmessageservice.messagemodule.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends MongoRepository<Message, String> {



}

