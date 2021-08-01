package com.djcrgr.subscriber.controller;

import com.djcrgr.subscriber.controller.request.MessageRequest;
import com.djcrgr.subscriber.model.entity.Action;
import com.djcrgr.subscriber.model.entity.MessageBean;
import com.djcrgr.subscriber.model.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consumer {

    private final MessageService messageService;

    @Autowired
    public Consumer(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public ResponseEntity<String> saveMessage(@RequestBody MessageRequest req) {
        messageService.save(MessageBean.builder()
                .id(req.getId())
                .msisdn(req.getMsisdn())
                .action(Action.getAction(req.getAction()))
                .timestamp(req.getTimestamp())
                .build());
        return ResponseEntity.ok("");
    }
}
