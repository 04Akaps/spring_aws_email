package com.example.demo.common.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailProperties {
    public static String url;

    @Value("${office.url}")
    public void setOfficeUrl(String value) {
        MailProperties.url = value;
    }
}
