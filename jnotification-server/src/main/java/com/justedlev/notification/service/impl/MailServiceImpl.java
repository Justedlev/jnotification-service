package com.justedlev.notification.service.impl;

import com.justedlev.notification.component.MailTemplateComponent;
import com.justedlev.notification.model.request.CreateTemplateMailRequest;
import com.justedlev.notification.model.request.SendTemplateMailRequest;
import com.justedlev.notification.model.response.SendTemplateMailResponse;
import com.justedlev.notification.model.response.TemplateMailResponse;
import com.justedlev.notification.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final MailTemplateComponent mailTemplateComponent;

    @Override
    public SendTemplateMailResponse sendFromTemplate(SendTemplateMailRequest request) {
        return mailTemplateComponent.send(request);
    }

    @Override
    public TemplateMailResponse createTemplate(CreateTemplateMailRequest request) {
        return mailTemplateComponent.create(request);
    }
}
