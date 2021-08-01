package com.djcrgr.publisher.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MessageBean {
    private long id;
    private long msisdn;
    private Action action;
    private int timestamp;
}
