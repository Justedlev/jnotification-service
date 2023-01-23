package com.justedlev.notification.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMailTemplateRequest {
    @NotNull
    @NotEmpty
    private String templateName;
    @NotNull
    @NotEmpty
    private String template;
}