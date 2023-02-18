package com.justedlev.notification.service;

import com.justedlev.notification.model.request.CreateTemplateMailRequest;
import com.justedlev.notification.model.request.SendTemplateMailRequest;
import com.justedlev.notification.model.response.SendTemplateMailResponse;
import com.justedlev.notification.model.response.TemplateMailResponse;

public interface MailService {
    SendTemplateMailResponse sendFromTemplate(SendTemplateMailRequest request);

    TemplateMailResponse createTemplate(CreateTemplateMailRequest request);
}
