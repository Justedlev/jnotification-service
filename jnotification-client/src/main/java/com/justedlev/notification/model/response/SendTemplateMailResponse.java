package com.justedlev.notification.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SendTemplateMailResponse {
    private String recipient;
    private String templateName;
    private Map<String, String> content;
}
