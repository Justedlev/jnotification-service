package com.justedlev.notification.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@Data
@ConfigurationPropertiesScan
@ConfigurationProperties(prefix = "cloudamqp")
public class CloudAmqpProperties {
    private String host;
    private String port;
    private String password;
    private String username;
    private String virtualHost;
    private Queues queues;

    @Data
    @ConfigurationPropertiesScan
    @ConfigurationProperties(prefix = "cloudamqp.queues")
    public static class Queues {
        private String sendTemplateMail;
    }
}
