package com.justedlev.notification.configuration;

import com.justedlev.notification.properties.CloudAmqpProperties;
import com.justedlev.notification.properties.JNotificationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({
        JNotificationProperties.class,
        JNotificationProperties.Service.class,
        CloudAmqpProperties.class,
        CloudAmqpProperties.Queues.class
})
public class PropertiesConfiguration {
}
