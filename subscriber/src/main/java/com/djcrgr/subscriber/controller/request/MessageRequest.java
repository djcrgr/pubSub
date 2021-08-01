package com.djcrgr.subscriber.controller.request;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageRequest {
    private long id;
    private long msisdn;
    private String action;
    private int timestamp;
}
