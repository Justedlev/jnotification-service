package com.justedlev.notification.component;

import com.justedlev.notification.model.request.CreateTemplateMailRequest;
import com.justedlev.notification.model.request.SendTemplateMailRequest;
import com.justedlev.notification.model.response.SendTemplateMailResponse;
import com.justedlev.notification.model.response.TemplateMailResponse;

public interface MailTemplateComponent {
    TemplateMailResponse create(CreateTemplateMailRequest request);

    SendTemplateMailResponse send(SendTemplateMailRequest request);
}
