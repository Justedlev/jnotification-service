package com.justedlev.notification.listener;

import com.justedlev.notification.component.MailTemplateComponent;
import com.justedlev.notification.model.request.SendTemplateMailRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class NotificationListener {
    private final MailTemplateComponent mailTemplateComponent;

    @RabbitListener(queues = "${cloudamqp.queues.send-template-mail}")
    public void sendTemplateMail(@Payload SendTemplateMailRequest request) {
        try {
            mailTemplateComponent.send(request);
        } catch (Exception e) {
            log.error("Failed to send templated mail: {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
