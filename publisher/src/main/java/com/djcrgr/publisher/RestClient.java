package com.djcrgr.publisher;

import com.djcrgr.publisher.service.MessageService;
import com.djcrgr.publisher.entity.MessageBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Component
@Slf4j
public class RestClient {

    private static final String URL = "http://localhost:8080/messages";
    private static final int countThreads = 5;
    private static final RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(countThreads);
        executorService.submit(() -> {
            while (true) {
                MessageBean message = MessageService.getMessage();
                sendMessage(message);
                awaitTimer(15);
            }
        });
    }

    private static void awaitTimer(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Task interrupted", e);
        }
    }

    public static void sendMessage(MessageBean messageBean) {
        restTemplate.postForEntity(URL, messageBean, MessageBean.class);
    }
}
