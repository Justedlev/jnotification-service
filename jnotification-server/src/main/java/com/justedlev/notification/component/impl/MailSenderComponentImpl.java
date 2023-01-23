package com.justedlev.notification.component.impl;

import com.justedlev.notification.component.MailSenderComponent;
import com.justedlev.notification.model.request.SendMailTemplateRequest;
import com.justedlev.notification.properties.ServiceProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class MailSenderComponentImpl implements MailSenderComponent {
    private final ServiceProperties serviceProperties;
    private final JavaMailSender emailSender;

    @Override
    public void send(SendMailTemplateRequest request) {
        log.info("Starting to send email : receiver={}", request.getRecipient());
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(serviceProperties.getEmail());
        simpleMailMessage.setTo(request.getRecipient());
        emailSender.send(simpleMailMessage);
        log.info("Mail send successfully completed");
    }
}