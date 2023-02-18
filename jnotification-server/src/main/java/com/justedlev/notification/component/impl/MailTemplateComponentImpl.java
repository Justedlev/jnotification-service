package com.justedlev.notification.component.impl;

import com.justedlev.notification.component.MailSenderComponent;
import com.justedlev.notification.component.MailTemplateComponent;
import com.justedlev.notification.component.command.SendMailCommand;
import com.justedlev.notification.model.request.CreateTemplateMailRequest;
import com.justedlev.notification.model.request.SendTemplateMailRequest;
import com.justedlev.notification.model.response.SendTemplateMailResponse;
import com.justedlev.notification.model.response.TemplateMailResponse;
import com.justedlev.notification.repository.MailTemplateRepository;
import com.justedlev.notification.repository.entity.MailTemplate;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.Map;
import java.util.function.Function;

@Component
@RequiredArgsConstructor
public class MailTemplateComponentImpl implements MailTemplateComponent {
    private final MailSenderComponent mailSenderComponent;
    private final MailTemplateRepository mailTemplateRepository;
    private final ModelMapper defaultMapper;

    @Override
    public TemplateMailResponse create(CreateTemplateMailRequest request) {
        return mailTemplateRepository.findByName(request.getName())
                .map(current -> defaultMapper.map(current, TemplateMailResponse.class))
                .orElse(createTemplate(request));
    }

    private TemplateMailResponse createTemplate(CreateTemplateMailRequest request) {
        var entity = defaultMapper.map(request, MailTemplate.class);

        return defaultMapper.map(mailTemplateRepository.save(entity), TemplateMailResponse.class);
    }

    @Override
    public SendTemplateMailResponse send(SendTemplateMailRequest request) {
        var mailTemplate = mailTemplateRepository.findByName(request.getTemplateName())
                .orElseThrow(() -> new EntityNotFoundException(
                        String.format("Template %s not exists", request.getTemplateName())));
        var sendMailCommand = SendMailCommand.builder()
                .subject(request.getSubject())
                .recipient(request.getRecipient())
                .body(createBody(mailTemplate.getTemplate(), request.getContent()))
                .build();
        mailSenderComponent.send(sendMailCommand);

        return SendTemplateMailResponse.builder()
                .recipient(request.getRecipient())
                .templateName(request.getTemplateName())
                .build();
    }

    private String createBody(String template, Map<String, String> content) {
        return content.entrySet()
                .stream()
                .map(this::replacerFunction)
                .reduce(Function.identity(), Function::andThen)
                .apply(template);
    }

    private Function<String, String> replacerFunction(Map.Entry<String, String> entry) {
        return current -> current.replace(entry.getKey(), entry.getValue());
    }
}
