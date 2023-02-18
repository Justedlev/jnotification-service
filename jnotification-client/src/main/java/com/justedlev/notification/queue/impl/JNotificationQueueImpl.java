package com.justedlev.notification.queue.impl;

import com.justedlev.notification.model.request.SendTemplateMailRequest;
import com.justedlev.notification.properties.CloudAmqpProperties;
import com.justedlev.notification.queue.JNotificationQueue;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class JNotificationQueueImpl implements JNotificationQueue {
    private final AmqpTemplate amqpTemplate;
    private final CloudAmqpProperties.Queues properties;

    @Override
    public void sendEmail(SendTemplateMailRequest request) {
        amqpTemplate.convertAndSend(properties.getSendTemplateMail(), request);
    }
}
