package com.justedlev.notification.controller;

import com.justedlev.notification.model.request.CreateTemplateMailRequest;
import com.justedlev.notification.model.response.TemplateMailResponse;
import com.justedlev.notification.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/mail")
@RequiredArgsConstructor
@Validated
public class V1MailController {
    private final MailService mailService;

    @PostMapping(value = "/create-template")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<TemplateMailResponse> createTemplate(@Valid @RequestBody CreateTemplateMailRequest request) {
        return ResponseEntity.ok(mailService.createTemplate(request));
    }
}
