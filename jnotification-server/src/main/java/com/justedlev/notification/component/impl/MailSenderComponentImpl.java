package com.justedlev.notification.component.impl;

import com.justedlev.notification.component.MailSenderComponent;
import com.justedlev.notification.component.command.SendMailCommand;
import com.justedlev.notification.properties.JNotificationProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MailSenderComponentImpl implements MailSenderComponent {
    private final JNotificationProperties.Service properties;
    private final JavaMailSender emailSender;

    @Override
    public void send(SendMailCommand command) {
        var simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(properties.getEmail());
        simpleMailMessage.setTo(command.getRecipient());
        simpleMailMessage.setCc(properties.getEmail());
        simpleMailMessage.setSubject(command.getSubject());
        simpleMailMessage.setText(command.getBody());
        emailSender.send(simpleMailMessage);
        log.info("Mail send successfully completed");
    }
}
