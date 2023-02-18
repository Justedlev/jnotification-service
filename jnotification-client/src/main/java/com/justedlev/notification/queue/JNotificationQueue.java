package com.justedlev.notification.queue;

import com.justedlev.notification.model.request.SendTemplateMailRequest;

public interface JNotificationQueue {
    void sendEmail(SendTemplateMailRequest request);
}
