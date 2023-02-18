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
public class CreateTemplateMailRequest {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String template;
}
