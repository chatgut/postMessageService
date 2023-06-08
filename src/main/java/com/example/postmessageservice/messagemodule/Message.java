package com.example.postmessageservice.messagemodule;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "messages")
public class Message {


    @Id
    private String id;

    private String sendersUsername;
    private String receiversUsername;

    private String message;

    private String dateAndTime;

    public Message() {}
    public Message(String id, String sendersUsername, String receiversUsername, String message, String dateAndTime) {
        this.id = id;
        this.sendersUsername = sendersUsername;
        this.receiversUsername = receiversUsername;
        this.message = message;
        this.dateAndTime = dateAndTime;
    }
    @Override
    public String toString() {
        return "Message{" +
                "id='" + id + '\'' +
                ", sendersUsername='" + sendersUsername + '\'' +
                ", receiversUsername='" + receiversUsername + '\'' +
                ", message='" + message + '\'' +
                ", dateAndTime='" + dateAndTime + '\'' +
                '}';
    }
}